package dev.Byrdman32.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static dev.Byrdman32.annotation.ExecutedDays.Day.ALL_DAYS;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ExecutedDays {
    Day day() default ALL_DAYS;

    enum Day {
        ALL_DAYS,
        DAY_01, DAY_02, DAY_03, DAY_04, DAY_05,
        DAY_06, DAY_07, DAY_08, DAY_09, DAY_10,
        DAY_11, DAY_12, DAY_13, DAY_14, DAY_15,
        DAY_16, DAY_17, DAY_18, DAY_19, DAY_20,
        DAY_21, DAY_22, DAY_23, DAY_24, DAY_25;

        public static String getDayRepresentation(Day day) {
            var ordinal = day.ordinal();
            return ordinal < 10 ? "0%s".formatted(ordinal) : String.valueOf(ordinal);
        }
    }
}