
package proje2;

import java.util.Random;


public abstract class vehicle {

     
    private int boskoltuksayisi;
    private int koltuksayisi;
    private int personelsayisi;
    private String arac;
     
     
    
    public vehicle(String arac,int koltuksayisi) {
        
        this.arac=arac;
        this.koltuksayisi=koltuksayisi;
        Random rand = new Random();
        int randomNum = rand.nextInt(koltuksayisi-1) + 1;
        this.boskoltuksayisi=koltuksayisi-randomNum;
     
    }
 
    public abstract double CalculateFuelCost(int mesafe , int ucret );
    //public double CalculateFuelCost(){
    //return 1;}

    /**
     * @return the boskoltuksayisi
     */
    public int getBoskoltuksayisi() {
        return boskoltuksayisi;
    }

    /**
     * @param boskoltuksayisi the boskoltuksayisi to set
     */
    public int setBoskoltuksayisi(int koltuksayisi) {
       Random rand = new Random();
        int randomNum = rand.nextInt(koltuksayisi) + 1;
        this.boskoltuksayisi=koltuksayisi-randomNum;
        return boskoltuksayisi;
    }

    /**
     * @return the koltuksayisi
     */
    public int getKoltuksayisi() {
        return koltuksayisi;
    }

    /**
     * @param koltuksayisi the koltuksayisi to set
     */
    public void setKoltuksayisi(int koltuksayisi) {
        this.koltuksayisi = koltuksayisi;
    }

    /**
     * @return the personelsayisi
     */
    public int getPersonelsayisi() {
        return personelsayisi;
    }

    /**
     * @param personelsayisi the personelsayisi to set
     */
    public void setPersonelsayisi(int personelsayisi) {
        this.personelsayisi = personelsayisi;
    }
       
    vehicle( int personelsayisi)
    {
        this.personelsayisi = personelsayisi;
    }

    /**
     * @return the arac
     */
    public String getArac() {
        return arac;
    }
}