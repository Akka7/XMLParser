package list.example.DangList.Services;

import list.example.DangList.Repository.TestRepository;
import list.example.DangList.model.Test;
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
public class TestService {

    @Autowired
    private TestRepository testRepository;


    public void parseXmlAndInsertData() {


        File file = new File("DPRK.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc;
        Node testNode = null;
        NodeList invidualChilds = null;
        String name;
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
            invidualChilds = testChilds.item(i).getChildNodes();

            for (int j = 0; j < invidualChilds.getLength(); j++) {
                if (invidualChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                switch (invidualChilds.item(j).getNodeName()) {
                    case "FIRST_NAME": {
                        name = invidualChilds.item(j).getTextContent();
                        Test test = new Test();
                        test.setName(name);
                        testRepository.save(test);
                        System.out.println(name);
                    }
                }
            }
        }
    }
}

