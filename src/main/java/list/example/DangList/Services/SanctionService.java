package list.example.DangList.Services;

import list.example.DangList.Repository.SanctionRepository;
import list.example.DangList.model.SancCompanies;
import list.example.DangList.model.Sanction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

@Service
public class SanctionService {
    @Autowired
    private SanctionRepository sanctionRepository;

    public void parseXmlAndInsertDataTaliban() {


        File file = new File("taliban.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc;
        Node testNode = null;
        NodeList invidualChilds;
        String Fullname = "";
        String name = "";
        String name2 = "";
        String name3 = "";
        String name4 = "";
        String info = "";

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
            if (rootChildren.item(i).getNodeName().equals("INDIVIDUALS")) {
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
            if (!testChilds.item(i).getNodeName().equals("INDIVIDUAL")) {
                continue;
            }
            Sanction sanction = new Sanction();
            invidualChilds = testChilds.item(i).getChildNodes();

            for (int j = 0; j < invidualChilds.getLength(); j++) {
                if (invidualChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                if (invidualChilds.item(j).getNodeName().equals("FIRST_NAME")) {
                    name = invidualChilds.item(j).getTextContent();

                    sanction.setName(name);
                }
                if (invidualChilds.item(j).getNodeName().equals("SECOND_NAME")) {
                    name2 = invidualChilds.item(j).getTextContent();

                    sanction.setName(name2);
                }
                if (invidualChilds.item(j).getNodeName().equals("THIRD_NAME")) {
                    name3 = invidualChilds.item(j).getTextContent();
                    sanction.setName(name3);
                }
                if (invidualChilds.item(j).getNodeName().equals("FOURTH_NAME")) {
                    name4 = invidualChilds.item(j).getTextContent();

                    sanction.setName(name4);
                }
                Fullname = name + name2 + name3 + name4;
                sanction.setName(Fullname);
                if (invidualChilds.item(j).getNodeName().equals("COMMENTS1")) {
                    info = invidualChilds.item(j).getTextContent();
                    sanction.setInfo(info);
                }
                sanctionRepository.save(sanction);

            }
        }
    }


    public void parseXmlAndInsertDataDPRK() {


        File file = new File("DPRK.xml");
        DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
        Document doc2;
        Node testNode = null;
        NodeList invidualChilds = null;
        String Fullname = "";
        String name = "";
        String name2 = "";
        String name3 = "";
        String name4 = "";
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
            System.out.println("AAA" + " " + rootChildren.item(i).getNodeName());
            if (rootChildren.item(i).getNodeName().equals("INDIVIDUALS")) {
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
            if (!testChilds.item(i).getNodeName().equals("INDIVIDUAL")) {
                continue;
            }
            Sanction sanction = new Sanction();
            invidualChilds = testChilds.item(i).getChildNodes();

            for (int j = 0; j < invidualChilds.getLength(); j++) {
                if (invidualChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                if (invidualChilds.item(j).getNodeName().equals("FIRST_NAME")) {
                    name = invidualChilds.item(j).getTextContent();

                    sanction.setName(name);
                }
                if (invidualChilds.item(j).getNodeName().equals("SECOND_NAME")) {
                    name2 = invidualChilds.item(j).getTextContent();

                    sanction.setName(name2);
                }
                if (invidualChilds.item(j).getNodeName().equals("THIRD_NAME")) {
                    name3 = invidualChilds.item(j).getTextContent();
                    sanction.setName(name3);
                }
                if (invidualChilds.item(j).getNodeName().equals("FOURTH_NAME")) {
                    name4 = invidualChilds.item(j).getTextContent();

                    sanction.setName(name4);
                }
                Fullname = name + name2 + name3 + name4;
                sanction.setName(Fullname);
                if (invidualChilds.item(j).getNodeName().equals("COMMENTS1")) {
                    info = invidualChilds.item(j).getTextContent();
                    sanction.setInfo(info);
                }
                sanctionRepository.save(sanction);

            }
        }
    }


    public void parseXmlAndInsertDataISIL() {


        File file = new File("ISIL.xml");
        DocumentBuilderFactory dbf3 = DocumentBuilderFactory.newInstance();
        Document doc3;
        Node testNode = null;
        NodeList invidualChilds = null;
        String Fullname = "";
        String name = "";
        String name2 = "";
        String name3 = "";
        String name4 = "";
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

            if (rootChildren.item(i).getNodeName().equals("INDIVIDUALS")) {
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
            if (!testChilds.item(i).getNodeName().equals("INDIVIDUAL")) {
                continue;
            }
            invidualChilds = testChilds.item(i).getChildNodes();
            Sanction sanction = new Sanction();

            for (int j = 0; j < invidualChilds.getLength(); j++) {
                if (invidualChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                if (invidualChilds.item(j).getNodeName().equals("FIRST_NAME")) {
                    name = invidualChilds.item(j).getTextContent();

                    sanction.setName(name);
                }
                if (invidualChilds.item(j).getNodeName().equals("SECOND_NAME")) {
                    name2 = invidualChilds.item(j).getTextContent();

                    sanction.setName(name2);
                }
                if (invidualChilds.item(j).getNodeName().equals("THIRD_NAME")) {
                    name3 = invidualChilds.item(j).getTextContent();
                    sanction.setName(name3);
                }
                if (invidualChilds.item(j).getNodeName().equals("FOURTH_NAME")) {
                    name4 = invidualChilds.item(j).getTextContent();

                    sanction.setName(name4);
                }
                Fullname = name + name2 + name3 + name4;
                sanction.setName(Fullname);
                if (invidualChilds.item(j).getNodeName().equals("COMMENTS1")) {
                    info = invidualChilds.item(j).getTextContent();
                    sanction.setInfo(info);
                }
                sanctionRepository.save(sanction);

            }
        }
    }
}

