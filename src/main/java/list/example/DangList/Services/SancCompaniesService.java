package list.example.DangList.Services;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import list.example.DangList.Repository.SancCompaniesRepository;
import list.example.DangList.model.SancCompanies;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Service
public class SancCompaniesService {

    @Autowired
    private SancCompaniesRepository sancCompaniesRepository;

    public void parseXmlAndInsertCompDataTaliban() {


        File file = new File("taliban.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc;
        Node testNode = null;
        NodeList invidualChilds = null;
        String name = null;
        String info = null;
        try {

            doc = dbf.newDocumentBuilder().parse(file);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Node rootNode = doc.getFirstChild();
        NodeList rootChildren = rootNode.getChildNodes();
        for (int i = 0; i < rootChildren.getLength(); i++) {
            if (rootChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            System.out.println("AAA" + " " + rootChildren.item(i).getNodeName());
            if (rootChildren.item(i).getNodeName().equals("ENTITIES")) {
                testNode = rootChildren.item(i);
            }

        }
        assert testNode != null;
        NodeList testChilds = testNode.getChildNodes();
        for (int i = 0; i < testChilds.getLength(); i++) {
            if (testChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            SancCompanies sancCompanies = new SancCompanies();
            if (!testChilds.item(i).getNodeName().equals("ENTITY")) {
                continue;
            }
            invidualChilds = testChilds.item(i).getChildNodes();

            for (int j = 0; j < invidualChilds.getLength(); j++) {
                if (invidualChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                if (invidualChilds.item(j).getNodeName().equals("FIRST_NAME")) {
                    name = invidualChilds.item(j).getTextContent();
                    System.out.println(name);
                    sancCompanies.setName(name);
                }
                if (invidualChilds.item(j).getNodeName().equals("COMMENTS1")) {
                    info = invidualChilds.item(j).getTextContent();
                    System.out.println(info);
                    sancCompanies.setInfo(info);
                }
                sancCompaniesRepository.save(sancCompanies);
            }
        }
    }



    public void parseXmlAndInsertCompDataDPRK() {


        File file = new File("DPRK.xml");
        DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
        Document doc2;
        Node testNode = null;
        NodeList invidualChilds = null;
        String name = "";
        String info = "";
        try {

            doc2 = dbf2.newDocumentBuilder().parse(file);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Node rootNode = doc2.getFirstChild();
        NodeList rootChildren = rootNode.getChildNodes();
        for (int i = 0; i < rootChildren.getLength(); i++) {
            if (rootChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (rootChildren.item(i).getNodeName().equals("ENTITIES")) {
                testNode = rootChildren.item(i);
            }

        }
        //System.out.println(testNode);
        assert testNode != null;
        NodeList testChilds = testNode.getChildNodes();
        for (int i = 0; i < testChilds.getLength(); i++) {
            if (testChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (!testChilds.item(i).getNodeName().equals("ENTITY")) {
                continue;
            }
            SancCompanies sancCompanies = new SancCompanies();
            invidualChilds = testChilds.item(i).getChildNodes();

            for (int j = 0; j < invidualChilds.getLength(); j++) {
                if (invidualChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                if (invidualChilds.item(j).getNodeName().equals("FIRST_NAME")) {
                    name = invidualChilds.item(j).getTextContent();
                    System.out.println(name);
                    sancCompanies.setName(name);
                }
                if (invidualChilds.item(j).getNodeName().equals("COMMENTS1")) {
                    info = invidualChilds.item(j).getTextContent();
                    System.out.println(info);
                    sancCompanies.setInfo(info);
                }
                sancCompaniesRepository.save(sancCompanies);
            }
        }
    }


    public void parseXmlAndInsertCompDataISIL() {


        File file = new File("ISIL.xml");
        DocumentBuilderFactory dbf3 = DocumentBuilderFactory.newInstance();
        Document doc3;
        Node testNode = null;
        NodeList invidualChilds = null;
        String name = "";
        String info = "";
        try {

            doc3 = dbf3.newDocumentBuilder().parse(file);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Node rootNode = doc3.getFirstChild();
        NodeList rootChildren = rootNode.getChildNodes();
        for (int i = 0; i < rootChildren.getLength(); i++) {
            if (rootChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            System.out.println("AAA" + " " + rootChildren.item(i).getNodeName());
            if (rootChildren.item(i).getNodeName().equals("ENTITIES")) {
                testNode = rootChildren.item(i);
                //System.out.println(testNode);
            }

        }
        //System.out.println(testNode);
        assert testNode != null;
        NodeList testChilds = testNode.getChildNodes();
        for (int i = 0; i < testChilds.getLength(); i++) {
            if (testChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (!testChilds.item(i).getNodeName().equals("ENTITY")) {
                continue;
            }
            SancCompanies sancCompanies = new SancCompanies();
            invidualChilds = testChilds.item(i).getChildNodes();

            for (int j = 0; j < invidualChilds.getLength(); j++) {
                if (invidualChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                if (invidualChilds.item(j).getNodeName().equals("FIRST_NAME")) {
                    name = invidualChilds.item(j).getTextContent();
                    System.out.println(name);
                    sancCompanies.setName(name);
                }
                if (invidualChilds.item(j).getNodeName().equals("COMMENTS1")) {
                    info = invidualChilds.item(j).getTextContent();
                    System.out.println(info);
                    sancCompanies.setInfo(info);
                }
                sancCompaniesRepository.save(sancCompanies);
            }
        }
    }

}

