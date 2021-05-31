package guru.springframework.spring5webapp.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEditorial;
    private String nombre;
    private String direccion;
    @OneToMany
    @JoinColumn(name = "id_editorial")
    public Set<Libro> libros = new HashSet<>();
    public Editorial() {
    }

    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Editorial(Long idEditorial, String nombre, String direccion) {
        this.idEditorial = idEditorial;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Long getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Long idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    @Override
    public String toString() {
        return "Editorial{" +
                "idEditorial=" + idEditorial +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || getClass() != o.getClass()) return false;
        Editorial editorial = (Editorial) o;
        return Objects.equals(idEditorial,editorial.idEditorial);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(idEditorial);
    }
}
