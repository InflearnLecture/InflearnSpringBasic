package com.example.inflearnbasic.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
