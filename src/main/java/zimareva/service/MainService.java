package zimareva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zimareva.exception.NotValidTypeInputDataException;
import zimareva.model.History;
import zimareva.model.Security;
import zimareva.model.TypeInputData;
import zimareva.model.parseXML.DocumentParse;
import zimareva.model.parseXML.RowParse;
import zimareva.utils.XMLParser;

import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;

@Service
public class MainService {
    private final SecurityService securityService;
    private final HistoryService historyService;

    @Autowired
    public MainService(SecurityService securityService, HistoryService historyService) {
        this.securityService = securityService;
        this.historyService = historyService;
    }

    public void importXMLfile(String filepath, TypeInputData type) {
        try {
            DocumentParse rootElementXML = XMLParser.unmarshallUrl(filepath);
            fillDB(rootElementXML, type);
            //Проверка на выгрузку данных порциями. По умолчанию выводится всего 100
            if (rootElementXML.getData().size() > 1) {
                RowParse rowCursor = rootElementXML.getData().get(1).getRows().getRows().get(0);
                Integer startWith = rowCursor.getPagesize();
                while (startWith + rowCursor.getPagesize() < rowCursor.getTotal() + rowCursor.getPagesize()) {
                    DocumentParse rootElement = XMLParser.unmarshallUrl(
                            String.format("%s&start=%s", filepath, startWith));
                    fillDB(rootElement, type);
                    startWith = startWith + rowCursor.getPagesize();
                }
            }
        } catch (JAXBException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void fillDB(DocumentParse documentXML, TypeInputData type) {
        switch (type) {
            case SECURITY:
                for (RowParse row : documentXML.getData().get(0).getRows().getRows()) {
                    Security security = Security.from(row);
                    securityService.addSecurity(security);
                }
                break;

            case HISTORY:
                for (RowParse row : documentXML.getData().get(0).getRows().getRows()) {
                    History history = History.from(row);
                    historyService.addHistory(history);
                }
                break;

            default:
                throw new NotValidTypeInputDataException(type);
        }
    }
}
