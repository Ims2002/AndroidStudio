package com.ims.fileview;

import android.provider.DocumentsContract;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLParser {
    /*

        //Get document builder

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Get Document
            Document document = builder.parse(new File("E:\\Descargas\\countries.xml"));

            //Normalize the xml structure
            document.getDocumentElement().normalize();

            //get all elements by the tag name
            NodeList countryList = document.getElementsByTagName("countries");
            for(int i = 0;i<countryList.getLength();i++) {
                Node country = countryList.item(i);

                if(country.getNodeType() == Node.ELEMENT_NODE) {
                   Element countryElement = (Element) country;
                    System.out.println("Country Name: "+countryElement.getAttribute(("test")));

                    NodeList countryDetails = country.getChildNodes();
                    for(int j = 0; j<countryDetails.getLength();j++){
                        Node detail = countryDetails.item(j);
                        if(detail.getNodeType() == Node.ELEMENT_NODE) {
                            Element detailElement = (Element)detail;
                            System.out.println("    " +detailElement.getTagName()+":"+detailElement.getAttribute("countryName"));
                        }
                    }
               }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    */
}
