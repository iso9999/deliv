package com.ensa.deliveroo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void run(String... args) throws Exception {
		productRepository.findAll().forEach(c-> {
			System.out.println(c.getLabel());
		});
		
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//init db
//		categoryRepository.save(new Category("Electornics"));
//		categoryRepository.save(new Category("Beauty & Personal Care"));
//		categoryRepository.save(new Category("Books"));	
//		categoryRepository.save(new Category("Software"));
//		
//		Product p1 = new Product("DELL", 55, 15000, "deep.png", categoryRepository.getOne((long) 1));
//		Product p2 = new Product("HP PROBOOK", 55, 15000, "ep.png", categoryRepository.getOne((long) 1));
//
//		
//		productRepository.save(new Product("SAMSUNG", 55, 15000, "h.png", categoryRepository.getOne((long) 1)));
//		productRepository.save(new Product("HARRY POTTER all parts", 5500, 1000, "hdep.png", categoryRepository.getOne((long) 3)));
//		
//		
//		clientRepository.save(new Client("ismail", "manareddine", "ismail.manared@gmail.com"));
//		clientRepository.save(new Client("Abdelilah", "soudani", "abdel2@gmail.com"));
//		clientRepository.save(new Client("Abdelilah", "haijoub", "abdeilah@gmail.com"));
//		clientRepository.save(new Client("Abdelah", "drissi", "drissiiii@gmail.com"));
		
//		Order order  = new Order(dateFormat.parse("14/01/2019"));
//		orderRepository.save(order);*;
//		Order o = orderRepository.getOne((long) 12);
		

		
		
//		System.out.println("12345654321..... ");
//		
//		
//		clientRepository.findAll().forEach(c->{
//			System.out.println(c.getEmail());
//		});
//		Optional<Client> c = clientRepository.findById( (long) 9);
//		Client cc = c.get();
//		System.out.println(cc.getId());
//		System.out.println("12345654321..... ");
		
//		Order order = new Order(dateFormat.parse("14/01/2019"), cc);
//		
//		order.addProduct(p1, 5);
//		order.addProduct(p2, 10);
//		orderRepository.save(order);
//		productRepository.save(p1);
//		productRepository.save(p2);
//		
		
		
//		Order order2 = new Order(dateFormat.parse("04/02/2018"), cc);
//		
//		Product p3 = productRepository.findById((long) 32).get();
//		Product p4 = productRepository.findById((long) 21).get();
//		
//		order2.addProduct(p3, 5);
//		order2.addProduct(p4, 51);
//		orderRepository.save(order2);
		
		
		
		
		
//				orderRepository.findAll().forEach(c->{
//					System.out.println(c.getDate() + "mmmmmmpvjeijnobnojtbnet");
//				});
	}
	
}

