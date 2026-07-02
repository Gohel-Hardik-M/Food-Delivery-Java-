package com.service;

import com.model.Order;
import com.model.User;
import com.repository.OrderRepository;

import java.util.ArrayList;

public class DeliveryPartnerService {




        private final OrderRepository orderRepository;

        public DeliveryPartnerService(OrderRepository orderRepository) {

            this.orderRepository = orderRepository;
        }

        public ArrayList<Order> getAvailableOrders(User partner) {

            ArrayList<Order> orders = new ArrayList<>();

            for(Order order : orderRepository.getOrders()){

                if(order.getDeliveryPartnerId()!=null &&
                        order.getDeliveryPartnerId().equals(partner.getId()) &&
                        order.getStatus().equalsIgnoreCase("Pending")){

                    orders.add(order);
                }
            }

            return orders;
        }

        public ArrayList<Order> getMyOrders(User partner){

            ArrayList<Order> orders = new ArrayList<>();

            for(Order order : orderRepository.getOrders()){

                if(order.getDeliveryPartnerId()!=null &&
                        order.getDeliveryPartnerId().equals(partner.getId())){

                    orders.add(order);
                }
            }

            return orders;
        }

        public boolean acceptOrder(String orderId,User partner){

            for(Order order : orderRepository.getOrders()){

                if(order.getOrderId().equals(orderId)
                        &&
                        order.getDeliveryPartnerId().equals(partner.getId())
                        &&
                        order.getStatus().equalsIgnoreCase("Pending")){

                    order.setStatus("Accepted");

                    return true;
                }
            }

            return false;
        }

        public boolean markPickedUp(String orderId,User partner){

            for(Order order : orderRepository.getOrders()){

                if(order.getOrderId().equals(orderId)
                        &&
                        order.getDeliveryPartnerId().equals(partner.getId())
                        &&
                        order.getStatus().equalsIgnoreCase("Accepted")){

                    order.setStatus("Picked Up");

                    return true;
                }
            }

            return false;
        }

        public boolean markDelivered(String orderId,User partner){

            for(Order order : orderRepository.getOrders()){

                if(order.getOrderId().equals(orderId)
                        &&
                        order.getDeliveryPartnerId().equals(partner.getId())
                        &&
                        order.getStatus().equalsIgnoreCase("Picked Up")){

                    order.setStatus("Delivered");

                    return true;
                }
            }

            return false;
        }


}
