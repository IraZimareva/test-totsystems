package zimareva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zimareva.model.Security;

@Repository
public interface SecurityRepository extends CrudRepository<Security, Long> {
}
