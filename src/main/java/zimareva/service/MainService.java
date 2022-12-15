package zimareva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zimareva.exception.NotValidTypeInputDataException;
import zimareva.model.History;
import zimareva.model.Security;
import zimareva.model.dto.StockMarketDTO;
import zimareva.model.enumerated.TypeInputData;
import zimareva.model.structureImportXML.DocumentTag;
import zimareva.model.structureImportXML.RowTag;
import zimareva.utils.XMLParser;

import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    private static final String SECURITIES_API_URL = "https://iss.moex.com/iss/securities.xml";
    //or use index? https://iss.moex.com/iss/history/engines/stock/markets/index/securities.xml?date=2010-11-22
    private static final String HISTORY_API_URL = "https://iss.moex.com/iss/history/engines/stock/markets/shares/securities.xml";
    private static final LocalDate HISTORY_URL_PARAMETER_DATE = LocalDate.of(2010,11,22);

    private final SecurityService securityService;
    private final HistoryService historyService;

    @Autowired
    public MainService(SecurityService securityService, HistoryService historyService) {
        this.securityService = securityService;
        this.historyService = historyService;
    }

    public List<StockMarketDTO> getStockInformation() {
        return securityService.getSecuritiesWithHistory();
    }

    public void importData(){
        String historyUrl = String.format("%s?date=%s", HISTORY_API_URL, HISTORY_URL_PARAMETER_DATE);
        importXMLfile(historyUrl);
//        importXMLfile(SECURITIES_API_URL, TypeInputData.SECURITY);
    }

    private void importXMLfile(String filepath) {
        try {
            DocumentTag rootElementXML = XMLParser.unmarshallUrl(filepath);
            saveSecuritiesHavingHistory(rootElementXML);
            saveHistory(rootElementXML);
            //Проверка на выгрузку данных порциями. По умолчанию выводится всего 100
            if (rootElementXML.getData().size() > 1) {
                RowTag rowCursor = rootElementXML.getData().get(1).getRows().getRows().get(0);
                Integer startWith = rowCursor.getPagesize();
                while (startWith + rowCursor.getPagesize() < rowCursor.getTotal() + rowCursor.getPagesize()) {
                    DocumentTag rootElement = XMLParser.unmarshallUrl(
                            String.format("%s&start=%s", filepath, startWith));
                    saveSecuritiesHavingHistory(rootElement);
                    saveHistory(rootElement);
                    startWith = startWith + rowCursor.getPagesize();
                }
            }
        } catch (JAXBException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void saveHistory(DocumentTag rootElementXML) {
        fillDB(rootElementXML, TypeInputData.HISTORY);
    }

    private void saveSecuritiesHavingHistory(DocumentTag rootElementXML) throws JAXBException, MalformedURLException {
        List<String> secIdsFromHistories = checkSecurityWithHistory(rootElementXML);
        for (String secId: secIdsFromHistories) {
            String securityUrl = String.format("%s?q=%s", SECURITIES_API_URL, secId);
            DocumentTag rootElementSecurity = XMLParser.unmarshallUrl(securityUrl);
            fillDB(rootElementSecurity, TypeInputData.SECURITY);
        }
    }

    private List<String> checkSecurityWithHistory(DocumentTag rootElementXML){
        List<String> secIdsFromHistories = new ArrayList<>();
        for (RowTag row: rootElementXML.getData().get(0).getRows().getRows()){
            secIdsFromHistories.add(row.getSecIdHistory());
        }
        return secIdsFromHistories;
    }

    private void fillDB(DocumentTag documentXML, TypeInputData type) {
        switch (type) {
            case SECURITY:
                RowTag rowFirst = documentXML.getData().get(0).getRows().getRows().get(0);
                Security security = Security.from(rowFirst);
                securityService.addSecurity(security);
                /*for (RowTag row : documentXML.getData().get(0).getRows().getRows()) {
                    Security security = Security.from(row);
                    securityService.addSecurity(security);
                }*/
                break;

            case HISTORY:
                for (RowTag row : documentXML.getData().get(0).getRows().getRows()) {
                    History history = History.from(row);
                    historyService.addHistory(history);
                }
                break;

            default:
                throw new NotValidTypeInputDataException(type);
        }
    }
}
