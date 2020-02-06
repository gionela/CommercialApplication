package gr.innovativecommercial.startup.controllers;

import gr.innovativecommercial.startup.dtos.ProductDto;
import gr.innovativecommercial.startup.models.Product;
import gr.innovativecommercial.startup.services.ProductService;
import gr.innovativecommercial.startup.utilities.Messager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Null objects, not existing objects and other kind of errors and exceptions are not handled or implemented in this version
 */

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    Messager messager = new Messager();

    @GetMapping("products")
    public List<Product> getAllProductsController() {
        return productService.getAllProducts();
    }

    /**
     * asks from user an id
     * @param id
     * @return the corresponding product
     */
    @GetMapping("product/{id}")
    public Product getProductController(@PathVariable int id) {
        return productService.getProduct(id);
    }

    /**
     * asks from user a name
     * @param name
     * @return the corresponding product
     */
    @GetMapping("products/name/{name}")
    public List<Product> getProductByNameController(String name) {
        return productService.getProductByName(name);
    }

    /**
     * asks from user input data
     * @param productDto creates new product
     * @return that product
     */
    @PostMapping("product")
    public Product saveNewProductController(@RequestBody ProductDto productDto) {
        return productService.saveNewProduct(productDto);
    }

    /**
     *
     * @param id
     * @param productDto
     * @return the corresponded product updated
     */
    @PutMapping("product/{id}")
    public Product updateProductController(@PathVariable int id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("product/{id}")
    public String deleteProductByIdController(@PathVariable int id) {
        productService.deleteProductById(id);
        return messager.showProductDeletedMessage();
    }

    @DeleteMapping("products")
    public String deleteAllProductsController() {
        productService.deleteAllProducts();
        return messager.showAllProductsDeletedMessage();
    }

    /**
     * asks a parameter of type integer from user
     * @param thisMany
     * @return a list of the top "thisMany" expensive products if they exist
     * if they  do not exist is not implemented yet
     */
    @GetMapping("products/top/{thisMany}")
    public List<Product> howTopRequestedMostExpensiveProducts(@PathVariable int thisMany) {
       return productService.showTopRequestedMostExpensiveProducts(thisMany);
    }

}
