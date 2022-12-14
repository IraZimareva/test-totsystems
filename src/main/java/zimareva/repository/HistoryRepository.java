package zimareva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zimareva.model.History;

@Repository
public interface HistoryRepository extends CrudRepository<History, String> {
}
