package zimareva.model.parseXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "rows")
public class RowsParse {
    private List<RowParse> rows;

    public RowsParse() {
    }

    public List<RowParse> getRows() {
        return rows;
    }

    @XmlElement(name = "row")
    public void setRows(List<RowParse> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "\n RowsParse{" +
                "rows=" + rows +
                '}';
    }
}
