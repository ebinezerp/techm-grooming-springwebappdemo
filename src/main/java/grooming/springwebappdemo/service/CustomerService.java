package grooming.springwebappdemo.service;

import java.util.List;

import grooming.springwebappdemo.dto.Customer;

public interface CustomerService {
	public Customer save(Customer customer);
	public Customer update(Customer customer);
	public Customer get(Long id);
	public Customer get(String email, String password);
	public List<Customer> get();
	public boolean delete(Long id);
}
