package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *Creado por Ricardo Armando Toquero Vega
 */
//Volvemos este POJO(Clase) en una entidad para manejarlo con JPA
@Entity
public class Libro {

    @Id //Declaramos el campo como id
    @GeneratedValue(strategy = GenerationType.AUTO)  //Le pedimos que sea identity
    private Long idLibro;
    private String titulo;
    private String isbn;
    //Creamos la relación entre las clases
    @ManyToMany//En este caso es muchos a muchos
    /*Además de la anotación de muchos a muchos debemos mapear como se manejara esta relación.
    Por ser muchos a muchos necesitamos una tabla intermedia*/
    @JoinTable(name = "autor_libro",joinColumns = @JoinColumn(name = "libro_id"),
    inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private Set<Autor> autores = new HashSet<>();

    @ManyToOne
    private Editorial editorial;
    public Libro() {
    }

    public Libro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "LibroRepository{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(idLibro, libro.idLibro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLibro);
    }
}
