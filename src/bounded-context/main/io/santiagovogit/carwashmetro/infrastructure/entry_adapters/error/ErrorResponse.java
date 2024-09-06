package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.error;


import java.time.LocalDateTime;

public class ErrorResponse {

    private final ErrorId errorId;
    private final String error;
    private final String message;
    private final String details;
    private final LocalDateTime timestamp;
    private final int status;

    private ErrorResponse(
            ErrorId errorId,
            String error,
            String message,
            String details,
            LocalDateTime timestamp,
            int status) {
        this.errorId = errorId;
        this.error = error;
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
        this.status = status;
    }

    public String getErrorId() {
        return errorId.getValue();
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public static ErrorResponse.Builder builder() {
        return new ErrorResponse.Builder();
    }

    public static class Builder {

        private ErrorId errorId;
        private String error;
        private String message;
        private String details = "";
        private LocalDateTime timestamp;
        private int status;

        public Builder errorId(ErrorId errorId) {
            this.errorId = errorId;
            return this;
        }

        public Builder error(String error) {
            this.error = error;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder details(String details) {
            this.details = details;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(
                    this.errorId,
                    this.error,
                    this.message,
                    this.details,
                    this.timestamp,
                    this.status
            );
        }
    }

}