package com.my.portfolio.application.exception.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

  private final Instant timestamp;

  private final int status;

  private final String message;

  private List<ValidationError> errors;

  public ErrorResponse(Instant timestamp, int status, String message) {
    this.timestamp = timestamp;
    this.status = status;
    this.message = message;
  }

  @Getter
  @Setter
  private static class ValidationError {
    private final String field;
    private final String message;

    public ValidationError(String field, String message) {
      this.field = field;
      this.message = message;
    }
  }

  public void addValidationError(String field, String message) {
    if (Objects.isNull(errors)) {
      errors = new ArrayList<>();
    }
    errors.add(new ValidationError(field, message));
  }
}
