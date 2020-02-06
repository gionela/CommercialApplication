package gr.innovativecommercial.startup.repositories;

import gr.innovativecommercial.startup.models.CustomerOrder;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<CustomerOrder, Integer> {

}
