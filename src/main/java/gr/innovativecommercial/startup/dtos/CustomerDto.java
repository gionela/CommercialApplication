package gr.innovativecommercial.startup.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDto {
    private String name;
    private String address;
    private int yearBirth;
    private int monthBirth;
}
/*{"name": "Dimitris Iracleous",
        "address": "athens",
        "yearBirth": 1970,
        "monthBirth": 7
        }
        */