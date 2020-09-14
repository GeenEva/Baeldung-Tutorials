package eva.baeldung.BindingAListInThymeleaf;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BindingAListInThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(BindingAListInThymeleafApplication.class, args);
	}


	@Bean
	public ApplicationRunner booksInitializer(BBookService bBookService){

		return args -> {
			BBook book1 = new BBook(1, "Wake Up", "Nelson Nieslon");
			BBook book2 = new BBook(2, "Kick Ass", "Damia Fela");
			List<BBook> books = new ArrayList<>();
			books.add(book1);
			books.add(book2);
			bBookService.saveAll(books);
		};
	}

}
