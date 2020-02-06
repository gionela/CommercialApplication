package gr.innovativecommercial.startup.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//kane autoincrement to id
    private int id;
    private Date date;

    @ManyToOne
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer customer;


//    @ManyToOne
//    @JoinColumn(name = "Customer",nullable = true)// edw kanei to parakatw field foreign key se ayton ton pinaka me to name pou tou lew
//    //ama den tou dwsoume name tha dwsei mono tou sumfwna me ton pinaka pou tou lew na paei na syndethei
//    @JsonIgnore //den fernEI KAI TA APOTELESMATA
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private  Customer customer;
}
