package zimareva.model.parseXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "document")
public class DocumentParse {
    private List<DataParse> data;

    public DocumentParse() {
    }

    public List<DataParse> getData() {
        return data;
    }

    @XmlElement(name = "data")
    public void setData(List<DataParse> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "\n DocumentParse{" +
                "data=" + data +
                '}';
    }
}
