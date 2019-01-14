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
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//init db
		categoryRepository.save(new Category("Electornics"));
		categoryRepository.save(new Category("Beauty & Personal Care"));
		categoryRepository.save(new Category("Books"));	
		categoryRepository.save(new Category("Software"));
		
		productRepository.save(new Product("DELL", 55, 15000, "deep.png", categoryRepository.getOne((long) 1)));
		productRepository.save(new Product("HP PROBOOK", 55, 15000, "ep.png", categoryRepository.getOne((long) 1)));
		productRepository.save(new Product("SAMSUNG", 55, 15000, "h.png", categoryRepository.getOne((long) 1)));
		productRepository.save(new Product("HARRY POTTER all parts", 5500, 1000, "hdep.png", categoryRepository.getOne((long) 3)));
		
		
		clientRepository.save(new Client("ismail", "manareddine", "ismail.manared@gmail.com"));
		clientRepository.save(new Client("Abdelilah", "soudani", "abdel2@gmail.com"));
		clientRepository.save(new Client("Abdelilah", "haijoub", "abdeilah@gmail.com"));
		clientRepository.save(new Client("Abdelah", "drissi", "drissiiii@gmail.com"));
		
//		Order order  = new Order(dateFormat.parse("14/01/2019"));
//		orderRepository.save(order);*;
//		Order o = orderRepository.getOne((long) 12);
		

		
		
		System.out.println("12345654321..... ");
		
		
		clientRepository.findAll().forEach(c->{
			System.out.println(c.getEmail());
		});
		Optional<Client> c = clientRepository.findById( (long) 9);
		Client cc = c.get();
		System.out.println(cc.getId());
		
		Order order = new Order(dateFormat.parse("14/01/2019"), cc);
//		
		List<Product> p = productRepository.findAll();
		System.out.println(p.get(0).getId());
//		
		Product p1 = p.get(0);
		Product p2 = p.get(2);
		
		order.addProduct(p1, 5);
		order.addProduct(p2, 10);
//		System.out.println("12345654321..... ");
//		
		orderRepository.save(order);
		productRepository.save(p1);
		productRepository.save(p2);
		
		
		
//		order.addProduct(p.get(2), 10);
		
//				orderRepository.findAll().forEach(c->{
//					System.out.println(c.getDate() + "mmmmmmpvjeijnobnojtbnet");
//				});
	}
	
}

