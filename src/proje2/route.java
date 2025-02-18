/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje2;

/**
 *
 * @author zeyne
 */
public class route {
    //kalkıs varış noktası mesafe
    //argüman alsın 
    private String kalkıs ;
    private String varıs ;
    private int mesafe;
    //listenin ilk elemanı listenin son elemanı
    //customer dan alınan kalkıs varıs burda olsun metot falan
    //diğer clas gereksimlerle burda birleşsin
    route(String kakıs,String varıs,int mesafe){
         
        this.mesafe=  mesafe;
        this.kalkıs = kalkıs;
        this.varıs = varıs;
        
    }

    /**
     * @return the kalkıs
     */
    public String getKalkıs() {
        return kalkıs;
    }

    /**
     * @param kalkıs the kalkıs to set
     */
    public void setKalkıs(String kalkıs) {
        this.kalkıs = kalkıs;
    }

    /**
     * @return the varıs
     */
    public String getVarıs() {
        return varıs;
    }

    /**
     * @param varıs the varıs to set
     */
    public void setVarıs(String varıs) {
        this.varıs = varıs;
    }

    /**
     * @return the mesafe
     */
    public int getMesafe() {
        return mesafe;
    }

    /**
     * @param mesafe the mesafe to set
     */
    public void setMesafe(int mesafe) {
        this.mesafe = mesafe;
    }
    
}
