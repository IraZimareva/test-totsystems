package zimareva.model.dto;

public class StockMarketDTO {
    private String secId;
    private String regnumber;
    private String name;
    private String emitentTitle;
    private String numtrades;
    private String tradedate;
    private String open;
    private String close;

    public StockMarketDTO() {
    }

    public StockMarketDTO(String secId, String regnumber, String name, String emitentTitle,
                          String numtrades, String tradedate, String open, String close) {
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

    public String getNumtrades() {
        return numtrades;
    }

    public void setNumtrades(String numtrades) {
        this.numtrades = numtrades;
    }

    public String getTradedate() {
        return tradedate;
    }

    public void setTradedate(String tradedate) {
        this.tradedate = tradedate;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }
}
