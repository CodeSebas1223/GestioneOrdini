package com.example.ordini.gesOrdini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GesOrdiniApplication extends SpringBootServletInitializer{
		
	public static void main(String[] args) {
		SpringApplication.run(GesOrdiniApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GesOrdiniApplication.class);
    }

}
