package com.ensa.deliveroo.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.deliveroo.dao.CategoryRepository;
import com.ensa.deliveroo.dao.ClientRepository;
import com.ensa.deliveroo.dao.OrderRepository;
import com.ensa.deliveroo.dao.ProductRepository;
import com.ensa.deliveroo.entities.Client;
import com.ensa.deliveroo.entities.Order;
import com.ensa.deliveroo.entities.Product;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsonorg.JsonOrgModule;


@RestController
@CrossOrigin(origins = "*")
public class BORestService {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value="/products" , method =RequestMethod.GET)
	public List<Product> getProducts()
	{
		return productRepository.findAll();
	}
	
	@RequestMapping(value="/product/{id}" , method =RequestMethod.GET)
	public Optional<Product> getProduct(@PathVariable Long id)
	{
		return productRepository.findById(id);
	}
	
	
	@RequestMapping(value="/product" , method =RequestMethod.POST)
	public Product saveProduct(@RequestBody ProductBean p)
	{
		Product product  =new Product(p.getLabel(), p.getQuantity(), p.getPrice(), p.getImg_url());
		return productRepository.save(product);
	}
	
	
	@RequestMapping(value="/product/{id}" , method =RequestMethod.PUT)
	public Product setProduct(@PathVariable Long id, @RequestBody ProductBean p)
	{
		Product product  =new Product(p.getLabel(), p.getQuantity(), p.getPrice(), p.getImg_url());
		product.setId(id);
		return productRepository.save(product);
	}
	
	@RequestMapping(value="/product/{id}", method=RequestMethod.DELETE)
	public boolean deleteProduct(@PathVariable Long id) {
		productRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(@RequestBody ProductBean beanTest) {
        return "Hello " + beanTest.getLabel();
    }
	
	
	@RequestMapping(value="/orders" , method =RequestMethod.GET)
	public List<Order> getOrders()
	{
		List<Order> o = orderRepository.findAll();
		
		return orderRepository.findAll();
	}
	
	@RequestMapping(value="/order/{id}" , method =RequestMethod.GET)
	public Optional<Order> getOrder(@PathVariable Long id)
	{
		return orderRepository.findById(id);
	}
	
	@RequestMapping(value="/order/{id}", method=RequestMethod.DELETE)
	public boolean deleteOrder(@PathVariable Long id) {
		orderRepository.deleteById(id);
		return true;
	}
	
//	@RequestMapping(value="/order/{id}" , method =RequestMethod.PUT)
//	public String setOrder(@PathVariable Long id, @RequestBody String order) throws JsonParseException, JsonMappingException, IOException
//	{
//		
//		 ObjectMapper mapper = new ObjectMapper();
//	        mapper.registerModule(new JsonOrgModule());
//	        Order model = mapper.readValue(order, Order.class);
//	        
//		return order;
//	}
	
	@RequestMapping(value="/order/{id}" , method =RequestMethod.PUT)
	public Order setOrder(@PathVariable Long id, @RequestBody Order order) throws JsonParseException, JsonMappingException, IOException
	{
		
	        order.setId(id);
		return orderRepository.save(order);
	}
	
	@RequestMapping(value="/order" , method =RequestMethod.POST)
	public Order addOrder(@RequestBody Order order)
	{
		Client client = new Client(order.getClient().getFirstName(), order.getClient().getLastName(), order.getClient().getEmail());
		client=clientRepository.save(client);
		order.setClient(client);
		
		return orderRepository.save(order);
//		return order;
	}
	
}
