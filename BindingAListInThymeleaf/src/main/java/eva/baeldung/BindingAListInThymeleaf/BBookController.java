package eva.baeldung.BindingAListInThymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/books")
public class BBookController {

    @Autowired
    private BBookService bBookService;


    @GetMapping(value = "/all")
    public String showAll(Model model){
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

    @PostMapping("/save")
    public String saveBooks(@ModelAttribute BBooksCreationDTO form, Model model){

        bBookService.saveAll(form.getBooks());
        model.addAttribute("books", bBookService.findAll());
        return "redirect:/books/all";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model){
        List<BBook> bBooks = new ArrayList<>();
        bBookService.findAll().iterator().forEachRemaining(bBooks::add);
        model.addAttribute("form", new BBooksCreationDTO(bBooks));
        return "books/editBbooksForm";
    }

}
