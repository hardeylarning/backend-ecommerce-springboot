package com.rochtech.ecommerce.dto;

import lombok.Data;
// final or @NotNull
@Data
public class PurchaseResponse {
   private final String orderTrackingNumber;
}
