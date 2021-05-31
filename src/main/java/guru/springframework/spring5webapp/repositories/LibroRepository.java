package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroRepository extends CrudRepository<Libro,Long> {
}
