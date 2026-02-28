package com.services.kafka.order.service;

import com.services.kafka.order.data.dto.OrderDTO;
import com.services.kafka.order.data.entity.Order;
import com.services.kafka.order.enums.OrderStatus;
import com.services.kafka.order.repository.OrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final KafkaTemplate<String, OrderDTO> kafkaTemplate;
    private final OrderRepository orderRepository;

    public OrderService(KafkaTemplate<String, OrderDTO> kafkaTemplate, OrderRepository orderRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.orderRepository = orderRepository;
    }

    public String createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setAmount(orderDTO.getAmount());
        order.setStatus(OrderStatus.CREATED);

        orderRepository.save(order);

        kafkaTemplate.send("order-created", orderDTO);

        return "Order created with ID: " + order.getId();
    }
}
