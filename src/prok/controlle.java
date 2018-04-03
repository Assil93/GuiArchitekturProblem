/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;


import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author root
 */
public class controlle {
    GUI view1;
    station Station1;
    
    public controlle(GUI v,station s){
    this.view1=v;
    this.Station1=s;
    DefaultListModel listModel= s.stationidlisten();
    view1.setjlist(listModel);
    view1.selected(new selectedI());
  
    }
    class selectedI implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent e) {
    String selected;
     selected=view1.getselected();
   view1.settext(selected);
   Color color1;
        try {
            station s=Station1.stationinfo(selected);
           view1.setstationid(selected);
           view1.setdate(s.Date);
           view1.setactule(s.Actual);
           view1.settrg(s.Target);
           view1.setvar(s.Variance);
           color1=s.varcolor(s);
           view1.setbackgrundcolor(color1);
           
        } catch (SQLException ex) {
            Logger.getLogger(controlle.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
  }
  }

     
     
    

