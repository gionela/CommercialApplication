package gr.innovativecommercial.startup.repositories;

import gr.innovativecommercial.startup.models.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {}
