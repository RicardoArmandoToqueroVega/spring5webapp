package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Autor;
import guru.springframework.spring5webapp.domain.Editorial;
import guru.springframework.spring5webapp.domain.Libro;
import guru.springframework.spring5webapp.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
//Esta clase se encarga de inicializar los datos
@Component //La anotación Component le indica a Spring que el ciclo de vida de la clase sera manejado por el contenedor loC (inversión de Control)
public class BootStrapData implements CommandLineRunner {

    private final AutorRepository autorRepository;
    private final LibroRepository libroRepository;
    private final EditorialRepository editorialRepository;

    public BootStrapData(AutorRepository autorRepository, LibroRepository libroRepository, EditorialRepository editorialRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
        this.editorialRepository = editorialRepository;
    }
    @Override
    public void run(String... args) {
        Editorial editorial1 = new Editorial("Pearson","Los Angeles");
        editorialRepository.save(editorial1);
        System.out.println("Numero de Editoriales guardadas: " + editorialRepository.count());
        Autor autor1 = new Autor("Carlos","Martinez");
        Libro libro1 = new Libro("El libro","125565");
        autor1.getLibros().add(libro1);
        libro1.getAutores().add(autor1);

        libro1.setEditorial(editorial1);
        editorial1.libros.add(libro1);

        autorRepository.save(autor1);
        libroRepository.save(libro1);
        editorialRepository.save(editorial1);
        Autor autor2 = new Autor("Rod","Johnson");
        Libro libro2 = new Libro("J2EE Development without EJB","35465231");
        autor2.getLibros().add(libro2);
        libro2.getAutores().add(autor2);
        libro2.setEditorial(editorial1);
        editorial1.libros.add(libro2);
        autorRepository.save(autor2);
        libroRepository.save(libro2);
        editorialRepository.save(editorial1);
        System.out.println("Comenzo en la clase bootstrap");
        System.out.println("Numero de libros registrados:"+libroRepository.count());
        System.out.println("Numero de libros asignados a la editorial "+editorial1.getNombre()+ ": "+editorial1.libros.size());
    }
}
