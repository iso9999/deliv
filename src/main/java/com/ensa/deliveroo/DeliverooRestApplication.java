package com.ensa.deliveroo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ensa.deliveroo.dao.CategoryRepository;
import com.ensa.deliveroo.dao.ClientRepository;
import com.ensa.deliveroo.dao.OrderRepository;
import com.ensa.deliveroo.dao.ProductRepository;
import com.ensa.deliveroo.entities.Category;
import com.ensa.deliveroo.entities.Client;
import com.ensa.deliveroo.entities.Order;
import com.ensa.deliveroo.entities.Product;

@SpringBootApplication
public class DeliverooRestApplication implements CommandLineRunner{
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	public static void main(String[] args) {
		SpringApplication.run(DeliverooRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// add cats
//		categoryRepository.save(new Category("Electornics"));
//		categoryRepository.save(new Category("Beauty & Personal Care"));
//		categoryRepository.save(new Category("Books"));	
//		categoryRepository.save(new Category("Software"));
//		
//		productRepository.save(new Product("DELL", 55, 15000, "hdeep.png", categoryRepository.getOne((long) 1)));
//		clientRepository.save(new Client("Abdelilah", "soudani", "abdel2@gmail.com"));
//		Order order  = new Order(dateFormat.parse("14/01/2019"));
//		orderRepository.save(order);*;
//		Order o = orderRepository.getOne((long) 12);
		
		System.out.println("12345654321..... ");
		
		
		Client c = clientRepository.getOne((long) 12);
		
		System.out.println(c.getEmail());
		
//				orderRepository.findAll().forEach(c->{
//					System.out.println(c.getDate() + "mmmmmmpvjeijnobnojtbnet");
//				});
	}
	
}

