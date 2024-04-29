package com.printingservice.components;

import com.printingservice.constants.ErrorConstants;
import com.printingservice.dtos.common.response.ErrorMessage;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RequiredArgsConstructor
public class HandleControllerException {
  private final Environment environment;

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessage> handleException(Exception exception, WebRequest request) {
    if (environment.getActiveProfiles()[0].equals("prod")) {
      return ResponseEntity.status(500)
          .body(
              ErrorMessage.builder()
                  .statusCode(500)
                  .timestamp(new Date())
                  .message(ErrorConstants.ERROR_MESSAGE)
                  .description(ErrorConstants.ERROR_DESCRIPTION)
                  .build());
    }
    return ResponseEntity.status(500)
        .body(
            ErrorMessage.builder()
                .statusCode(500)
                .timestamp(new Date())
                .message(exception.getMessage())
                .description(request.getDescription(false))
                .build());
  }
}
