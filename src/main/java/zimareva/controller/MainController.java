package zimareva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zimareva.model.dto.StockMarketDTO;
import zimareva.service.MainService;

import java.util.List;

@RestController
@RequestMapping("/stockmarket")
public class MainController {
    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping
    public ResponseEntity<List<StockMarketDTO>> getStockInformation() {
        List<StockMarketDTO> stockInf = mainService.getStockInformation();
        return new ResponseEntity<>(stockInf, HttpStatus.OK);
    }
}
