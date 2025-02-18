
package proje2;

/**
 *
 * @author zeyne
 */
public class airplane extends vehicle {

    public airplane(String arac, int koltuksayisi) {
        super(arac, koltuksayisi);
    }
    @Override
    public double CalculateFuelCost(int mesafe,int ucret) {
        
        return ucret*mesafe;
    }
    
}