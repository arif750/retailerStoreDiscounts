package org.store.service.customer;

import org.store.domain.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
    public Customer getCustomerByCustId(int custId);
    public Customer addCustomer(Customer customer);

}
