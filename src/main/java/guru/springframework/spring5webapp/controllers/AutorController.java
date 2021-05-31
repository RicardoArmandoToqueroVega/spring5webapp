package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AutorRepository;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AutorController {
    private  final AutorRepository autorRepository;
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @RequestMapping("/autores")
    public String getAutores(Model model){
         model.addAttribute("autores",autorRepository.findAll());
         return "autores/list";
    }
}
