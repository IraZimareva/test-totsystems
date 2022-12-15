package zimareva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import zimareva.exception.EntityNotFoundException;
import zimareva.model.History;
import zimareva.repository.HistoryRepository;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public History addHistory(History history){
        return historyRepository.save(history);
    }

    public History getHistoryById(Long id) {
        return historyRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(History.class.getName(), id));
    }

    public List<History> getHistories() {
        return StreamSupport
                .stream(historyRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteHistory(Long id) {
        historyRepository.deleteById(id);
    }

    @Transactional
    public History editHistory(Long id, Map<String, Object> historyDetails) {
        History historyToEdit = getHistoryById(id);
        historyDetails.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(History.class, key);
            field.setAccessible(true);
            if (key.equals("tradedate")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate tradedate = LocalDate.parse((String) value, formatter);
                ReflectionUtils.setField(field, historyToEdit, tradedate);
            } else {
                ReflectionUtils.setField(field, historyToEdit, value);
            }
        });
        return historyToEdit;
    }
}
