package eva.baeldung.BindingAListInThymeleaf;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class BBBookServiceImpl implements BBookService {


    static Map<Long, BBook> booksDB = new HashMap<>();


    @Override
    public List<BBook> findAll() {
        return new ArrayList<>(booksDB.values());
    }

    @Override
    public void saveAll(List<BBook> books) {

        long nextId = nextID();

        for (BBook book: books){
            if(book.getId() == 0){
                book.setId(nextId++);
            }
        }

        Map<Long, BBook> bookMap = books.stream()
                .collect(Collectors.toMap(BBook::getId, Function.identity()));
    }


    private Long nextID(){

        return booksDB.keySet()
                .stream()
                .mapToLong(value -> value)
                .max()
                .orElse(0) + 1;
    }
}
