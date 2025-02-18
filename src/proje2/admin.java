/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static proje2.Main.printtext;
import static proje2.company.getFirmalar;

/**
 *
 * @author zeyne
 */
public class admin extends user{
    
     private  static String username ;
     private static String password ;
   
    
  /**
     * @return the username
     */
    public static String getUsername() {
        return username;
    }

    
     
    public static void setUsername(String username) {
        admin.username = username;
    }

    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

    
  
    public static void setPassword(String password) {
        admin.password = password;
    }
   

    public admin(String username,String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return
     */
    @Override
    public int checkInfo(String username, String password) {
        return this.getUsername().equals(username) && this.getPassword().equals(password) ? 1: 0;
    }

    /**
     *
     * @param panel
     */
    public static void ekle(JPanel panel,JTable table) {
    JButton addCompany = new JButton("ekle");
    addCompany.setBounds(70,300, 100, 30);
    addCompany.setForeground(Color.ORANGE);
    addCompany.setBackground(Color.DARK_GRAY);
    addCompany.setFont(new Font("Arial", Font.BOLD, 14)); 

    addCompany.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame2 = new JFrame("Firma Bilgileri");
            JPanel panel = new JPanel();

            JLabel firmaAdiLabel = new JLabel("Firma Adı Giriniz:");
            JTextField firmaAdiField = new JTextField(20);

            JLabel sifreLabel = new JLabel("sifre Giriniz:");
            JTextField sifreField = new JTextField(20);

            JLabel seferLabel = new JLabel("Sefer Giriniz:");
            JTextField seferField = new JTextField(20);

            JLabel hizmetLabel = new JLabel("Hizmet Giriniz:");
            JTextField hizmetField = new JTextField(20);

            JButton okButton = new JButton("OK");

            panel.add(firmaAdiLabel);
            panel.add(firmaAdiField);
            panel.add(sifreLabel);
            panel.add(sifreField);
            panel.add(seferLabel);
            panel.add(seferField);
            panel.add(hizmetLabel);
            panel.add(hizmetField);
            panel.add(okButton);

            panel.setLayout(new GridLayout(5, 3));
            frame2.add(panel);
            frame2.setSize(300, 200);
            frame2.setVisible(true);
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            okButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String yeniFirma = firmaAdiField.getText();
                    String yeniSifre = sifreField.getText();
                    String yeniSefer = seferField.getText();
                    String yeniHizmet = hizmetField.getText();
                    

                   company.getFirmalar().add(new company(yeniFirma,yeniSifre ,yeniSefer, List.of(yeniHizmet)));
                    Object[][] data = new Object[getFirmalar().size()][4];
                    for (int i = 0; i < getFirmalar().size(); i++) {
                        company firma = getFirmalar().get(i);
                        data[i][0] = firma.getUsername();
                        data[i][1]= firma.getPassword();
                        data[i][2] = firma.getSeferler();
                        data[i][3] = String.join(", ", firma.getHizmetler());
                    }
                    String[] columnNames = {"Firma Adı", "sifre","Sefer", "Hizmetler"};
                    
                    DefaultTableModel model = new DefaultTableModel(data, columnNames);
                    table.setModel(model);
                    table.setPreferredScrollableViewportSize(new Dimension(500, 200));
                    table.setFillsViewportHeight(true);

                    System.out.println("Yeni Firma: " + yeniFirma); 
                    System.out.println("Yeni Sefer: " + yeniSefer);
                    System.out.println("Yeni Hizmet: " + yeniHizmet);
                }
            });
        }
    });

    panel.add(addCompany);
}
//
   public void ekle(company yeniFirma) {
        List<company> afirmalar = getFirmalar();
        afirmalar.add(yeniFirma);
        company.setFirmalar(afirmalar);
  }
    
    @Override
    public void sil(JPanel panel,JTable table) {
       JButton remove = new JButton("sil");
          remove.setBounds(270,300, 100, 30);
          remove.setForeground(Color.ORANGE);
          remove.setBackground(Color.DARK_GRAY); // Butonun arka plan rengini ayarlamak için setBackground kullanılır
          remove.setFont(new Font("Arial", Font.BOLD, 14));
           
          remove.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int[] seciliSatirlar = table.getSelectedRows();
            for (int i = seciliSatirlar.length - 1; i >= 0; i--) {
                String firmaAdi = (String) table.getValueAt(seciliSatirlar[i], 0);
                String sifre = (String) table.getValueAt(seciliSatirlar[i], 1);
                String sefer = (String) table.getValueAt(seciliSatirlar[i], 2);
                String hizmetler = (String) table.getValueAt(seciliSatirlar[i], 3);
                company firma = new company(firmaAdi, sifre, sefer, Arrays.asList(hizmetler.split(", ")));
                // 'firma' nesnesi şimdi silinen satırdaki değerlere sahip
                sil(firma);

                ((DefaultTableModel) table.getModel()).removeRow(seciliSatirlar[i]);
            }
        }
    });

    panel.add(remove);

                
    
    }
      
    
    public void sil(company firma) {
         List<company> afirmalar = getFirmalar();
        afirmalar.remove(firma);
        company.setFirmalar(afirmalar);
        
}
    
     @Override
      protected  void loginpanel(JPanel panel)
    {
        printtext("username",panel,70,30,150,30,16);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(200,30,100,30);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(70,90,100,30);
        passwordLabel.setForeground(Color.ORANGE);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200,90,100,30);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(110,150, 100, 30);
        loginButton.setForeground(Color.ORANGE);
        loginButton.setBackground(Color.DARK_GRAY); // Butonun arka plan rengini ayarlamak için setBackground kullanılır
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        loginButton.addActionListener(e -> {
            
            System.out.println("panel koyma calısıyor");
            admin admin =new admin("admin","123");
           
            String username = usernameField.getText();
            char[] passwordc = passwordField.getPassword();
            String password = new String(passwordc);

         if(admin.checkInfo(username ,password)==1)
         {
            panel.removeAll();
            panel.revalidate(); // Yenileme işlemi
            panel.repaint();
           
         onLoginSucces(panel);
            
         }
         else onLoginFailure();
         
        });
        
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.setLayout(null);
        panel.setVisible(true);
    }
      
     @Override
      protected void onLoginSucces(JPanel panel)
      {
         printtext("FİRMALAR",panel,200,10,300,50,16);
        
        
         String[] columnNames = {"Firma Adı", "sifre","Sefer", "Hizmetler"};

      
        Object[][] data = new Object[company.getFirmalar().size()][4];
        for (int i = 0; i < company.getFirmalar().size(); i++) {
            company firma = company.getFirmalar().get(i);
            data[i][0] = firma.getUsername();
            data[i][1]= firma.getPassword();
            data[i][2] = firma.getSeferler();
            data[i][3] = String.join(", ", firma.getHizmetler());
            
        }

      
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        
       
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);
        
        
         JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setBounds(30, 70, 400, 200); 
                table.getTableHeader().setReorderingAllowed(false);
                for (int i = 0; i < table.getColumnCount(); i++) {
                     Class<?> columnClass = table.getColumnClass(i);
                     table.setDefaultEditor(columnClass, null); 
                }
       
         panel.add(scrollPane);
          panel.setLayout(null);
        panel.setVisible(true); 
        //debug
          System.out.println("onLoginSucces() calısıyor");
          
          ekle(panel,table);
          sil(panel,table);
          
           JPanel panel2 = new JPanel();
          panel2.setBackground(Color.DARK_GRAY);
          panel2.setBounds(30, 350, 400, 60);
          JLabel priceLabel = new JLabel("Hizmet Bedeli:");
          priceLabel.setBounds(40, 10, 200, 30);
         
          priceLabel.setForeground(Color.ORANGE);
          priceLabel.setFont(new Font("Arial", Font.BOLD, 16));
          JTextField priceField = new JTextField();
          priceField.setBounds(240, 10, 100, 30);

 
  priceField.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String priceText = priceField.getText();
        if (!priceText.isEmpty()) {
            double price = Double.parseDouble(priceText);
            company.setHizmetbedeli(price);
        }
    }
});

                panel.add(panel2);
                panel2.add(priceLabel);
                panel2.add(priceField);
                priceLabel.setBounds(40, 10, 200, 30);
                priceField.setBounds(240, 10, 100, 30);
                panel.setLayout(null);
                panel.setVisible(true);
                panel2.setLayout(null);
                panel2.setVisible(true);
        
          
      }
}

   
    
   