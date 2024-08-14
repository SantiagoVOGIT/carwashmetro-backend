package io.santiagovogit.carwashmetro.domain.employee.value_objects;

import io.santiagovogit.carwashmetro.domain.StringDomainUtils;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorMessage;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import java.math.BigDecimal;

public class Salary {

    private static final BigDecimal MIN_SALARY = new BigDecimal("0");
    private static final BigDecimal MAX_SALARY = new BigDecimal("50000000");

    private final BigDecimal value;

    private Salary(BigDecimal value) {
        this.value = value;
    }

    public static Salary of(BigDecimal value) {
        validateSalary(value);
        return new Salary(value);
    }

    public static Salary createSalary(String value){
       return Salary.of(new BigDecimal(value));
    }

    private static void validateSalary(BigDecimal salary) {
        if (salary == null) {
            throw new DomainException(
                    ErrorType.VALIDATION_ERROR,
                    ErrorMessage.SALARY_NULL.getMessage()
            );
        }
        if (salary.compareTo(MIN_SALARY) <= 0 || salary.compareTo(MAX_SALARY) > 0) {
            throw new DomainException(
                    ErrorType.VALIDATION_ERROR,
                    ErrorMessage.INVALID_SALARY_RANGE.getMessage()
            );
        }
        if (!StringDomainUtils.isSalaryFormat(salary.toPlainString())) {
            throw new DomainException(
                    ErrorType.VALIDATION_ERROR,
                    ErrorMessage.INVALID_SALARY_FORMAT.getMessage()
            );
        }
    }

    public BigDecimal getValue() {
        return value;
    }

}