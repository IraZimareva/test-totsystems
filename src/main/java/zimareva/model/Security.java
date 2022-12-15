package zimareva.model;

import zimareva.model.structureImportXML.RowTag;

import javax.persistence.*;


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

    public static Security from(RowTag row){
        Security security = new Security();
        security.setId(row.getId());
        security.setSecid(row.getSecId());
        security.setRegnumber(row.getRegnumber());
        security.setName(row.getName());
        security.setEmitentTitle(row.getEmitentTitle());
        return security;
    }
}