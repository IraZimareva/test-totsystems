package zimareva.model.dto;

import java.time.LocalDate;

public class StockMarketDTO {
    private String secId;
    private String regnumber;
    private String name;
    private String emitentTitle;
    private LocalDate tradedate;
    private Double numtrades;
    private Double open;
    private Double close;

    public StockMarketDTO() {
    }

    public StockMarketDTO(String secId, String regnumber, String name, String emitentTitle,
                          LocalDate tradedate, Double numtrades,  Double open, Double close) {
        this.secId = secId;
        this.regnumber = regnumber;
        this.name = name;
        this.emitentTitle = emitentTitle;
        this.numtrades = numtrades;
        this.tradedate = tradedate;
        this.open = open;
        this.close = close;
    }

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmitentTitle() {
        return emitentTitle;
    }

    public void setEmitentTitle(String emitentTitle) {
        this.emitentTitle = emitentTitle;
    }

    public Double getNumtrades() {
        return numtrades;
    }

    public void setNumtrades(Double numtrades) {
        this.numtrades = numtrades;
    }

    public LocalDate getTradedate() {
        return tradedate;
    }

    public void setTradedate(LocalDate tradedate) {
        this.tradedate = tradedate;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }
}
