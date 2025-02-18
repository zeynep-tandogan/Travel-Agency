/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zeyne
 */
public class ucretler {
  
    private ArrayList<Integer> karayolu;
    private ArrayList<Integer> demiryolu;
    private ArrayList<Integer> havayolu;
    private ArrayList<Integer> kullanan;
    private ArrayList<Integer> hizmet;
    private ArrayList<Integer> kilometreyakit;
    
    
    public ucretler() {
       karayolu =new ArrayList<>();
        demiryolu = new ArrayList<>();
        havayolu = new ArrayList<>();
      
         /*ikocaeli  iankara  ieskişehir 
      ikonya kocaeliankara  kocaeski
      koko   eskikonya  ibilecik  */
        karayolu.add(50);
        karayolu.add(300);
        karayolu.add(150);
        karayolu.add(300);
        karayolu.add(400);
        karayolu.add(100);
        karayolu.add(250);
        karayolu.add(150);
        
        
         /*istkoc  isbi  isan  ises  iskon  kobi  koa  koe  koko
        bia  bie konbi esan  eskon */
        demiryolu.add(50);
        demiryolu.add(150);
        demiryolu.add(250);
        demiryolu.add(200);
        demiryolu.add(50);
        demiryolu.add(200);
        demiryolu.add(100);
        demiryolu.add(250);
        demiryolu.add(150);
        demiryolu.add(50);
        demiryolu.add(200);
        demiryolu.add(100);
        demiryolu.add(150);
        
        /*isank  isko*/
        
        havayolu.add(1000);
        havayolu.add(1200);
        
        //A B Co D F Cu
        
        kullanan.add(5000);
        kullanan.add(3000);
        kullanan.add(4000);
        kullanan.add(2000);
        kullanan.add(7500);
        kullanan.add(10000);
        
        
        hizmet.add(2000);
        hizmet.add(1500);
        hizmet.add(2000);
        hizmet.add(1000);
        hizmet.add(4000);
        hizmet.add(6000);
        
        
        kilometreyakit.add(10);
        kilometreyakit.add(5);
        kilometreyakit.add(6);
        kilometreyakit.add(3);
        kilometreyakit.add(20);
        kilometreyakit.add(25);
        
      
    }  
 
}
