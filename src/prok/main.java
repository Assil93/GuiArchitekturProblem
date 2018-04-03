/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;
import com.sdz.observer.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author root
 */
public class main {
    public static void main(String[] args) {
           long startTime = System.currentTimeMillis();
    
       station theModel = new station();
       
            for(int i=0; i<2; i++){
      
        GUI theView = new GUI();
          theView.setVisible(true);
        controlle theController = new controlle(theView,theModel);
        theModel.registriereBeobachter(theView);}
       
        
       
        String date=ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
          String id1="";
          for (int  i = 0; i < 4; i++){
             Random rn = new Random();   
              int id=rn.nextInt(89-65 + 1) + 65;
          id1=id1+Character.toString((char) id);
          }
        
          int targt=(int)(Math.random()*100 );
          int act=(int)(Math.random()*100 );
          
         theModel.setstation(id1, date, targt, act);
         theModel.varC(targt, act);
      System.out.println(id1);     
      System.out.println( theModel.varC(targt, act));
      theModel.InsertNewStation(theModel);
   
long endTime = System.currentTimeMillis();
System.out.println("That took " + (endTime - startTime) + " milliseconds");

           }}
