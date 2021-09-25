package br.com.cadastroapi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cadastroapi.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);

}