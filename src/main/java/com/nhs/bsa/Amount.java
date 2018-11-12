package com.nhs.bsa;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Amount {

    /**
     * Assume any currency will have a main unit (eg Pound) and subunit (e.g Pence)
     * This also works if there is only a main unit if such currency exists.
     */

    final int mainUnit;
    final int subUnit;

    public int convertUKAmountToPence() {
        return (mainUnit * 60) + subUnit;
    }

}
