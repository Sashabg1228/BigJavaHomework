package com.example.bigjavahomework.mappers;

import com.example.bigjavahomework.resources.OrdersResource;
import com.example.bigjavahomework.entityes.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrdersMapper {
    OrdersMapper ORDERS_MAPPER = Mappers.getMapper(OrdersMapper.class);

    Orders fromOrdersResource(OrdersResource ordersResource);

    OrdersResource toOrdersResource(Orders orders);

    List<OrdersResource> toOrdersResources(List<Orders> orders);
}