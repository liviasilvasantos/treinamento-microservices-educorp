package br.unicamp.educorp.microservices.cursos.api.aula4.jwt.security;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.unicamp.educorp.microservices.cursos.api.aula4.jwt.model.Usuario;
import br.unicamp.educorp.microservices.cursos.api.aula4.jwt.repository.UsuariosRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UsuariosRepository usuarioRepository;

	public UserDetailsServiceImpl(UsuariosRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		// localiza usuário no repository
		Usuario usuarioRepo = usuarioRepository.findByUsuario(usuario);

		if (usuarioRepo == null) {
			throw new UsernameNotFoundException(usuario);
		}

		return new User(usuarioRepo.getUsuario(), usuarioRepo.getSenha(), Collections.emptyList());
	}

}
