package com.brandon.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.brandon.cardatabase.domain.Car;
import com.brandon.cardatabase.domain.CarRepository;
import com.brandon.cardatabase.domain.Owner;
import com.brandon.cardatabase.domain.OwnerRepository;
import com.brandon.cardatabase.domain.User;
import com.brandon.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication {

	// Inject repositories
	@Autowired
	private UserRepository urepository;
	
	@Autowired
	private CarRepository crepository;
	
	@Autowired
	private OwnerRepository orepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			
			Owner owner1 = new Owner("Joe", "Johnson");
			Owner owner2 = new Owner("Steve", "Nash");
			orepository.save(owner1);
			orepository.save(owner2);
			

			crepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
			crepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			crepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));
		

			urepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
			urepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));

		};
	}

}
