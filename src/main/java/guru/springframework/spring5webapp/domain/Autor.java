package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Creado por Ricardo Armando Toquero Vega.
 */
//Volvemos este POJO(Clase) en una entidad para manejarlo con JPA
@Entity
public class Autor {
    @Id //Lo declamos como Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Le pedimos que sea identity
    private Long idAutor;
    private String nombre;
    private String apellido;
    //Creamos la relación entre las clases
    @ManyToMany(mappedBy = "autores")//En este caso es una relación muchos a muchos
    private Set<Libro> libros  = new HashSet<>();

    public Autor(){}

    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(idAutor, autor.idAutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAutor);
    }
}
