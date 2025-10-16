package model;

import javabeans.Actor;
import javabeans.Pelicula;
import javabeans.Usuario;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

    public void escrituraXML(){
        File file = new File("C://ProyectosGithub//LectorEscritorXML_Java//src//resources//peliculas.xml");
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        System.out.println("Escribiendo...");

        Pelicula p1 = new Pelicula(
                "Inception",
                "Christopher Nolan",
                2010,
                new Actor[]{
                        new Actor("Leonardo","DiCaprio"),
                        new Actor("Joseph" ,"Gordon-Levitt"),
                        new Actor("Elliot", "Page")
                },
                "Ciencia Ficción",
                8.8
        );

        Pelicula p2 = new Pelicula(
                "The Matrix",
                "Lana y Lilly Wachowski",
                1999,
                new Actor[]{
                        new Actor("Keanu" ,"Reeves"),
                        new Actor("Laurence","Fishburne"),
                        new Actor("Carrie-Anne","Moss")
                },
                "Ciencia Ficción",
                8.7
        );

        Pelicula p3 = new Pelicula(
                "The Avengers",
                "Joss Whedon",
                2012,
                new Actor[]{
                        new Actor("Robert","Downey Jr."),
                        new Actor("Chris","Evans"),
                        new Actor("Scarlett","Johansson")
                },
                "Acción",
                8.0
        );

        Pelicula p4 = new Pelicula(
                "Forrest Gump",
                "Robert Zemeckis",
                1994,
                new Actor[]{
                        new Actor("Tom","Hanks"),
                        new Actor("Robin", "Wright"),
                        new Actor("Gary", "Sinise")
                },
                "Drama",
                8.8
        );

        Pelicula p5 = new Pelicula(
                "La La Land",
                "Damien Chazelle",
                2016,
                new Actor[]{
                        new Actor("Emma", "Stone"),
                        new Actor("Ryan", "Gosling"),
                        new Actor("John", "Legend")
                },
                "Musical/Romance",
                8.0
        );

        listaPeliculas.add(p1);
        listaPeliculas.add(p2);
        listaPeliculas.add(p3);
        listaPeliculas.add(p4);
        listaPeliculas.add(p5);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();

            Element nodoRoot = document.createElement("cartelera");
            nodoRoot.setAttribute("id","1");
            document.appendChild(nodoRoot);

            for(Pelicula item: listaPeliculas){
                Element nodoPelicula = document.createElement("pelicula");
                nodoPelicula.setAttribute("genero",item.getGenero());
                nodoPelicula.setAttribute("anio",String.valueOf(item.getAnio()));
                nodoRoot.appendChild(nodoPelicula);

                Element nodoTitulo = document.createElement("titulo");
                nodoTitulo.setTextContent(item.getTitulo());
                nodoPelicula.appendChild(nodoTitulo);

                Element nodoDirector = document.createElement("director");
                nodoDirector.setTextContent(item.getDirector());
                nodoPelicula.appendChild(nodoDirector);

                Element nodoActores = document.createElement("actores");
                nodoPelicula.appendChild(nodoActores);

                for(Actor actor: item.getActores()){
                    Element nodoActor = document.createElement("actor");
                    nodoActor.setTextContent(actor.getNombre() + " " + actor.getApellido());
                    nodoActores.appendChild(nodoActor);
                }
            }
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            DOMSource dom = new DOMSource(document);
            StreamResult sr = new StreamResult(new File("C:/ProyectosGithub/LectorEscritorXML_Java/src/resources/peliculas.xml"));

            transformer.transform(dom,sr);
            System.out.println("Archivo XML escrito correctamente");

        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Error en el parseo");
        }


    }
}
