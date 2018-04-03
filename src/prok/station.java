
package projekt;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import com.sdz.observer.*;
import java.util.ArrayList;

public class station implements Observable {
     private ArrayList<Observer> listObserver = new ArrayList<Observer>(); 
     String StationId;
    String Date ;
    int Target,Actual,Variance;
    
     
    public void setstation(String id , String dat,int Targ,int Actua){
    this.StationId=id;
    this.Date=dat;
    this.Target=Targ;
    this.Actual=Actua;
  
           
    }
     public void InsertNewStation(station stat)
     {
     try {
            
           
            java.sql.Statement stmt=ConnectionManager.getConnection().createStatement();
          stmt.executeUpdate("INSERT INTO station VALUES "+
                  "('"+stat.StationId+"', '"+stat.Date+"','"+stat.Target+"', '"+stat.Actual+"', '"+stat.Variance+"')");
        benachrichtigeAlleBeobachter(this.StationId); 
  //notify msg=new notify();
        //msg.created();
        //msg.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
          
        }
       
     
     }
     public void DeletStation(station stat){
             try {
            
          
            java.sql.Statement stmt=ConnectionManager.getConnection().createStatement();
          stmt.executeUpdate("DELETE FROM station WHERE sid ="+"'"+stat.StationId+"'");
        
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
          }  
      public void UpdateStation(station stat,String statid)
     {
     try {
            
           
            java.sql.Statement stmt=ConnectionManager.getConnection().createStatement();
          stmt.executeUpdate("update station set  "+
                  "sid='"+stat.StationId+"', date ='"+stat.Date+"',target='"+stat.Target+"', actual='"+stat.Actual+"' , var='"+stat.Variance+"' where sid='"+statid+"';");
        
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
   
     }
      public  DefaultListModel  stationidlisten(){
          DefaultListModel listModel = new DefaultListModel();
                try {
            
           
            java.sql.Statement stmt=ConnectionManager.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from station ;");
            while (rs.next()) {
                String sid =rs.getString(1) ;
                
                listModel.addElement(sid);
                
            }
          
        }
                catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return listModel;
      }
      public int varC(int trg,int actv){
          Variance=trg-actv;
          return Variance; 
          
   }      
      public Color varcolor(station a){
        
            Color color1=Color.black;
       if(a.Target>a.Actual)
           { 
               int v=((a.Variance*100)/a.Target);
      if(v>=10){ 
        color1=Color.red; 
      } 
      else 
            color1= Color.black;
           }
       if(a.Target<a.Actual)  
           { 
      int v=((a.Variance*100)/a.Target);
     if((v*-1)>=5){ 
            
        color1= Color.GREEN; }
     else  if ((v*-1)<5) 
         color1=Color.black;
           }

        return color1;
        }      
      public station stationinfo(String selected) throws SQLException{
          station a=new station();
              
            java.sql.Statement stmt=ConnectionManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from station WHERE sid="+"'"+selected+"'");
            while (rs.next()) {
                a.StationId =rs.getString(1) ;
                a.Target=rs.getInt(3);
                a.Variance=rs.getInt(5);
                a.Actual=rs.getInt(4);
                 a.Date=rs.getString(2);
               
                }
            return a;
      }

    

    @Override
    public void registriereBeobachter(Observer obs) {
       this.listObserver.add(obs);
    }

    @Override
    public void deregistriereBeobachter() {
        listObserver = new ArrayList<Observer>();
    }


    public void benachrichtigeAlleBeobachter(String str) {
      

    for(Observer obs : listObserver)
      obs.aktualisiere(str);
    
}

 
}
