package com.luccaspereira.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luccaspereira.workshopmongo.domain.Post;
import com.luccaspereira.workshopmongo.domain.User;
import com.luccaspereira.workshopmongo.dto.AuthorDTO;
import com.luccaspereira.workshopmongo.repository.PostRepository;
import com.luccaspereira.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		repository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		repository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo abraços", new AuthorDTO(maria));
		Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei Feliz Hoje",new AuthorDTO(maria));
		
		
		postRepository.saveAll(Arrays.asList(p1,p2));

	}

}
