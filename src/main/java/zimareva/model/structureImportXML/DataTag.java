package zimareva.model.structureImportXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class DataTag {
    private RowsTag rows;

    public DataTag() {
    }

    public RowsTag getRows() {
        return rows;
    }

    @XmlElement(name = "rows")
    public void setRows(RowsTag rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "\n DataTag{" +
                "rows=" + rows +
                '}';
    }
}
