package com.printingservice.dtos.common;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class BaseEntityDto {
  private Date createdAt;
  private Date updatedAt;
}
