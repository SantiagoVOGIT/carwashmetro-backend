package io.santiagovogit.carwashmetro.domain.employee.value_objects;


import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import java.util.Objects;

import static io.santiagovogit.carwashmetro.domain.StringDomainUtils.isSalaryFormat;

public class Salary {

    private static final Integer MIN_SALARY = 0;
    private static final Integer MAX_SALARY = 50000000;

    private final Integer value;

    public Salary(Integer value) {
        validateSalary(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static void validateSalary(Integer salary) {
        if (Objects.equals(salary, MIN_SALARY)) {
            throw new DomainException(ErrorType.SALARY_NULL.getMessage());
        }
        if (salary <= MIN_SALARY || salary > MAX_SALARY) {
            throw new DomainException(ErrorType.INVALID_SALARY_RANGE.getMessage());
        }
        if (!isSalaryFormat(String.valueOf(salary))) {
            throw new DomainException(ErrorType.INVALID_SALARY_FORMAT.getMessage());
        }
    }

}