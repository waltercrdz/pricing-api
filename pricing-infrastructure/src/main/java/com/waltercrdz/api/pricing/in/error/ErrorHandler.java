package com.waltercrdz.api.pricing.in.error;

import com.waltercrdz.api.pricing.domain.exception.DatabaseConnectionException;
import com.waltercrdz.api.pricing.domain.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException e) {
        LOGGER.error("Illegal argument exception: ", e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiError.fromException(ErrorCode.ILLEGAL_ARGUMENT, e));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiError> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        LOGGER.error("Bad Request: ", e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiError.fromException(ErrorCode.MISSING_PARAMETER, e));
    }

    @ExceptionHandler(DatabaseConnectionException.class)
    public ResponseEntity<ApiError> handleDatabaseConnectionException(DatabaseConnectionException e) {
        LOGGER.error("Database connection exception: ", e);
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(ApiError.fromDomainException(e));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleUnexpectedException(Exception e) {
        LOGGER.error("Unexpected exception: ", e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiError.fromException(e));
    }
}
