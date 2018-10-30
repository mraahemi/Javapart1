package org.mraahemi.bookstore.clients;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client
{

    public static void main(String[] args)
    {
        try
        {
            URL u = new URL(
                    "http://localhost:8080/java-rest-example/rest/book/");
            HttpURLConnection uc = (HttpURLConnection) u.openConnection();

            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document doc = docBuilder.parse(uc.getInputStream());

            System.out.println(doc.getDocumentElement().getFirstChild()
                                       .getFirstChild().getNodeValue());
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

}