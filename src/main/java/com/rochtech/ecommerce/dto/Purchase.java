package com.rochtech.ecommerce.dto;

import com.rochtech.ecommerce.entity.Address;
import com.rochtech.ecommerce.entity.Customer;
import com.rochtech.ecommerce.entity.Order;
import com.rochtech.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;

}
