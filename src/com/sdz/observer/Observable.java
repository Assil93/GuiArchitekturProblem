/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdz.observer;

import projekt.notify;

/**
 *
 * @author HP
 */
public interface Observable {
      public void benachrichtigeAlleBeobachter(String str);
    public void registriereBeobachter(Observer obs);
    public void deregistriereBeobachter();  
    
}
