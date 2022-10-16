package com.ims.contacts;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Parser {
    private Contacts[] contacts;
    private final InputStream contactFiles;

    public Parser(Context c) {
        this.contactFiles = c.getResources().openRawResource(R.raw.contacts);
    }

    public boolean parse() {
        boolean parsed = false;
        contacts = null;


        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(contactFiles);
            Element root = dom.getDocumentElement();
            NodeList items = root.getElementsByTagName("*.*.");
            contacts = new Contacts[items.getLength()];

            for(int i = 0;i< items.getLength();i++) {
                Node item = items.item(i);



                int id = Integer.parseInt(item.getAttributes().getNamedItem("id").getNodeValue());
                String name = item.getAttributes().getNamedItem("name").getNodeValue();
                String firstSurname = item.getAttributes().getNamedItem("firstSurname").getNodeValue();
                String secondSurname = item.getAttributes().getNamedItem("secondSurname").getNodeValue();
                String photo = item.getAttributes().getNamedItem("photo").getNodeValue();
                String birth = item.getAttributes().getNamedItem("birth").getNodeValue();
                String company = item.getAttributes().getNamedItem("company").getNodeValue();
                String email = item.getAttributes().getNamedItem("email").getNodeValue();
                String phone1 = item.getAttributes().getNamedItem("phone1").getNodeValue();
                String phone2 = item.getAttributes().getNamedItem("phone2").getNodeValue();
                String adress = item.getAttributes().getNamedItem("adress").getNodeValue();

                contacts[i] = new Contacts(id,name,firstSurname,secondSurname,photo,birth,company,email,phone1,phone2,adress);

            }

            parsed = true;

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return parsed;
    }

    public Contacts[] getContacts() {
        return contacts;
    }
}
