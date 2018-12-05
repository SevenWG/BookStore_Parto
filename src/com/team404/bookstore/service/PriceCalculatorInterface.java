package com.team404.bookstore.service;

import com.team404.bookstore.entity.OrderEntity;
import com.team404.bookstore.entity.ShoppingCartEntity;

import java.util.List;
/*
 * Implementation of Facade Pattern
 * */
public interface PriceCalculatorInterface {
    public float CalculateTotalPrice(List<ShoppingCartEntity> list);
    public OrderEntity setMorePriceValues(OrderEntity orderEntity, int userid);
}
