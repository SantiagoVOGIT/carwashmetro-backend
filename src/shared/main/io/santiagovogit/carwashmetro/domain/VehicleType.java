package io.santiagovogit.carwashmetro.domain;

public enum VehicleType {

    CAR("AUTOMOVIL"),
    MOTORCYCLE("MOTOCICLETA");

    private final String value;

    VehicleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static VehicleType fromValue(String value) {
        return EnumUtils.fromValue(VehicleType.class, value, VehicleType::getValue);
    }

}
