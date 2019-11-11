package org.store.service.customer;

import org.store.domain.Customer;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {
    //this map is being used as replacement of db
    static private Map<Integer,Customer>customerMap;
    {
        customerMap = new HashMap<>();
        Customer customer1=new Customer();
        customer1.setCustId(1);
        customer1.setCustName("arif");
        customer1.setCustType(1);
        customer1.setSignUpDate(new Date());
        customerMap.put(1,customer1);
        Customer customer2=new Customer();
        customer2.setCustId(2);
        customer2.setCustName("arif");
        customer2.setCustType(2);
        customer2.setSignUpDate(new Date());
        customerMap.put(2,customer2);
        Customer customer3=new Customer();
        customer3.setCustId(3);
        customer3.setCustName("arif");
        customer3.setCustType(3);
        customer3.setSignUpDate(new Date());
        customerMap.put(3,customer3);
        Customer customer4=new Customer();
        Calendar cal = Calendar.getInstance();

        cal.setTime(new Date());
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 2);
        Date time2hrsback=cal.getTime();
        customer4.setCustId(4);
        customer4.setCustName("arif");
        customer4.setCustType(4);
        customer4.setSignUpDate(time2hrsback);
        customerMap.put(4,customer4);
    }
    @Override
    public List<Customer> getCustomers() {
        return (List<Customer>)customerMap.values();
    }

    @Override
    public Customer getCustomerByCustId(int custId) {
        return customerMap.get(custId);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerMap.put(customer.getCustId(), customer);
    }
}
