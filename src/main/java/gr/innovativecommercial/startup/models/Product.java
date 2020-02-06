package gr.innovativecommercial.startup.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Comparator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // tha kaneis sql pinaka
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//kane autoincrement to id
    private int id;
    private String productName;
    private double productPrice;
    private int productQuantity;


}
