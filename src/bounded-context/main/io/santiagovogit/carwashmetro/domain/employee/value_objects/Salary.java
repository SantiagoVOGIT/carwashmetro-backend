package io.santiagovogit.carwashmetro.domain.employee.value_objects;


import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.DomainException;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isNull;
import static io.santiagovogit.carwashmetro.domain.common.DomainUtils.isSalaryFormat;

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
        if (isNull(salary)) {
            throw new DomainException(ErrorMsg.SALARY_NULL.getMessage());
        }
        if (salary <= MIN_SALARY || salary > MAX_SALARY) {
            throw new DomainException(ErrorMsg.INVALID_SALARY_RANGE.getMessage());
        }
        if (!isSalaryFormat(String.valueOf(salary))) {
            throw new DomainException(ErrorMsg.INVALID_SALARY_FORMAT.getMessage());
        }
    }


}