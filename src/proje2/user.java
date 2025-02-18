
package proje2;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.JPanel;


public abstract class user implements ILoginable {

//arraylist ac company nesneleri hep buraya gelsin
    
    

    /**
     *
     * @param panel
     */
   
    protected abstract  void loginpanel(JPanel panel);
        
    /**
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public abstract int checkInfo(String username, String password);

    public static void ekle(JPanel panel,JTable table){}
    
    /**
     *
     * @param panel
     * @param table
     */
    public abstract void sil(JPanel panel,JTable table);
    
     protected  void onLoginSucces(JPanel panel){
    
     }
     
     public void onLoginFailure()
     {
            JOptionPane.showMessageDialog(null, "Invalid username or password!"); 
     
     }
    
}
