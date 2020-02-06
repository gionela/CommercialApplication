package gr.innovativecommercial.startup.controllers;

import gr.innovativecommercial.startup.dtos.CustomerDto;
import gr.innovativecommercial.startup.models.Customer;
import gr.innovativecommercial.startup.models.CustomerOrder;
import gr.innovativecommercial.startup.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Null objects, not existing objects and other kind of errors and exceptions are not handled or implemented in this version
 */

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    /**
     *task 1.3
     * @return a list of all Customers
     */
    @GetMapping("customers")
    public List<Customer> getAllCustomersController(){
        return customerService.getAll();
    }

    /**
     * task 1.1
     * @param id of customer
     * @return one customer
     */
    @GetMapping("customer/{id}")
    public Customer getCustomerController(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("customer/{id}/orders")
    public List<CustomerOrder> getCustomerOrdersController(@PathVariable int id) {
        return customerService.getCustomerOrders(id);
    }
    /**
     * task 1.4
     * @param id
     * @param customerDto
     * @return an existing customer after it updates his address and/or name
     */

    @PutMapping("customer/{id}")
    public Customer updateCustomerController(@PathVariable int id, CustomerDto customerDto){
        return customerService.updateCustomer(id,customerDto);
    }

    /**
     * task 1.2
     * @param customerDto
     * @return a new customer
     */
    @PostMapping("/customer")
    public Customer newCustomerController(@RequestBody CustomerDto customerDto) {
        return customerService.saveNewCustomer(customerDto);
    }

    /**
     *
     * @param id
     * @return a message if the specific customer was successfully deleted
     */
    @DeleteMapping("customer/{id}")
    public String deleteCustomerByIdController(@PathVariable int id){
        customerService.deleteCustomerById(id);
        return "Customer successfully deleted";
    }
    @DeleteMapping("customers")
    public String deleteAllCustomerController(){
        customerService.deleteAllCustomer();
        return "All customers were deleted";
    }

    /**
     *
     * @param name of the customer
     * @return all customers with that name
     */
    @GetMapping("customers/name/{name}")
    public List<Customer> getCustomerByNameController(@PathVariable String name){
        return customerService.getCustomersByName(name);
    }

    /**
     *
     * @param id of a customer
     * @return updates the field "active" of customer and sets him inactive
     */
    @PutMapping("customers/inactive/{id}")
    public Customer softDeleteController(@PathVariable int  id){
        return customerService.softDeleteCustomer(id);
    }

    @GetMapping("customers/pageSize/{pageSize}/page/{pageNumber}")
    public List<Customer> getCustomersByPageController(@PathVariable int pageSize, @PathVariable int pageNumber){
        return customerService.getCustomersByPage(pageSize,pageNumber);
    }

}
