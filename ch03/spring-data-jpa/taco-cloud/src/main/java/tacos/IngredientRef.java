package tacos;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class IngredientRef {
    private final String ingredient;
}
