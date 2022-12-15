package zimareva.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zimareva.model.Security;
import zimareva.model.dto.StockMarketDTO;

import java.util.List;

@Repository
public interface SecurityRepository extends CrudRepository<Security, Long> {
    @Query(
            value = "select s.secid, s.regnumber, s.name, s.emitent_title, h.tradedate, h.numtrades, h.open, h.close " +
                    " from security s join history h on s.secid = h.secid",
            nativeQuery = true)
    List<StockMarketDTO> findSecuritiesWithHistory();
}
