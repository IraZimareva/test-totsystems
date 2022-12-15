package zimareva.model.structureImportXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "rows")
public class RowsTag {
    private List<RowTag> rows;

    public RowsTag() {
    }

    public List<RowTag> getRows() {
        return rows;
    }

    @XmlElement(name = "row")
    public void setRows(List<RowTag> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "\n RowsTag{" +
                "rows=" + rows +
                '}';
    }
}
