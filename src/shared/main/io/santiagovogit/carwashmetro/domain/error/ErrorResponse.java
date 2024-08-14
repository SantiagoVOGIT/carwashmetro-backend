package io.santiagovogit.carwashmetro.domain.error;

import java.util.*;

public class ErrorResponse {

    private final String errorId;
    private final ErrorType errorType;
    private final String message;
    private final Map<String, Object> details;
    private final List<ErrorResponse> relatedErrors;

    private ErrorResponse(Builder builder) {
        this.errorId = UUID.randomUUID().toString();
        this.errorType = builder.errorType;
        this.message = builder.message;
        this.details = Collections.unmodifiableMap(new HashMap<>(builder.details));
        this.relatedErrors = Collections.unmodifiableList(new ArrayList<>(builder.relatedErrors));
    }

    public String getErrorId() {
        return errorId;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public List<ErrorResponse> getRelatedErrors() {
        return relatedErrors;
    }

    public static class Builder {

        private ErrorType errorType;
        private String message;
        private Map<String, Object> details = new HashMap<>();
        private List<ErrorResponse> relatedErrors = new ArrayList<>();

        public Builder withErrorType(ErrorType errorType) {
            this.errorType = errorType;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withDetails(Map<String, Object> details) {
            this.details = details;
            return this;
        }

        public Builder withRelatedErrors(List<ErrorResponse> relatedErrors) {
            this.relatedErrors = relatedErrors;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this);
        }
    }

}