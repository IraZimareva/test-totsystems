package zimareva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import zimareva.model.TypeInputData;
import zimareva.service.MainService;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDate;

@SpringBootApplication
public class TestTOTSystemsApplication {
    private static final String SECURITIES_API_URL = "https://iss.moex.com/iss/securities.xml";
    private static final String HISTORY_API_URL = "https://iss.moex.com/iss/history/engines/stock/markets/shares/securities.xml";
    private static final LocalDate HISTORY_URL_PARAMETER_DATE = LocalDate.of(2010,11,22);

    public static void main(String[] args) throws IOException, JAXBException {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(TestTOTSystemsApplication.class, args);
        MainService mainService =
                configurableApplicationContext.getBean(MainService.class);

        //Первичное заполнение базы данных
        mainService.importXMLfile(SECURITIES_API_URL, TypeInputData.SECURITY);
        String historyUrl = String.format("%s?date=%s", HISTORY_API_URL, HISTORY_URL_PARAMETER_DATE);
        mainService.importXMLfile(historyUrl, TypeInputData.HISTORY);
    }
}
