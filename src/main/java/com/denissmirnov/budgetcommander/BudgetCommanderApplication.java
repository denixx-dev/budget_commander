package com.denissmirnov.budgetcommander;

import com.denissmirnov.budgetcommander.models.ApplicationUser;
import com.denissmirnov.budgetcommander.models.Role;
import com.denissmirnov.budgetcommander.repository.RoleRepository;
import com.denissmirnov.budgetcommander.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BudgetCommanderApplication{

	public static void main(String[] args) {
		SpringApplication.run(BudgetCommanderApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
		return args -> {
			if (roleRepository.findByAuthority("ADMIN").isPresent()) return;

			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncoder.encode("password"), roles);

			userRepository.save(admin);
		};
	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry){
//		registry.addViewController("/").setViewName("auth/login");
//	}

}
