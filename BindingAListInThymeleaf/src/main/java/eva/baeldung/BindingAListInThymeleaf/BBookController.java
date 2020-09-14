package eva.baeldung.BindingAListInThymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/books")
public class BBookController {

    private final BBookService bBookService;

    public BBookController(BBookService bBookService) {
        this.bBookService = bBookService;
    }


    @GetMapping(value = "/all")
    public String showAll(Model model){
        bBookService.findAll();
        model.addAttribute("books", bBookService.findAll());
        return "books/allBooks";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model){

        BBooksCreationDTO bBooksform = new BBooksCreationDTO();

        for(int i = 1 ; i <= 3 ; i++){
            bBooksform.addBook(new BBook());
        }


        model.addAttribute("form", bBooksform);
        return "books/createBooksForm";
    }

}
