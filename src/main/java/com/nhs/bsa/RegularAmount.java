package com.nhs.bsa;

import com.nhs.bsa.annotation.CheckRegularAmountParameters;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;

@Data
@RequiredArgsConstructor(onConstructor = @__(@CheckRegularAmountParameters))
@Slf4j
@Validated
public class RegularAmount {
    final private Amount amount;
    final Frequency frequency;

}
