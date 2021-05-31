package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Autor;
import org.springframework.data.repository.CrudRepository;
public interface AutorRepository extends CrudRepository<Autor,Long> {
}
