/*package ru.nc.logic;

import java.util.*;
import ru.nc.data.*;





public class Controller {
	List<Airport> aports = new ArrayList<Airport>();
	List<Plane> planes = new ArrayList<Plane>();
        List<Town> towns = new ArrayList<Town>();
        List<Ticket> tickets = new ArrayList<Ticket>();
        List<Flight> flights = new ArrayList<Flight>();
        
        
	
	
	
	void LoadAiports(String filemane){
		
	}
	
	void LoadPlains(String filename){
		
	}
	
	void LoadFlights(String filename){
		
	} 
	
	void LoadTowns(String filename){
		
	}
	
	void LoadTickets(String filename){
		
	}
        
        void add(Town t){
            towns.add(t);
        }
        
        void add(Ticket t){
            tickets.add(t);
        }
         
        void add(Plane t){
            planes.add(t);
        }
        
        void add (Airport t){
            aports.add(t);
        }
        
        void add(Flight t){
            flights.add(t);
        }
	
          
	

}**/
package ru.nc.logic;

import ru.nc.data.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.util.*;
public class Controller {
    List<Airport> aports = new ArrayList<Airport>();
    List<Plane> planes = new ArrayList<Plane>();
    List<Town> towns = new ArrayList<Town>();
    List<Ticket> tickets = new ArrayList<Ticket>();
    List<Flight> flights = new ArrayList<Flight>();
    
    public void loadXml(String xmlFileName){
    try {
 
	File xmlFile=new File(xmlFileName);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(xmlFile);
 
	doc.getDocumentElement().normalize();
        
        boolean correctXml=true;
        
        
        Element root=doc.getDocumentElement();
        
        if (root.getNodeName().equals("Towns")){
 
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
            NodeList nList = doc.getElementsByTagName("town");
 
            System.out.println("***********************************");
 
            for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
 
			
			System.out.println("name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                        String name =eElement.getElementsByTagName("name").item(0).getTextContent();
			System.out.println("town id : " + eElement.getElementsByTagName("id").item(0).getTextContent());
                        System.out.println();
                        Long id = Long.decode(eElement.getElementsByTagName("id").item(0).getTextContent());
                        
                        this.add(new Town(id, name));
		}
            }
        } 
        
        if (root.getNodeName().equals("Airports")){
 
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
            NodeList nList = doc.getElementsByTagName("Airport");
 
            System.out.println("***********************************");
 
            for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
 
			System.out.println("Airport id : " + eElement.getElementsByTagName("airportId").item(0).getTextContent());
                        System.out.println("Town id : " + eElement.getElementsByTagName("locationId").item(0).getTextContent());
			System.out.println("Airport name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                        Long airportId = Long.decode(eElement.getElementsByTagName("airportId").item(0).getTextContent());
                        Long locationId = Long.decode(eElement.getElementsByTagName("locationId").item(0).getTextContent());
                        String name =eElement.getElementsByTagName("name").item(0).getTextContent();
                        System.out.println();
                        this.add(new Airport(airportId,locationId, name));
		}
            }
        }
          
    } catch (Exception e) {
	e.printStackTrace();
        }
    }
	
    public void saveXml(String xmlFileName){	
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        try {
            DocumentBuilder db = factory.newDocumentBuilder();
            DOMImplementation domImplementation = db.getDOMImplementation();
            Document doc = domImplementation.createDocument(null, "XML_File", null);
            
            buildTree(doc, doc.getDocumentElement());
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            Properties transfProps = new Properties();
            transfProps.put("method", "xml");
            transfProps.put("indent", "yes");
            transformer.setOutputProperties(transfProps);
            
            DOMSource source = new DOMSource(doc);
            OutputStream out = new FileOutputStream(new File(xmlFileName));
            StreamResult result =  new StreamResult(out);
            
            transformer.transform(source, result);
            try {
                out.close();
            } catch (Exception ex) {}            
        } catch (Exception ex) {
            System.err.println("XML error\n"+ex.toString());
        }		        
	}
	
	
    public <T> void add(T object){	
        if(object instanceof Town){	       
            towns.add((Town) object);      
        }	
        
        if(object instanceof Airport){
            aports.add((Airport) object);            
        }        
    }
	
	
    public int remove(Long objId){
        for(Town i: towns){
            if(i.getId().equals(objId)){			
                towns.remove(i);		
                return 0;		
            }
        }	
        for(Airport i: aports){
            if(i.getAirportId().equals(objId)){		
                aports.remove(i);		
                return 0;		
            }	
        }
        return 0;
    }
		
    private void buildTree(Document doc, Element root) {    
        doc.setXmlStandalone(true);
        doc.setStrictErrorChecking(true);
        doc.setXmlVersion("1.0");
        
        Element subRoot;     
        Element e;
        
        subRoot = createElement(doc, "Towns", null);
        for(Town i: towns){		
            String[] args = {"name","id"};	
            e = createXmlObj(doc,"town", args,i.getName(),i.getId().toString());
            //e.setAttribute("id", i.getId().toString());
            subRoot.appendChild(e); 	
        }	  
        root.appendChild(subRoot);
        
        
        subRoot = createElement(doc, "Airports", null);  
        for(Airport i: aports){	
        	String[] args = {"airportId","locationId","name"};
        	e = createXmlObj(doc,"Airport", args,i.getAirportId().toString(),i.getLocationId().toString(),i.getAirportName());
           	//e.setAttribute("airportId", i.getAirportId().toString());
        	subRoot.appendChild(e); 
		}	  
        root.appendChild(subRoot);
        
        
    }	
		
    private Element createXmlObj(Document doc, String root, String[] args, String ... values){	
        Element e = createElement(doc, root, null);	
        for(int i = 0; i < args.length; i++){		
            e.appendChild(createElement(doc, args[i], values[i]));	
        }	
        return e;	
    }		
    private Element createElement(Document doc, String name, String textContent) {
        Element elem = doc.createElement(name);        
        if(textContent!=null)
            elem.setTextContent(textContent);
        return elem;
    }
	
	

}


