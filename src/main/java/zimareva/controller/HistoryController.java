package zimareva.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zimareva.model.History;
import zimareva.service.HistoryService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/histories")
public class HistoryController {
    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public ResponseEntity<List<History>> getHistories() {
        List<History> histories = historyService.getHistories();
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<History> getHistory(@PathVariable(value = "id") Long historyId) {
        History history = historyService.getHistoryById(historyId);
        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<History> createHistory(@RequestBody History history) {
        History createdHistory = historyService.addHistory(history);
        return new ResponseEntity<>(createdHistory, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public void deleteHistory(@PathVariable(value = "id") Long historyId) {
        historyService.deleteHistory(historyId);
    }

    @PatchMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<History> partialUpdateHistory(@PathVariable("id") Long historyId,
                                                        @RequestBody Map<String, Object> historyDetails) {
        History editedHistory = historyService.editHistory(historyId, historyDetails);
        return new ResponseEntity<>(editedHistory, HttpStatus.OK);
    }
}
