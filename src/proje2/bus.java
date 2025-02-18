/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje2;

/**
 *
 * @author zeyne
 */
public class bus extends vehicle{

    public bus(String arac, int koltuksayisi) {
        super(arac, koltuksayisi);
    }

    //constructor yok metodun içi düzenlencek
    @Override
    public double CalculateFuelCost(int mesafe,int ucret) {
        return mesafe*ucret;
    }
    
}