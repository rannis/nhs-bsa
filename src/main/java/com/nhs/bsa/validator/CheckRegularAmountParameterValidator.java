package com.nhs.bsa.validator;

import com.nhs.bsa.Amount;
import com.nhs.bsa.Frequency;
import com.nhs.bsa.annotation.CheckRegularAmountParameters;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@Slf4j
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CheckRegularAmountParameterValidator implements
        ConstraintValidator<CheckRegularAmountParameters, Object[]> {


    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext constraintValidatorContext) {
        if ( value.length != 2 ) {
            throw new IllegalArgumentException( "Illegal method signature" );
        }

        if ( value[0] == null || value[1] == null ) {
            log.info("CheckRegularAmountParameterValidator NULL");
            return true;
        }

        if ( !( value[0] instanceof Amount) || !( value[1] instanceof Frequency) ) {
            throw new IllegalArgumentException(
                    "Illegal method signature, expected two " +
                            "parameters of type Date."
            );
        }
        int amountInPence =  ((Amount) value[0]).convertUKAmountToPence();
        log.info(String.format("convert amount to pence: %d and frequency: %d weeks. Is it divisible? Remainder %d"
                , amountInPence, ((Frequency)value[1]).getValue(), amountInPence%((Frequency)value[1]).getValue()));
        return ( amountInPence%((Frequency)value[1]).getValue()==0 );
    }


}
