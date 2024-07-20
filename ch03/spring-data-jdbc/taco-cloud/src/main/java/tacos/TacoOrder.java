package tacos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table("Taco_Cloud_Order") // custom table name (default is TacoOrder)
public class TacoOrder implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id // designates this property of the class as the identifier for the class
    private Long id;

    private Date placedAt;
    @Column("customer_name") // custom column name (default is delivery_name)
    @NotBlank(message = "Delivery name is required")
    private String deliveryName; // camel case is converted to words seperated by "_" to decide column name
    @NotBlank(message = "Street is required")
    private String deliveryStreet; // default column name is delivery_street
    @NotBlank(message = "City is required")
    private String deliveryCity;
    @NotBlank(message = "State is required")
    private String deliveryState;
    @NotBlank(message = "Zip code is required")
    private String deliveryZip;
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Must be formatted MM/YY (e.g. 05/22)")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
