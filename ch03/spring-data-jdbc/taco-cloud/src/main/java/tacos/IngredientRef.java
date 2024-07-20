package tacos;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class IngredientRef {
    private final String ingredient;
}
