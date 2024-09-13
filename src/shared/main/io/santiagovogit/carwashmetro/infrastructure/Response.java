package io.santiagovogit.carwashmetro.infrastructure;


import java.time.LocalDateTime;

public class Response {

    private final String message;
    private final String details;
    private final LocalDateTime timestamp;

    private Response(String message, String details, LocalDateTime timestamp) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
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

    public static Response.Builder builder() {
        return new Response.Builder();
    }

    public static class Builder {

        private String message;
        private String details;
        private LocalDateTime timestamp;

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

        public Response build() {
            return new Response(
                    this.message,
                    this.details,
                    this.timestamp
            );
        }
    }

}