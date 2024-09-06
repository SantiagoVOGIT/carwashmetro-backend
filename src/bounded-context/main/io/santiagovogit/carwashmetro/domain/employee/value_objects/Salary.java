package io.santiagovogit.carwashmetro.domain.employee.value_objects;


import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import static io.santiagovogit.carwashmetro.domain.StringDomainUtils.isSalaryFormat;
import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isNull;

public class Salary {

    private static final int MIN_SALARY = 0;
    private static final int MAX_SALARY = 50000000;

    private final int value;

    private Salary(int value) {
        this.value = value;
    }

    public static Salary of(Integer salary) {
        if (isNull(salary)){
            return null;
        }
        validateSalary(salary);
        return new Salary(salary);
    }

    public int getValue() {
        return value;
    }

    private static void validateSalary(int salary) {
        if (salary <= MIN_SALARY || salary > MAX_SALARY) {
            throw new DomainException(ErrorType.INVALID_SALARY_RANGE.getMessage());
        }
        if (!isSalaryFormat(String.valueOf(salary))) {
            throw new DomainException(ErrorType.INVALID_SALARY_FORMAT.getMessage());
        }
    }

}