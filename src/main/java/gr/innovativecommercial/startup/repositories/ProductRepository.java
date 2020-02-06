package gr.innovativecommercial.startup.repositories;

import gr.innovativecommercial.startup.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>//library poy tou dineis typo klassis kai typo primary key
    // kai ftiaxnei antikeimeno aytou tou tupou pou tou dineis!!!!!!!!!!!
    //kai tha ypoloipoiei to CRUD
{
}
