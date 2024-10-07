package io.santiagovogit.carwashmetro.domain.cell.value_objects;

import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;


public enum SpaceNumber {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10");

    private final String value;

    SpaceNumber(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SpaceNumber fromValue(String value) {
        if (isEmpty(value)) {
            throw new DomainException(ErrorMsg.SPACE_NUMBER_EMPTY.getMessage());
        }
        for (SpaceNumber status : SpaceNumber.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new DomainException(ErrorMsg.INVALID_SPACE_NUMBER.getMessage());
    }

}