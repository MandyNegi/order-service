package com.CodePipeline.order_serviceDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/orders")
@SpringBootApplication
public class OrderServiceDemoApplication {

	@Autowired
	private OderDao orderDao;

	@GetMapping
	public List<Order> fetchOrders() {
		return orderDao.getOrders().stream().
				sorted(Comparator.comparing(Order::getPrice)).collect(Collectors.toList());
	}


	public static void main(String[] args) {
		SpringApplication.run(OrderServiceDemoApplication.class, args);
	}

}
