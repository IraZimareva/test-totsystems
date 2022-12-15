package zimareva.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import zimareva.model.parseXML.RowParse;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Информация о ценных бумагах
 */
@Entity
@Table(name = "security")
public class Security {
    @Id
    private Long id;
    private String secid;
    private String regnumber;
    private String name;
    private String emitentTitle;

    /*@OneToMany
    @JoinColumn(name = "secid")
    private List<History> histories = new ArrayList<>();*/

   /* @OneToMany(mappedBy="history")
    @JsonIgnoreProperties("security")
    private List<History> histories ;*/


    public Security() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecid() {
        return secid;
    }

    public void setSecid(String secid) {
        this.secid = secid;
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

    public static Security from(RowParse row){
        Security security = new Security();
        security.setId(row.getId());
        security.setSecid(row.getSecId());
        security.setRegnumber(row.getRegnumber());
        security.setName(row.getName());
        security.setEmitentTitle(row.getEmitentTitle());
//        box.setBoxList(boxDTO.getBoxList().stream().map(Box::from).collect(Collectors.toList()));
        return security;
    }
}