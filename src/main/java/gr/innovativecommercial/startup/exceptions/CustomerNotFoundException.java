package gr.innovativecommercial.startup.exceptions;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(String description){
        super(description);
    }
}
