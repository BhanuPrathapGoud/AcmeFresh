package com.masai.service;

import java.util.List;

import com.masai.model.Orders;

public interface OrderService {
	public List<Orders> getAllOrdersList();
	public Orders getOrdersById(int Id);
	public String createOrders(Orders orders);
	public Orders deleteOrdersById(int id);
	public Orders updateOrdersById(int id, Orders orders);
}
