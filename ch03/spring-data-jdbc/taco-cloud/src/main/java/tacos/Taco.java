package tacos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;

@Data
@Table
public class Taco {
    private long id;
    private Date createdAt = new Date();
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
