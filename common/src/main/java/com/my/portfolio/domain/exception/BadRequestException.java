package com.my.portfolio.domain.exception;

public class BadRequestException extends RuntimeException {

  public BadRequestException(String message) {
    super(message);
  }

  public BadRequestException() {}

  public BadRequestException(String message, Throwable cause) {
    super(message, cause);
  }
}
