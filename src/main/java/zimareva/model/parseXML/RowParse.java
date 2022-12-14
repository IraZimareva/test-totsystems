package zimareva.model.parseXML;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "row")
public class RowParse {
    private Long id;
    private String secId;
    private String regnumber;
    private String name;
    private String emitentTitle;

    private String secIdHistory;
    private String numtrades;
    private String tradedate;
    private String open;
    private String close;

    private Integer index;
    private Integer total;
    private Integer pagesize;

    public RowParse() {
    }

    public Long getId() {
        return id;
    }

    @XmlAttribute(name = "id")
    public void setId(Long id) {
        this.id = id;
    }

    public String getSecId() {
        return secId;
    }

    @XmlAttribute(name = "secid")
    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getRegnumber() {
        return regnumber;
    }

    @XmlAttribute(name = "regnumber")
    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getEmitentTitle() {
        return emitentTitle;
    }

    @XmlAttribute(name = "emitent_title")
    public void setEmitentTitle(String emitentTitle) {
        this.emitentTitle = emitentTitle;
    }

    public String getSecIdHistory() {
        return secIdHistory;
    }

    @XmlAttribute(name = "SECID")
    public void setSecIdHistory(String secIdHistory) {
        this.secIdHistory = secIdHistory;
    }

    public String getTradedate() {
        return tradedate;
    }

    @XmlAttribute(name = "TRADEDATE")
    public void setTradedate(String tradedate) {
        this.tradedate = tradedate;
    }

    public String getOpen() {
        return open;
    }

    @XmlAttribute(name = "OPEN")
    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    @XmlAttribute(name = "CLOSE")
    public void setClose(String close) {
        this.close = close;
    }

    public String getNumtrades() {
        return numtrades;
    }

    @XmlAttribute(name = "NUMTRADES")
    public void setNumtrades(String numtrades) {
        this.numtrades = numtrades;
    }

    public Integer getIndex() {
        return index;
    }

    @XmlAttribute(name = "INDEX")
    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getTotal() {
        return total;
    }

    @XmlAttribute(name = "TOTAL")
    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    @XmlAttribute(name = "PAGESIZE")
    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    @Override
    public String toString() {
        return "\n RowParse{" +
                "id=" + id +
                ", secId='" + secId + '\'' +
                ", regnumber='" + regnumber + '\'' +
                ", name='" + name + '\'' +
                ", emitentTitle='" + emitentTitle + '\'' +
                ", secIdHistory='" + secIdHistory + '\'' +
                ", numtrades='" + numtrades + '\'' +
                ", tradedate='" + tradedate + '\'' +
                ", open='" + open + '\'' +
                ", close='" + close + '\'' +
                ", index=" + index +
                ", total=" + total +
                ", pagesize=" + pagesize +
                '}';
    }
}
