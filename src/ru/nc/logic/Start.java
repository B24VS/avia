/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.nc.logic;
import ru.nc.data.*;
import ru.nc.logic.Controller;

public class Start {
    public static void main(String args[]){
       Controller xmlCon = new Controller(); 
           xmlCon.loadXml("Towns.xml");
           xmlCon.loadXml("Airports.xml");
           Town t = new Town(1,"New York");
           Airport a = new Airport(1,1,"NY Airport");
           xmlCon.add(a);
           xmlCon.saveXml("Test1.xml");
           
       
           
         
       
    }
    
}
