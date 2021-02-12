package br.unicamp.educorp.microservices.cursos.api.aula4.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.educorp.microservices.cursos.api.aula4.jwt.model.ApplicationUser;
import br.unicamp.educorp.microservices.cursos.api.aula4.jwt.repository.ApplicationUserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }
}
