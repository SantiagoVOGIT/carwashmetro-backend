package io.santiagovogit.carwashmetro.domain.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    private final I18nService i18nService;

    public ExceptionHandler(I18nService i18nService) {
        this.i18nService = i18nService;
    }

    public ErrorResponse handle(Throwable throwable) {
        if (throwable instanceof DomainException) {
            return handleDomainException((DomainException) throwable);
        }
        return handleUnexpectedException(throwable);
    }

    private ErrorResponse handleDomainException(DomainException exception) {
        logger.error("Domain exception occurred", exception);
        return new ErrorResponse.Builder()
                .withErrorType(exception.getErrorType())
                .withMessage(i18nService.translate(exception.getMessageKey()))
                .withDetails(exception.getDetails())
                .build();
    }

    private ErrorResponse handleUnexpectedException(Throwable throwable) {
        logger.error("Unexpected exception occurred", throwable);
        return new ErrorResponse.Builder()
                .withErrorType(ErrorType.UNEXPECTED_ERROR)
                .withMessage(i18nService.translate("error.unexpected"))
                .withDetails(Map.of("originalError", throwable.getMessage()))
                .withRelatedErrors(extractRelatedErrors(throwable))
                .build();
    }

    private List<ErrorResponse> extractRelatedErrors(Throwable throwable) {
        List<ErrorResponse> relatedErrors = new ArrayList<>();
        Throwable cause = throwable.getCause();
        while (cause != null) {
            relatedErrors.add(new ErrorResponse.Builder()
                    .withErrorType(ErrorType.UNEXPECTED_ERROR)
                    .withMessage(cause.getMessage())
                    .withDetails(Map.of("exceptionType", cause.getClass().getName()))
                    .build());
            cause = cause.getCause();
        }
        return relatedErrors;
    }

}