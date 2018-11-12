package com.nhs.bsa;

//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BsaApplicationTests {

    private ExecutableValidator executableValidator;

    @Before
    public void getExecutableValidator() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.executableValidator = factory.getValidator()
                .forExecutables();
    }

    @Test
    public void whenCrossParameterValidationWithValidConstructorParameters_thenZeroVoilations() throws NoSuchMethodException {

        Constructor<RegularAmount> constructor = RegularAmount.class.getConstructor(Amount.class, Frequency.class);
        Object[] parameterValues = { new Amount(1,1), Frequency.WEEK};
        Set<ConstraintViolation<RegularAmount>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues);

        assertEquals(0, violations.size());
    }

    @Test
    public void whenCrossParameterValidationWithInvalidConstructorParameters_thenCorrectNumberOfVoilations() throws NoSuchMethodException {

        Constructor<RegularAmount> constructor = RegularAmount.class.getConstructor(Amount.class, Frequency.class);
        Object[] parameterValues = { new Amount(1,1), Frequency.TWO_WEEK};
        Set<ConstraintViolation<RegularAmount>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues);

        assertEquals(1, violations.size());
    }

}
