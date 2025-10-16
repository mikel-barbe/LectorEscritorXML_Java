package model;

import javabeans.Usuario;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class OperacionesXML {

    public void lecturaXML(){
        File file = new File("C://ProyectosGithub//LectorEscritorXML_Java//src//resources//usuarios.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);

            NodeList nodoRoot = document.getElementsByTagName("usuario");
            for (int i=0; i<nodoRoot.getLength(); i++){
                Element nodo = (Element) nodoRoot.item(i);
                String nacionalidad = nodo.getAttribute("nacionalidad");
                int edad = Integer.parseInt(nodo.getAttribute("edad"));
                String nombre = nodo.getElementsByTagName("nombre").item(0).getTextContent();
                String apellido = nodo.getElementsByTagName("apellido").item(0).getTextContent();
                Usuario usuario = new Usuario(nombre,apellido,nacionalidad,edad);
                System.out.println("\nUsuario" + i);
                System.out.println("Nombre y apellido: " + nombre + " " + apellido);
                System.out.println("Nacionalidad: " + nacionalidad);
                System.out.println("Edad: " + edad);


            }
        } catch (ParserConfigurationException e) {
            System.out.println("Error en el parseo");
        } catch (IOException e) {
            System.out.println("No tienes permisos de lectura");
        } catch (SAXException e) {
            System.out.println("Error de SAX");;
        }

    }
}
