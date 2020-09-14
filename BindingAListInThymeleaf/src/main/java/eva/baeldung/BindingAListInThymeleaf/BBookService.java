package eva.baeldung.BindingAListInThymeleaf;

import java.awt.print.Book;
import java.util.List;

public interface BBookService {

    List<BBook> findAll();

    void saveAll(List<BBook> books);

}
