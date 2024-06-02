package com.printingservice.dtos.productrequest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModifyProductRequestReq {
  private String description;
  private String fileUrl;
}
