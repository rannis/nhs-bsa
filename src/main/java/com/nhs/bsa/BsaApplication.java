package com.nhs.bsa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Slf4j
public class BsaApplication {


	public static void main(String[] args) {
		SpringApplication.run(BsaApplication.class, args);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        ExecutableValidator executableValidator = factory.getValidator().forExecutables();

		RegularAmount regularAmount = new RegularAmount(
				null, null);
//		log.info("Regular amount in pence: " + regularAmount.getAmount().convertUKAmountToPence());
	}



    private static void getExecutableValidator() {


    }
}
