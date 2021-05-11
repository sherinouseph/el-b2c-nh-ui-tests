package com.englishtown.enumpack;

/**
 * Enum Util
 *
 * Nikol Apr 2018
 *
 */
public class EnumUtil {
    /**
     * Finds the value of the given enumeration by name, case-insensitive.
     * Throws an IllegalArgumentException if no match is found.
     **/
    public static <T extends Enum<T>> T valueOfIgnoreCase(
            Class<T> enumeration, String name) {

        for (T enumValue : enumeration.getEnumConstants()) {
            if (enumValue.name().equalsIgnoreCase(name)) {
                return enumValue;
            }
        }

        throw new IllegalArgumentException(String.format(
                "There is no value with name '%s' in Enum %s",
                name, enumeration.getName()
        ));
    }
}
