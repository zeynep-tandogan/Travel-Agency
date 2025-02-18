 package proje2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author zeyne
 */
public class trip {
    //seferler
    //her seferin aracı güzergahı zamanı fiyatı
    private String arac;
    private ArrayList<String> guzergah;
    private int tarih;
    private int fiyat;
    private int koltuk;
    
     public trip(String arac, ArrayList<String> guzergah, int koltuk) {
        this.arac = arac;
        this.guzergah = guzergah;
        this.koltuk = koltuk;
        
    }
     public trip(String arac,ArrayList<String> guzergah)
     {
         this.arac = arac;
        this.guzergah = guzergah;
     }
      
     
     private route sefer1go = new route("istanbul","ankara",375);
     private route sefer1come = new route("ankara","istanbul",375);
     private route sefer2go = new route("istanbul","konya",450);
     private route sefer2come = new route("konya","istanbul",450);
     private route sefer3go1 = new route("istanbul","ankara",500);
     private route sefer3go2 = new route("istanbul","ankara",500);
     private route sefer3come1 = new route("ankara","istanbul",500);
     private route sefer3come2 = new route("ankara","istanbul",500);
     private route sefer4go = new route("istanbul","konya",600);
     private route sefer4come = new route("konya","istanbul",600);
     private route sefer5go = new route("istanbul","konya",300);
     private route sefer5come = new route("konya","istanbul",300);
     private route sefer6go = new route("istanbul","ankara",250);
     private route sefer6come = new route("ankara","istanbul",250);
     
     
       public static void screen(ArrayList<trip> Sefer,JPanel panel) {
    String[] columnNames = {"Arac", "Sefer bilgisi"};

    Object[][] data = new Object[Sefer.size()][2];
    for (int i = 0; i < Sefer.size(); i++) {
        trip sefer = Sefer.get(i);
        data[i][0] = sefer.getArac();
        data[i][1] = String.join(", ", sefer.getGuzergah());
    }

    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    JTable table = new JTable(model);
    table.getColumnModel().getColumn(0).setPreferredWidth(100);
    table.getColumnModel().getColumn(1).setPreferredWidth(430);

    table.setPreferredScrollableViewportSize(new Dimension(600, 100));
    table.setFillsViewportHeight(true);

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(30, 270, 600, 100); 
    table.getTableHeader().setReorderingAllowed(false);
    for (int i = 0; i < table.getColumnCount(); i++) {
        Class<?> columnClass = table.getColumnClass(i);
        table.setDefaultEditor(columnClass, null); 
    }
    
    panel.add(scrollPane);  
    JButton seferEkleButton = new JButton("Sefer Ekle");
    seferEkleButton.setBounds(30, 390, 120, 30);
    seferEkleButton.addActionListener((ActionEvent e) -> {
    JFrame frame = new JFrame("Sefer Ekle");
frame.setSize(300, 200);
frame.setLayout(null);

JTextField aracAdiField = new JTextField();
aracAdiField.setBounds(30, 30, 200, 30);
frame.add(aracAdiField);
// Güzergah için bir JTextField oluştur
JTextField guzergahField = new JTextField();
guzergahField.setBounds(30, 70, 200, 30);
frame.add(guzergahField);

// OK butonu oluştur
JButton okButton = new JButton("OK");
okButton.setBounds(30, 110, 200, 30);
okButton.addActionListener((ActionEvent event) -> {
    // Güzergah ve araç adını al
    String guzergah = guzergahField.getText();
    String aracAdi = aracAdiField.getText();

    ArrayList<String> guzergahList = new ArrayList<>(Arrays.asList(guzergah.split(",")));

    trip yeniSefer = new trip(aracAdi, guzergahList);

    model.addRow(new Object[]{yeniSefer.getArac(), String.join(", ", yeniSefer.getGuzergah())});

    // JFrame'i kapat
    frame.dispose();
});
frame.add(okButton);

frame.setVisible(true);

});
panel.add(seferEkleButton);

   JButton seferSilButton = new JButton("Sefer Sil");
seferSilButton.setBounds(170, 390, 120, 30);
seferSilButton.addActionListener((ActionEvent e) -> {
    // Seçili satırı al
    int selectedRow = table.getSelectedRow();

    if (selectedRow != -1) {
        model.removeRow(selectedRow);
    }
});
panel.add(seferSilButton);
       }

    /**
     * @return the arac
     */
    public String getArac() {
        return arac;
    }

    /**
     * @param arac the arac to set
     */
    public void setArac(String arac) {
        this.arac = arac;
    }

    /**
     * @return the guzergah
     */
    public ArrayList<String> getGuzergah() {
        return guzergah;
    }

    /**
     * @param guzergah the guzergah to set
     */
    public void setGuzergah(ArrayList<String> guzergah) {
        this.guzergah = guzergah;
    }

    /**
     * @return the tarih
     */
    public int getTarih() {
        return tarih;
    }

    /**
     * @param tarih the tarih to set
     */
    public void setTarih(int tarih) {
        this.tarih = tarih;
    }

    /**
     * @return the fiyat
     */
    public int getFiyat() {
        return fiyat;
    }

    /**
     * @param fiyat the fiyat to set
     */
    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    /**
     * @return the koltuk
     */
    public int getKoltuk() {
        return koltuk;
    }

    /**
     * @param koltuk the koltuk to set
     */
    public void setKoltuk(int koltuk) {
        this.koltuk = koltuk;
    }

    /**
     * @return the sefer1go
     */
    public route getSefer1go() {
        return sefer1go;
    }

    /**
     * @param sefer1go the sefer1go to set
     */
    public void setSefer1go(route sefer1go) {
        this.sefer1go = sefer1go;
    }

    /**
     * @return the sefer1come
     */
    public route getSefer1come() {
        return sefer1come;
    }

    /**
     * @param sefer1come the sefer1come to set
     */
    public void setSefer1come(route sefer1come) {
        this.sefer1come = sefer1come;
    }

    /**
     * @return the sefer2go
     */
    public route getSefer2go() {
        return sefer2go;
    }

    /**
     * @param sefer2go the sefer2go to set
     */
    public void setSefer2go(route sefer2go) {
        this.sefer2go = sefer2go;
    }

    /**
     * @return the sefer2come
     */
    public route getSefer2come() {
        return sefer2come;
    }

    /**
     * @param sefer2come the sefer2come to set
     */
    public void setSefer2come(route sefer2come) {
        this.sefer2come = sefer2come;
    }

    /**
     * @return the sefer3go1
     */
    public route getSefer3go1() {
        return sefer3go1;
    }

    /**
     * @param sefer3go1 the sefer3go1 to set
     */
    public void setSefer3go1(route sefer3go1) {
        this.sefer3go1 = sefer3go1;
    }

    /**
     * @return the sefer3go2
     */
    public route getSefer3go2() {
        return sefer3go2;
    }

    /**
     * @param sefer3go2 the sefer3go2 to set
     */
    public void setSefer3go2(route sefer3go2) {
        this.sefer3go2 = sefer3go2;
    }

    /**
     * @return the sefer3come1
     */
    public route getSefer3come1() {
        return sefer3come1;
    }

    /**
     * @param sefer3come1 the sefer3come1 to set
     */
    public void setSefer3come1(route sefer3come1) {
        this.sefer3come1 = sefer3come1;
    }

    /**
     * @return the sefer3come2
     */
    public route getSefer3come2() {
        return sefer3come2;
    }

    /**
     * @param sefer3come2 the sefer3come2 to set
     */
    public void setSefer3come2(route sefer3come2) {
        this.sefer3come2 = sefer3come2;
    }

    /**
     * @return the sefer4go
     */
    public route getSefer4go() {
        return sefer4go;
    }

    /**
     * @param sefer4go the sefer4go to set
     */
    public void setSefer4go(route sefer4go) {
        this.sefer4go = sefer4go;
    }

    /**
     * @return the sefer4come
     */
    public route getSefer4come() {
        return sefer4come;
    }

    /**
     * @param sefer4come the sefer4come to set
     */
    public void setSefer4come(route sefer4come) {
        this.sefer4come = sefer4come;
    }

    /**
     * @return the sefer5go
     */
    public route getSefer5go() {
        return sefer5go;
    }

    /**
     * @param sefer5go the sefer5go to set
     */
    public void setSefer5go(route sefer5go) {
        this.sefer5go = sefer5go;
    }

    /**
     * @return the sefer5come
     */
    public route getSefer5come() {
        return sefer5come;
    }

    /**
     * @param sefer5come the sefer5come to set
     */
    public void setSefer5come(route sefer5come) {
        this.sefer5come = sefer5come;
    }

    /**
     * @return the sefer6go
     */
    public route getSefer6go() {
        return sefer6go;
    }

    /**
     * @param sefer6go the sefer6go to set
     */
    public void setSefer6go(route sefer6go) {
        this.sefer6go = sefer6go;
    }

    /**
     * @return the sefer6come
     */
    public route getSefer6come() {
        return sefer6come;
    }

    /**
     * @param sefer6come the sefer6come to set
     */
    public void setSefer6come(route sefer6come) {
        this.sefer6come = sefer6come;
    }
}