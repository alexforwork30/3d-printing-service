package com.printingservice.dtos.common.response;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorMessageRes {
  private Integer statusCode;
  private Date timestamp;
  private String message;
  private String description;
}
