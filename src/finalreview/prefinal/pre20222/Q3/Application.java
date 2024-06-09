package finalreview.prefinal.pre20222.Q3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class Application {

    public RBTree<Integer, Person> createTree() {
        // ########## YOUR CODE STARTS HERE ##########
        RBTree<Integer, Person> rbTree = new RBTree<>();
        for (int i = 0; i < 10; ++i) {
            Person person = new Person(i, "p-" + i, i + 10, "taxidriver-" +i);
            rbTree.insert(i, person);
        }
        return rbTree;
        // ########## YOUR CODE ENDS HERE ##########
    }

    public void saveXML(RBTree<Integer, Person> tree) {
        List<Node> nodeList = tree.postorder();
        // ########## YOUR CODE STARTS HERE ##########
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            //DocumentBuilder obtain a Document from XML (parser)
            DocumentBuilder db = dbf.newDocumentBuilder(); //create a new instance of DocumentBuilder
            Document d = db.newDocument(); //obtain new instance of a DOM document

            // TODO: your customized code
            //create the structure of my document
            Element rootElement = d.createElement("people");//<People>
            d.appendChild(rootElement); //append the root to the document

            //loop through all people to create each person element
            for(Node node : nodeList)
            {
                Person p = (Person) node.getData();
                Element personElem = d.createElement("person");
                rootElement.appendChild(personElem);

                Element idElem = d.createElement("id");
                idElem.appendChild(d.createTextNode(p.getId().toString()));
                personElem.appendChild(idElem);

                Element nameElem = d.createElement("name");
                nameElem.appendChild(d.createTextNode(p.getName()));
                personElem.appendChild(nameElem);

                Element ageElem = d.createElement("age");
                ageElem.appendChild(d.createTextNode(p.getAge().toString()));
                personElem.appendChild(ageElem);

                Element occupationElem = d.createElement("occupation");
                occupationElem.appendChild(d.createTextNode(p.getOccupation()));
                personElem.appendChild(occupationElem);
            }

            // save your xml file
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(d);
            StreamResult result = new StreamResult(new File("people.xml"));
            transformer.transform(source, result);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        // ########## YOUR CODE ENDS HERE ##########
    }
}
