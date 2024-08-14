package io.santiagovogit.carwashmetro.domain.employee.value_objects;

import io.santiagovogit.carwashmetro.domain.StringDomainUtils;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorMessage;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotNull;

public class Salary {

    private static final int MIN_SALARY = 0;
    private static final int MAX_SALARY = 50000000;

    private final int value;

    private Salary(int value) {
        this.value = value;
    }

    public static Salary of(Integer salary) {
        validateNotNull(salary, ErrorMessage.SALARY_NULL.getMessage());
        validateSalary(salary);
        return new Salary(salary);
    }

    public int getValue() {
        return value;
    }

    private static void validateSalary(int salary) {
        if (salary <= MIN_SALARY || salary > MAX_SALARY) {
            throw new DomainException(
                    ErrorType.VALIDATION_ERROR,
                    ErrorMessage.INVALID_SALARY_RANGE.getMessage()
            );
        }
        if (!StringDomainUtils.isSalaryFormat(String.valueOf(salary))) {
            throw new DomainException(
                    ErrorType.VALIDATION_ERROR,
                    ErrorMessage.INVALID_SALARY_FORMAT.getMessage()
            );
        }
    }

}