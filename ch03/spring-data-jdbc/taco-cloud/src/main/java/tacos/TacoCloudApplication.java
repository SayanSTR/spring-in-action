package tacos;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tacos.data.IngredientRepository;
import tacos.Ingredient.Type;

@SpringBootApplication
public class TacoCloudApplication {

	/*
	* The main() method calls a static run() method on the SpringApplication class,
	* which performs the actual bootstrapping of the application, creating the Spring
	* application context. The two parameters passed to the run() method are a configuration
	* class and the command-line arguments. Although it’s not necessary that the
	* configuration class passed to run() be the same as the bootstrap class, this is the
	* most convenient and typical choice. The configuration class is annotated with
	* @SpringBootApplication, which is a composite annotation that combines three other
	* annotations: @Configuration, @ComponentScan, and @EnableAutoConfiguration.
	*/
	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

}
