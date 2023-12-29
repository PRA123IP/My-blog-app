package com.myblogApp;

import com.myblogApp.Entity.Role;
import com.myblogApp.Repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyBlogAppApplication  implements CommandLineRunner
		{
	@Autowired
	private RoleRepository roleRepository;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


	public static void main(String[] args) {
		SpringApplication.run(MyBlogAppApplication.class, args);



	}

	@Override
	public void run(String... args) throws Exception {

		Role adrole=new Role();
		adrole.setName("ROLE_ADMIN");
		roleRepository.save(adrole);

		Role userrole=new Role();
		userrole.setName("ROLE_USER");
		roleRepository.save(userrole);

	}
}
