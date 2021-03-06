/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package f13dlaproject;

import static f13dlaproject.Crystal2D.crystal2D;
import static f13dlaproject.Crystal3D.crystal3D;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import static f13dlaproject.Particle.*;
import static f13dlaproject.Particle2D.particle2D;
import static f13dlaproject.Particle3D.particle3D;
import java.io.FileReader;

/**
 * XML Seed 
 * @author stu738510
 */
public class XMLseed {

    /**
     *
     * @param f
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public static void fromXML(File f) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new FileReader(f));
        Document doc = dBuilder.parse(is);
        doc.getDocumentElement().normalize();
        boolean two = true;

        NodeList nList = doc.getElementsByTagName("crystal");
        Node typecheck = nList.item(0);
        Element eCheck = (Element) typecheck;
        if (eCheck.getAttribute("type").equals("2d")) two = true;
        else two = false;
        nList = doc.getElementsByTagName("cparticle");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) nNode;
                if (two) two(e);
                else three(e);
            }
        }

    }
    

    /**
     *
     * @param e
     */
    public static void two(Element e) {
        Point2 p = new Point2(Double.parseDouble(e.getElementsByTagName("x").item(0).getTextContent()), Double.parseDouble(e.getElementsByTagName("y").item(0).getTextContent()));
        particle2D().setPosition(p);
        crystal2D().add(particle2D(), null);
    }

    /**
     *
     * @param e
     */
    public static void three(Element e) {
        Point3 p = new Point3(Double.parseDouble(e.getElementsByTagName("x").item(0).getTextContent()), Double.parseDouble(e.getElementsByTagName("y").item(0).getTextContent()),
                Double.parseDouble(e.getElementsByTagName("z").item(0).getTextContent()));
        particle3D().setPosition(p);
        crystal3D().add(particle3D(), null);
    }
}
