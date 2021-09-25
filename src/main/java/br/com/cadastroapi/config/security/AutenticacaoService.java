package br.com.cadastroapi.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.cadastroapi.modelo.Usuario;
import br.com.cadastroapi.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> userOptional = this.usuarioRepository.findByEmail(username); 
		if (userOptional.isPresent())
			return userOptional.get();
		throw new UsernameNotFoundException("Dados inválidos!");
	}

}