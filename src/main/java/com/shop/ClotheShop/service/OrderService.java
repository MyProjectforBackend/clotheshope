package com.shop.ClotheShop.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.ClotheShop.domain.Order;
import com.shop.ClotheShop.dto.OrderDTO;
import com.shop.ClotheShop.repository.OrderRepository;

@Service

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAllOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Integer id) {
        return orderRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public OrderDTO createOrder(OrderDTO dto) {
        Order order = toEntity(dto);
        return toDTO(orderRepository.save(order));
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    private OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setIdOrder(order.getIdOrder());
        dto.setIdUser(order.getIdUser());
        dto.setOrderDate(order.getOrderDate());
        dto.setTotalPrise(order.getTotalPrise());
        dto.setAddressId(order.getAddressId());
        return dto;
    }

    private Order toEntity(OrderDTO dto) {
        Order order = new Order();
        order.setIdUser(dto.getIdUser());
        order.setOrderDate(dto.getOrderDate());
        order.setTotalPrise(dto.getTotalPrise());
        order.setAddressId(dto.getAddressId());
        return order;
    }
}
