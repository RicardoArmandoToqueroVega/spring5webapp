package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Editorial;
import org.springframework.data.repository.CrudRepository;

public interface EditorialRepository extends CrudRepository<Editorial,Long> {
}
