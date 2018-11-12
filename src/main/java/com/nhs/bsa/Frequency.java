package com.nhs.bsa;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Frequency {
    FOUR_WEEK(4),
    MONTH(4),
    QUARTER(13),
    TWO_WEEK(2),
    WEEK(1),
    YEAR(52);

    @Getter private int value;

}
