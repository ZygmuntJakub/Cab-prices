package com.nbd.nbd;

import com.datastax.driver.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbdApplication.class, args);
	}
}

