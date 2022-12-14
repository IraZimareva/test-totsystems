package zimareva.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import zimareva.model.parseXML.RowParse;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * История торгов за произвольную дату
 */
@Entity
@Table(name = "history")
public class History {
    @Id
    @SequenceGenerator(name = "history_seq", sequenceName = "history_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_seq")
    private Long id;

    /*@OneToMany(mappedBy="security")
    @JsonIgnoreProperties("history")
    private List<Security> securities ;*/

    private String secid;
    private LocalDate tradedate;
    private Double numtrades;
    private Double open;
    private Double close;

    public History() {
    }

    public Long getId() {
        return id;
    }

    public String getSecid() {
        return secid;
    }

    public void setSecid(String secid) {
        this.secid = secid;
    }

    public LocalDate getTradedate() {
        return tradedate;
    }

    public void setTradedate(LocalDate tradedate) {
        this.tradedate = tradedate;
    }

    public Double getNumtrades() {
        return numtrades;
    }

    public void setNumtrades(Double numtrades) {
        this.numtrades = numtrades;
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

    public static History from(RowParse row){
        History history = new History();
        history.setSecid(row.getSecIdHistory());
        history.setNumtrades(History.parseStringToDouble(row.getNumtrades()));
        history.setOpen(History.parseStringToDouble(row.getOpen()));
        history.setClose(History.parseStringToDouble(row.getClose()));
        history.setTradedate(LocalDate.parse(row.getTradedate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        box.setBoxList(boxDTO.getBoxList().stream().map(Box::from).collect(Collectors.toList()));
        return history;
    }

    private static double parseStringToDouble(String value) {
        return value == null || value.isEmpty() ? Double.NaN : Double.valueOf(value);
    }
}
