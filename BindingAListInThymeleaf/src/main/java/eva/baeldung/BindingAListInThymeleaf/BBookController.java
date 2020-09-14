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

}
