package io.santiagovogit.carwashmetro.domain.common;

import java.util.regex.Pattern;

public final class DomainUtils {

    private DomainUtils(){}

    private static final Pattern DNI_NUMBER_PATTERN = Pattern.compile("^\\d{5,10}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{3,40}$");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^(3\\d{9}|(\\d{1,2})\\d{7})$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    private static final Pattern LICENSE_PLATE_PATTERN = Pattern.compile("^[A-Z]{3}\\d{3}$|^[A-Z]{3}\\d{2}$|^[A-Z]" +
            "{3}\\d{2}[A-Z]$|^\\d{3}[A-Z]{3}$|^[A-Z]\\d{5}$|^[A-Z]{2}\\d{4}$|^[A-Z]{2}\\d{5}$|^[A-Z]{2}\\d{6}$");
    private static final Pattern MODEL_PATTERN = Pattern.compile("^[A-Za-z0-9\\s-]{1,50}$");
    private static final Pattern SALARY_PATTERN = Pattern.compile("^\\d{1,8}$");
    private static final Pattern UUID_PATTERN = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

    public static boolean isDniNumberFormat(String str) {
        return DNI_NUMBER_PATTERN.matcher(str).matches();
    }

    public static boolean isUUIDFormat(String str) {
        return UUID_PATTERN.matcher(str).matches();
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

}