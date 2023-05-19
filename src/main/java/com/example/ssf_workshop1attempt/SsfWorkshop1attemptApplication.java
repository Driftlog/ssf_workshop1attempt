package com.example.ssf_workshop1attempt;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SsfWorkshop1attemptApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SsfWorkshop1attemptApplication.class, args);
		SpringApplication app = new SpringApplication(SsfWorkshop1attemptApplication.class);

		DefaultApplicationArguments appArgs = new DefaultApplicationArguments();
		List<String> argsList = appArgs.getOptionValues("port");

		String portNo = "3000";

		if (!(argsList == null)) {	
			if (!(argsList.get(0) == null || argsList.isEmpty())) {
				portNo = argsList.get(0);}

		} else if (!(System.getenv("PORT") == null)) {
			portNo = System.getenv("PORT");
		}

		if (portNo != null) {
			app.setDefaultProperties(Collections.singletonMap("server.port", portNo));
		}

		System.out.println("Server running on port: " + portNo );
		app.run(args);

	}

}
