package com.nhs.bsa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
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
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        RegularAmount regularAmount = new RegularAmount(
                new Amount(1,1), Frequency.TWO_WEEK);
        validator.validate(regularAmount).stream().forEach(violation -> log.info("HELP!!!!!" + violation.getMessage()));

	}

}
