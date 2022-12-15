package zimareva.model.structureImportXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "document")
public class DocumentTag {
    private List<DataTag> data;

    public DocumentTag() {
    }

    public List<DataTag> getData() {
        return data;
    }

    @XmlElement(name = "data")
    public void setData(List<DataTag> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "\n DocumentTag{" +
                "data=" + data +
                '}';
    }
}
