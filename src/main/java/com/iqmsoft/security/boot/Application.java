package com.iqmsoft.security.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.iqmsoft.security.boot.domain.Role;
import com.iqmsoft.security.boot.domain.User;
import com.iqmsoft.security.boot.repository.UserRepository;

@Configuration
@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan({"com.iqmsoft.security.boot"})
@EnableJpaRepositories(basePackages = {
        "com.iqmsoft.security.boot.repository"
})
public class Application extends SpringBootServletInitializer implements CommandLineRunner{

	@Autowired
	UserRepository repouser;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

	@Override
	public void run(String... arg0) throws Exception {
		
		User u = new User();
		
		u.setEmail("demo@localhost.com");
		u.setPasswordHash("$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C");
		
		u.setRole("ADMIN");
		
		if(repouser.findAll().isEmpty())
		{
		  repouser.save(u);
		}
		
	}

}