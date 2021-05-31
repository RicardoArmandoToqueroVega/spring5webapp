package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.LibroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Le indicamos a Spring que esta clase es un Controlador
public class LibroController {

    //Se crea una inyección de el repositorio para manejar las consultas
    private final LibroRepository libroRepository;


    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    //Declaramos el Path que hara la petición
    @RequestMapping("/libros")
    //Se manda como argumento un modelo para obtener el modelo del objeto que necesitamos regresar
    public String getBooks(Model model){
        //Utilizamos el metodo addAttribute para mandar el modelo
        model.addAttribute("books",libroRepository.findAll());
        return "libros/list";
    }
}
