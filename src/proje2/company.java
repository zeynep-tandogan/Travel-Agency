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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author zeyne
 */
public class company extends user implements IProfitable{
    
    private String[] usernames;
    private String[] passwords;
    private static double hizmetbedeli=1000;
    private static List<company> firmalar = new ArrayList<>();
    private static List<vehicle> props = new ArrayList<>();    
    company(String[]usernames, String[] passwords)
    {
        this.usernames=usernames;
        this.passwords= passwords;
        
    }
  company(double hizmetbedeli){
      this.hizmetbedeli=hizmetbedeli;
  }
  static{
        getProps().add(new bus("aotobus1",20));
        getProps().add(new bus("aotobus2",15));
        getProps().add(new bus("botobus1",15));
        getProps().add(new bus("botobus2",20));
        getProps().add(new bus("cotobus1",20));
        getProps().add(new airplane("cucak1",30));
        getProps().add(new airplane("cucak2",30));
        getProps().add(new train("dtren1",25));
        getProps().add(new train("dtren2",25));
        getProps().add(new train("dtren",25));
        getProps().add(new airplane("fucak1",30));
        getProps().add(new airplane("fucak2",30));
     
     
      
  }
        private ArrayList<ArrayList<String>> Seferler = new ArrayList<>();

        private ArrayList<String> sefer1 = new ArrayList<>();
        private ArrayList<String> sefer2 = new ArrayList<>();
        private ArrayList<String> sefer3 = new ArrayList<>();
        private ArrayList<String> sefer4 = new ArrayList<>();
        private ArrayList<String> sefer5 = new ArrayList<>();
        private ArrayList<String> sefer6 = new ArrayList<>();

    static {
        getFirmalar().add(new company("A","A123", "3", List.of("karayolu")));
        getFirmalar().add(new company("B","B123", "3,4", List.of("karayolu")));
        getFirmalar().add(new company("C","C123", "4,5", List.of("karayolu","havayolu")));
        getFirmalar().add(new company("D","D123", "1,2", List.of("demiryolu")));
        getFirmalar().add(new company("F","F123", "6", List.of("havayolu")));
    }
    
    private String username;
    private String password;
    private String seferler;
    private List<String> hizmetler;
   
    
     public company(String username, String password,String seferler, List<String> hizmetler ) {
        this.username = username;
        this.password = password;
        this.seferler = seferler;
        this.hizmetler = hizmetler;
       
    }

    company() {
       
    }

    @Override
     public int checkInfo(String username, String password) {
        for(int i=0;i<getUsernames().length;i++)
        {
            if( this.getUsernames()[i].equals(username)&&this.getPasswords()[i].equals(password))
                return i;
        }
        return -1;
    }

    /**
     *
     * @param panel
     */
    public static void ekle(JPanel panel,ArrayList<vehicle> firma ) {
      
           JButton addarac = new JButton("arac ekle");
          addarac.setBounds(70,200, 100, 30);
          addarac.setForeground(Color.ORANGE);
          addarac.setBackground(Color.DARK_GRAY); // Butonun arka plan rengini ayarlamak için setBackground kullanılır
          addarac.setFont(new Font("Arial", Font.BOLD, 14)); 
          
              
            addarac.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  JFrame frame2 = new JFrame("arac ekle");
            JPanel panel2 = new JPanel();

            JLabel aracadilabel = new JLabel("arac girin");
            JTextField aracadifield = new JTextField(20);

            JLabel koltuksayisilabel = new JLabel("koltuk sayisi gir:");
            JTextField koltuksayisifield = new JTextField(20);
             JButton okButton = new JButton("OK");
              
             panel2.add(aracadilabel);
             panel2.add(aracadifield);
             panel2.add(koltuksayisilabel);
             panel2.add(koltuksayisifield);
             panel2.add(okButton);
              panel2.setLayout(new GridLayout(4, 2));
            frame2.add(panel2);
            frame2.setSize(300, 200);
            frame2.setVisible(true);
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

             okButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     
               String aracAdi = aracadifield.getText();
               int koltukSayisi = Integer.parseInt(koltuksayisifield.getText());

               // Yeni araç oluştur ve listeye ekle
              bus yeniArac = new bus(aracAdi, koltukSayisi);
              firma.add(yeniArac);
               
              screen(firma,panel);

                }
                
              });     
              
              };    
           });   
           
           panel.add(addarac);    
    }
    
    ///////
    
   public static void sil(JPanel panel, JTable table, ArrayList<vehicle> firma) {
    JButton remove = new JButton("arac sil");
    remove.setBounds(270, 200, 100, 30);
    remove.setForeground(Color.ORANGE);
    remove.setBackground(Color.DARK_GRAY);
    remove.setFont(new Font("Arial", Font.BOLD, 14));

    remove.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int[] seciliSatirlar = table.getSelectedRows();
            for (int i = seciliSatirlar.length - 1; i >= 0; i--) {
                String aracadi = (String) table.getValueAt(seciliSatirlar[i], 0);
                int koltuksayisi  = (Integer) table.getValueAt(seciliSatirlar[i], 1);

                // 'firma' listesinden aracı bul ve sil
                for (int j = firma.size() - 1; j >= 0; j--) {
                    if (firma.get(j).getArac().equals(aracadi) && firma.get(j).getKoltuksayisi() == koltuksayisi) {
                        firma.remove(j);
                        break;
                    }
                }

                ((DefaultTableModel) table.getModel()).removeRow(seciliSatirlar[i]);
            }
        }
    });

    panel.add(remove);
}

    
     public void sil(ArrayList<vehicle> firma) {
         
        
}
  

    @Override
     protected  void loginpanel(JPanel panel)
    {
         panel.removeAll();
         panel.revalidate(); // Yenileme işlemi
         panel.repaint();

       JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(70,30,150,30);
        usernameLabel.setForeground(Color.ORANGE);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
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
        //debug
        System.out.println("panel koyma calısıyor");
        loginButton.addActionListener(e -> {
           
            //debug
            System.out.println("buton calısıyor");
            //firmalardan al ilk iki elemanlar
            String[] usernames = new String[getFirmalar().size()];
         String[] passwords = new String[getFirmalar().size()];

         for (int i = 0; i < getFirmalar().size(); i++) {
         company firma = getFirmalar().get(i);
         usernames[i] = firma.getUsername();
         passwords[i] = firma.getPassword();
       }
            company company =new company(usernames,passwords);
           
            String username = usernameField.getText();
            char[] passwordc = passwordField.getPassword();
            String password = new String(passwordc);
            
        int val=company.checkInfo(username ,password);
         if(company.checkInfo(username ,password)!=-1)
         {
            panel.removeAll();
            panel.revalidate(); // Yenileme işlemi
            panel.repaint();
             JButton backButton = new JButton("Geri");
        backButton.setBounds(0, 0, 80, 20);  

        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Geri butonuna tıklandı!");
                loginpanel(panel);
            }
        });
        
        panel.add(backButton);
         seferler(Seferler,sefer1,sefer2,sefer3,sefer4,sefer5,sefer6);
        switch( getFirmalar().get(val).getUsername())
        {
           case "A":
            {  
               List<vehicle> A = getProps().subList(0, 2);
               List sublist = A.subList(0,A.size());
               ArrayList a = new ArrayList(sublist);
               screen(a,panel);
              
               ArrayList<trip> Sefer = new ArrayList<>();
              Sefer.add(new trip("otobus1", getSefer3()));
              Sefer.add(new trip( "otobus2", getSefer3()));
              trip.screen(Sefer,panel);
               
            
            //ekle sil butonları
            
            //
            
              System.out.println("A");
              panel.setLayout(null);
              panel.setVisible(true);
            }
            break;
            case "B":
            {
             
              
              List<vehicle> B = getProps().subList(2, 4);
         List sublist = B.subList(0,B.size());
             ArrayList b = new ArrayList(sublist);
            screen(b,panel);
                 ArrayList<trip> Sefer = new ArrayList<>();
              Sefer.add(new trip("otobus2", getSefer4()));
              Sefer.add(new trip("otobus1", getSefer3()));
        
                 
                 trip.screen(Sefer,panel);
                System.out.println("B");
              
                
            }
             break;  
            case "C":
            {
             
                System.out.println("C");
                
                List<vehicle> C = getProps().subList(4, 7);
            List sublist = C.subList(0,C.size());
             ArrayList c = new ArrayList(sublist);
            screen(c,panel);
            
              ArrayList<trip> Sefer = new ArrayList<>();
              Sefer.add(new trip("otobus1", getSefer4()));
              Sefer.add(new trip("ucak1", getSefer5()));
              Sefer.add(new trip("ucak2", getSefer5()));
           trip.screen(Sefer,panel);
         
              panel.setLayout(null);
              panel.setVisible(true);
                
            }
             break;
            case "D":
            {
              
                System.out.println("D");
         
                List<vehicle> D = getProps().subList(7, 10);
              List sublist = D.subList(0,D.size());
             ArrayList d = new ArrayList(sublist);
            screen(d,panel);
              
              ArrayList<trip> Sefer = new ArrayList<>();
              Sefer.add(new trip("tren1", getSefer1()));
              Sefer.add(new trip("tren2", getSefer2()));
              Sefer.add(new trip("tren3", getSefer2()));
             trip.screen(Sefer,panel);
             
              panel.setLayout(null);
              panel.setVisible(true);
         
            }
             break; 
            case "F":
            {
               
              List<vehicle> F = getProps().subList(10,12);
              List sublist = F.subList(0,F.size());
             ArrayList f = new ArrayList(sublist);
            screen(f,panel);
            ArrayList<trip> Sefer = new ArrayList<>();
              Sefer.add(new trip("ucak1", getSefer6()));
              Sefer.add(new trip("ucak2", getSefer6()));
              
             trip.screen(Sefer,panel);
            
                System.out.println("F");
              panel.setLayout(null);
              panel.setVisible(true);
            }
             break;
            default:
            {
              
             
            }
             break;
        }
           
        }
        
         else onLoginFailure();
             
        });
        
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.setLayout(null);
        panel.setVisible(true);
    }
  @Override
    public double calculateProfit(double hizmetBedeli, double yolcuUcreti, double personelUcreti, double yakıtUcreti) {
        double kar = yolcuUcreti - hizmetBedeli - personelUcreti - yakıtUcreti;        
        return kar;    
    }
public void calculatepanel(JPanel panel,Object[][] data){
    JPanel panel2 = new JPanel();

    Integer[] items = {4, 5, 6, 7, 8, 9, 10};
    JComboBox<Integer> comboBox = new JComboBox<>(items);

    Integer secilendeger = (Integer) comboBox.getSelectedItem();
    switch (secilendeger)
    {
        case 4:
        {
            int val =2;
                    
            break;
        }
        case 5:
        {
             int val =3;
            break;
        }
        case 6:
        {
             int val =4;
            break;
        }
        case 7:
        {
             int val =5;
            break;
        }
        case 8:
        {
             int val =6;
            break;
        }
        case 9:
        {
             int val =7;
            break;
        }
        case 10:
        {
             int val =8;
            break;
        }
        
            
    }
    panel2.add(comboBox);

    panel.add(panel2);
}

    /**
     * @return the ad
     */
  

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the seferler
     */
    public String getSeferler() {
        return seferler;
    }

    /**
     * @return the hizmetler
     */
    public List<String> getHizmetler() {
        return hizmetler;
    }

    /**
     * @return the firmalar
     */
    public static List<company> getFirmalar() {
        return firmalar;
    }

    /**
     * @param aFirmalar the firmalar to set
     */
    public static void setFirmalar(List<company> aFirmalar) {
        firmalar = aFirmalar;
    }
    //remove yada add ile burda olmazsa... aslında get setle en mantıklısı

    /**
     * @return the hizmetbedeli
     */
    public double getHizmetbedeli() {
        return hizmetbedeli;
    }

    /**
     * @param hizmetbedeli the hizmetbedeli to set
     */
    public static void setHizmetbedeli(double hizmetbedeli) {
        company.hizmetbedeli = hizmetbedeli;
    }

    /**
     * @return the usernames
     */
    public String[] getUsernames() {
        return usernames;
    }

    /**
     * @param usernames the usernames to set
     */
    public void setUsernames(String[] usernames) {
        this.setUsernames(usernames);
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
   
   
 public static void screen(ArrayList<vehicle> firma,JPanel panel) {
    String[] columnNames = {"Arac","Koltuk Sayısı","4","5","6","7","8","9","10"};

   
    Object[][] data = new Object[firma.size()][10];
    for (int i = 0; i < firma.size(); i++) {
        data[i][0] = firma.get(i).getArac(); 
        data[i][1] = firma.get(i).getKoltuksayisi(); 
        for (int j = 2; j < 10; j++) {
            data[i][j] = firma.get(i).setBoskoltuksayisi(firma.get(i).getKoltuksayisi()); 
        }
    }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
       table.getColumnModel().getColumn(1).setPreferredWidth(430);
       table.getColumnModel().getColumn(2).setPreferredWidth(70);
       
        table.setPreferredScrollableViewportSize(new Dimension(600, 100));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
       scrollPane.setBounds(30, 70, 600, 100); 
                table.getTableHeader().setReorderingAllowed(false);
                for (int i = 0; i < table.getColumnCount(); i++) {
                     Class<?> columnClass = table.getColumnClass(i);
                     table.setDefaultEditor(columnClass, null); 
                }
     
    ekle(panel,firma  );
    sil(panel,table,firma);
        panel.add(scrollPane);

       panel.setLayout(null);
       panel.setVisible(true);
         
    }

    @Override
    public void sil(JPanel panel, JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
    public static void seferler(ArrayList<ArrayList<String>> Seferler,ArrayList<String> sefer1,ArrayList<String> sefer2 ,ArrayList<String> sefer3, ArrayList<String> sefer4, ArrayList<String> sefer5, ArrayList<String> sefer6)
    {
         
       sefer1.add("istanbul");
       sefer1.add("kocaeli");
       sefer1.add("bilecik");
       sefer1.add("eskişehir");
       sefer1.add("ankara");
       sefer1.add("eskişehir");
       sefer1.add("bilecik");
       sefer1.add("kocaeli");
       sefer1.add("istanbul");

       Seferler.add(sefer1);
   
       sefer2.add("istanbul");
sefer2.add("kocaeli");
sefer2.add("bilecik");
sefer2.add("eskişehir");
sefer2.add("konya");
sefer2.add("eskişehir");
sefer2.add("bilecik");
sefer2.add("kocaeli");
sefer2.add("istanbul");

Seferler.add(sefer2);

 
sefer4.add("istanbul");
sefer4.add("kocaeli");
sefer4.add("eskişehir");
sefer4.add("konya");
sefer4.add("eskişehir");
sefer4.add("kocaeli");

Seferler.add(sefer4);


sefer5.add("istanbul");
sefer5.add("konya");
sefer5.add("istanbul");


sefer6.add("istanbul");
sefer6.add("ankara");
sefer6.add("istanbul");

Seferler.add(sefer5);
Seferler.add(sefer6);

        
                sefer3.add("istanbul");
                sefer3.add("kocaeli");
                sefer3.add("ankara");
                sefer3.add("kocaeli");
                sefer3.add("istanbul");
                sefer3.add("kocaeli");
                sefer3.add("ankara");
                sefer3.add("kocaeli");
                sefer3.add("istanbul"); 
       Seferler.add(sefer3);
    }   

    /**
     * @param usernames the usernames to set
     */
  

    /**
     * @return the passwords
     */
    public String[] getPasswords() {
        return passwords;
    }

    /**
     * @param passwords the passwords to set
     */
    public void setPasswords(String[] passwords) {
        this.passwords = passwords;
    }

    /**
     * @return the props
     */
    public static List<vehicle> getProps() {
        return props;
    }

    /**
     * @param aProps the props to set
     */
    public static void setProps(List<vehicle> aProps) {
        props = aProps;
    }

    /**
     * @param Seferler the Seferler to set
     */
    public void setSeferler(ArrayList<ArrayList<String>> Seferler) {
        this.Seferler = Seferler;
    }

    /**
     * @return the sefer1
     */
    public ArrayList<String> getSefer1() {
        return sefer1;
    }

    /**
     * @param sefer1 the sefer1 to set
     */
    public void setSefer1(ArrayList<String> sefer1) {
        this.sefer1 = sefer1;
    }

    /**
     * @return the sefer2
     */
    public ArrayList<String> getSefer2() {
        return sefer2;
    }

    /**
     * @param sefer2 the sefer2 to set
     */
    public void setSefer2(ArrayList<String> sefer2) {
        this.sefer2 = sefer2;
    }

    /**
     * @return the sefer3
     */
    public ArrayList<String> getSefer3() {
        return sefer3;
    }

    /**
     * @param sefer3 the sefer3 to set
     */
    public void setSefer3(ArrayList<String> sefer3) {
        this.sefer3 = sefer3;
    }

    /**
     * @return the sefer4
     */
    public ArrayList<String> getSefer4() {
        return sefer4;
    }

    /**
     * @param sefer4 the sefer4 to set
     */
    public void setSefer4(ArrayList<String> sefer4) {
        this.sefer4 = sefer4;
    }

    /**
     * @return the sefer5
     */
    public ArrayList<String> getSefer5() {
        return sefer5;
    }

    /**
     * @param sefer5 the sefer5 to set
     */
    public void setSefer5(ArrayList<String> sefer5) {
        this.sefer5 = sefer5;
    }

    /**
     * @return the sefer6
     */
    public ArrayList<String> getSefer6() {
        return sefer6;
    }

    /**
     * @param sefer6 the sefer6 to set
     */
    public void setSefer6(ArrayList<String> sefer6) {
        this.sefer6 = sefer6;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param seferler the seferler to set
     */
    public void setSeferler(String seferler) {
        this.seferler = seferler;
    }

    /**
     * @param hizmetler the hizmetler to set
     */
    public void setHizmetler(List<String> hizmetler) {
        this.hizmetler = hizmetler;
    }
      
    
    
}
