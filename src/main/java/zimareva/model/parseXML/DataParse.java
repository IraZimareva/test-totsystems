package zimareva.model.parseXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class DataParse {
    private RowsParse rows;

    public DataParse() {
    }

    public RowsParse getRows() {
        return rows;
    }

    @XmlElement(name = "rows")
    public void setRows(RowsParse rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "\n DataParse{" +
                "rows=" + rows +
                '}';
    }
}
