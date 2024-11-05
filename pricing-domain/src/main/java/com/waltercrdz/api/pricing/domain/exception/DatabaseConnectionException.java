package com.waltercrdz.api.pricing.domain.exception;

public class DatabaseConnectionException extends DomainException {

        public DatabaseConnectionException(String message, Throwable cause) {
            super(message, ErrorCode.DATABASE_CONNECTION_ERROR, cause);
        }
}
