package br.com.cadastroapi.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.cadastroapi.repository.UsuarioRepository;

@EnableWebSecurity
@Configuration 
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	
	@Autowired
	AutenticacaoService autenticacaoService;
	
	@Autowired
	private TokenService tokenService;	
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	//Configuracoes de autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//Configuracoes de autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/pessoas").permitAll()
		.antMatchers(HttpMethod.GET, "/pessoas/*").permitAll()
		.antMatchers(HttpMethod.POST, "/pessoas").permitAll()
		.antMatchers(HttpMethod.POST, "/pessoas/*").permitAll()
		.antMatchers(HttpMethod.PUT, "/pessoas/*").permitAll()
		.antMatchers(HttpMethod.DELETE, "/pessoas/*").permitAll().anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, repository), UsernamePasswordAuthenticationFilter.class);		
	}
	
	//Configuracoes de recursos estaticos (JS, imagens, CSS ...)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
	}
	
}