package gr.innovativecommercial.startup.utilities;


import lombok.NoArgsConstructor;


@NoArgsConstructor
public class Messager {

    public String showCustomerDeletedMessage(){
        return "Customer was successfully deleted.";
    }
    public String showAllCustomersDeletedMessage(){
        return "All customers were deleted";
    }
    public String showProductDeletedMessage(){
        return "Product was successfully deleted";
    }
    public String showAllProductsDeletedMessage(){
        return "All products were deleted";
    }
}
