package eva.baeldung.BindingAListInThymeleaf;

import java.util.ArrayList;
import java.util.List;

public class BBooksCreationDTO {

    private List<BBook> books;

    public BBooksCreationDTO(){
        this.books = new ArrayList<>();
    }

    public BBooksCreationDTO(List<BBook> books) {
        this.books = books;
    }

    public void addBook(BBook bBook){
        this.books.add(bBook);
    }

    public List<BBook> getBooks() {
        return books;
    }

    public void setBooks(List<BBook> books) {
        this.books = books;
    }
}
