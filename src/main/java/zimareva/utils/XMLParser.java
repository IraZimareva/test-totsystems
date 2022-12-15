package zimareva.utils;

import zimareva.model.structureImportXML.DocumentTag;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;

public class XMLParser {
    public static DocumentTag unmarshallUrl(String filepath) throws JAXBException, MalformedURLException {
        JAXBContext context = JAXBContext.newInstance(DocumentTag.class);
        Unmarshaller mar = context.createUnmarshaller();
        return (DocumentTag) mar.unmarshal(new URL(filepath));
    }
}
