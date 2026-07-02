package com.service;

import com.Invoice.GenerateInvoice;
import com.model.Cart;
import com.model.Order;
import com.model.User;
import com.repository.OrderRepository;
import com.repository.UserRepository;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class OrderService {


        private final OrderRepository orderRepository;
        private final GenerateInvoice invoice;
        private final UserRepository userRepository;

        public OrderService(OrderRepository orderRepository,
                            GenerateInvoice invoice,
                            UserRepository userRepository) {

            this.orderRepository = orderRepository;
            this.invoice = invoice;
            this.userRepository = userRepository;
        }


    private String assignDeliveryPartner() {

        ArrayList<User> partners = new ArrayList<>();

        for(User user : userRepository.getUsers()){

            if(user.getRole().equalsIgnoreCase("DELIVERY_PARTNER")){
                partners.add(user);
            }
        }

        if(partners.isEmpty()){
            return null;
        }

        Random random = new Random();

        return partners.get(random.nextInt(partners.size())).getId();
    }

        public void placeOrder(User user, Cart cart) {

            if (cart.isEmpty()) {

                System.out.println("Cart is empty. Cannot place order!");
                return;
            }

            String orderId = generateOrderId();

            Order order = new Order(
                    orderId,
                    user.getId(),
                    cart.getItems(),
                    cart.getTotal()
            );
            order.setDeliveryPartnerId(assignDeliveryPartner());

            orderRepository.addOrder(order);

            invoice.generate(order);

            cart.clear();
        }

        private String generateOrderId() {

            return "ORD-"
                    + UUID.randomUUID()
                    .toString()
                    .substring(0, 6)
                    .toUpperCase();
        }

}
