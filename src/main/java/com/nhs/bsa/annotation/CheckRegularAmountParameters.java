package com.nhs.bsa.annotation;

import com.nhs.bsa.validator.CheckRegularAmountParameterValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CheckRegularAmountParameterValidator.class)
@Target({ METHOD, CONSTRUCTOR, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface CheckRegularAmountParameters {

    /**
     *
     * @return key message
     */
    String message() default "{com.nhs.bsa.annotation.CheckRegularAmountParameters.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
