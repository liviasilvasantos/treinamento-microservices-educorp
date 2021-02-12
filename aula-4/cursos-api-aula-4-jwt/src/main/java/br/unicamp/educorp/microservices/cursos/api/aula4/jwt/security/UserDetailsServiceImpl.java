package br.unicamp.educorp.microservices.cursos.api.aula4.jwt.security;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.unicamp.educorp.microservices.cursos.api.aula4.jwt.model.ApplicationUser;
import br.unicamp.educorp.microservices.cursos.api.aula4.jwt.repository.ApplicationUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private ApplicationUserRepository applicationUserRepository;

	public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
		this.applicationUserRepository = applicationUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// localiza usuário no repository
		ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);

		if (applicationUser == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User(applicationUser.getUsername(), applicationUser.getPassword(), Collections.emptyList());
	}

}
