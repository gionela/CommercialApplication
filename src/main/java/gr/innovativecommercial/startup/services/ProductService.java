package gr.innovativecommercial.startup.services;

import gr.innovativecommercial.startup.dtos.ProductDto;
import gr.innovativecommercial.startup.models.Product;
import gr.innovativecommercial.startup.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(int id) {
        return productRepository.findById(id).get();

    }

    public List<Product> getAllProducts() {
        return StreamSupport
                .stream(productRepository
                        .findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // Implementing with Lambda instead of for each loop as you did on customers.
    public List<Product> getProductByName(String name) {
        return StreamSupport
                .stream(productRepository.findAll().spliterator(), false)
                .filter(product -> product.getProductName().equals(name))
                .collect(Collectors.toList());
    }


    public Product saveNewProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        product.setProductQuantity(productDto.getProductQuantity());

        return productRepository.save(product);
    }

    public Product updateProduct(int id, ProductDto productDto) {
        Product product = productRepository.findById(id).get();
        if (product == null)
            return null;
        product.setProductPrice(productDto.getProductPrice());
        product.setProductQuantity(productDto.getProductQuantity());
        return productRepository.save(product);
    }

    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
    public List<Product> showTopRequestedMostExpensiveProducts(int thisMany){
       return StreamSupport
                .stream(productRepository.findAll().spliterator(),false)
                .sorted(Comparator.comparingDouble(Product::getProductPrice).reversed())
                .limit(thisMany)
                .collect(Collectors.toList());
    }

}
