package com.rochtech.ecommerce.controller;

import com.rochtech.ecommerce.dto.Purchase;
import com.rochtech.ecommerce.dto.PurchaseResponse;
import com.rochtech.ecommerce.service.CheckOutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckOutService checkOutService;

    public CheckoutController(CheckOutService checkOutService) {
        this.checkOutService = checkOutService;
    }

    @PostMapping("purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        return checkOutService.placeOrder(purchase);
    }


}
