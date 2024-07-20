package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
