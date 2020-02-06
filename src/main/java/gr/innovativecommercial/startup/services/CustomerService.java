package gr.innovativecommercial.startup.services;

import gr.innovativecommercial.startup.dtos.CustomerDto;
import gr.innovativecommercial.startup.models.Customer;
import gr.innovativecommercial.startup.models.CustomerOrder;
import gr.innovativecommercial.startup.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(int id) {
        return customerRepository.findById(id).get();

    }

    /**
     * using StreamSupport to create and manipulate the streams.
     * @return a list of all customers
     */
    public List<Customer> getAll() {
        return StreamSupport
                .stream(customerRepository
                        .findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<CustomerOrder> getCustomerOrders(int id) {
        return customerRepository.findById(id).get().getOrders();
    }

    /**
     * Using a foreach loop instead of streams
     * @param name
     * @return a list of all customers with that name.
     */
    public List<Customer> getCustomersByName(String name) {
        List<Customer> customers = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            if (customer.getName().equals(name))
                customers.add(customer);
            else continue;
        }
        return customers;
    }


    public Customer saveNewCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setDob(new Date(customerDto.getYearBirth(), customerDto.getMonthBirth(), 1));

        return customerRepository.save(customer);
    }

    /**
     *
     * @param id
     * @param customerDto
     * takes an existing customer
     * @return updates his address plus his name if it is not null
     */
    public Customer updateCustomer(int id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id).get();
        if (customer == null) return null;
        customer.setAddress(customerDto.getAddress());
        if (customerDto.getName() != null)
            customer.setName(customerDto.getName());
        return customerRepository.save(customer);
    }

    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }

    public void deleteAllCustomer() {
        customerRepository.deleteAll();
    }

    public Customer softDeleteCustomer(int id) {
        Customer customer = customerRepository.findById(id).get();
        if (customer == null)
            return null;
        customer.setActive(false);
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomersByPage(int pageSize, int pageNumber){
        Pageable pageOfRequestedElements = PageRequest.of(pageNumber, pageSize);
        return customerRepository.findAll(pageOfRequestedElements).toList();

    }

}
