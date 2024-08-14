package io.santiagovogit.carwashmetro.domain;

import java.util.regex.Pattern;

public final class StringDomainUtils {

    private StringDomainUtils(){}

    private static final Pattern DNI_NUMBER_PATTERN = Pattern.compile("^\\d{10}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-zÀ-ÿ\\s]{1,50}$");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\+?\\d{10,14}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    private static final Pattern LICENSE_PLATE_PATTERN = Pattern.compile("^[A-Z0-9]{1,7}$");
    private static final Pattern MODEL_PATTERN = Pattern.compile("^[A-Za-z0-9\\s-]{1,50}$");
    private static final Pattern SALARY_PATTERN = Pattern.compile("^\\d{1,8}$");
    private static final Pattern TIMESTAMP_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d{1,9})?([+-]\\d{2}:\\d{2}|Z)$");

    public static boolean isDniNumberFormat(String str) {
        return DNI_NUMBER_PATTERN.matcher(str).matches();
    }

    public static boolean isNameFormat(String str) {
        return NAME_PATTERN.matcher(str).matches();
    }

    public static boolean isLastnameFormat(String str) {
        return NAME_PATTERN.matcher(str).matches();
    }

    public static boolean isPhoneNumberFormat(String str) {
        return PHONE_NUMBER_PATTERN.matcher(str).matches();
    }

    public static boolean isEmailFormat(String str) {
        return EMAIL_PATTERN.matcher(str).matches();
    }

    public static boolean isLicensePlateFormat(String str) {
        return LICENSE_PLATE_PATTERN.matcher(str).matches();
    }

    public static boolean isModelFormat(String str) {
        return MODEL_PATTERN.matcher(str).matches();
    }

    public static boolean isSalaryFormat(String str) {
        return SALARY_PATTERN.matcher(str).matches();
    }

    public static boolean isTimestampFormat(String str) {
        return TIMESTAMP_PATTERN.matcher(str).matches();
    }

}