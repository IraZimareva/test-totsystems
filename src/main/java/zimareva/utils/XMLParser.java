package zimareva.utils;

import zimareva.model.parseXML.DocumentParse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;

public class XMLParser {
    public static DocumentParse unmarshallUrl(String filepath) throws JAXBException, MalformedURLException {
        JAXBContext context = JAXBContext.newInstance(DocumentParse.class);
        Unmarshaller mar = context.createUnmarshaller();
        return (DocumentParse) mar.unmarshal(new URL(filepath));
    }

 /*   public static void getConnection(String url) throws IOException, InterruptedException, ParserConfigurationException, SAXException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/xml")
                .uri(URI.create(SECURITIES_API_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response status code " + response.statusCode());
        System.out.println("Response \n" + response.body());
    }*/
}
