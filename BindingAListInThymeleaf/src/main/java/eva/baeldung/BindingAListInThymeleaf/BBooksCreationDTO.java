package eva.baeldung.BindingAListInThymeleaf;

import java.util.List;

public class BBooksCreationDTO {

    private List<BBook> books;

    public BBooksCreationDTO(){}

    public BBooksCreationDTO(List<BBook> books) {
        this.books = books;
    }

    public List<BBook> getBooks() {
        return books;
    }

    public void setBooks(List<BBook> books) {
        this.books = books;
    }
}
