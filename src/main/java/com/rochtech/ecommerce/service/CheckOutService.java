package com.rochtech.ecommerce.service;

import com.rochtech.ecommerce.dto.Purchase;
import com.rochtech.ecommerce.dto.PurchaseResponse;

public interface CheckOutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
