package proje2;

import javax.swing.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.util.ArrayList;



/**
 *
 * @author zeyne
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        JFrame frame = new JFrame("biletgo");
        frame.setSize(700, 500);
        frame.getContentPane().setBackground(Color.WHITE);

        JTabbedPane tabbedPane = new JTabbedPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





        JPanel CustomerPanel = createCustomerPanel();
        JPanel AdminPanel = createAdminPanel();
        JPanel CompanyPanel = createCompanyPanel();


        tabbedPane.addTab("customer",CustomerPanel);
        tabbedPane.addTab("Admin", AdminPanel);
        tabbedPane.addTab("Company", CompanyPanel);





        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private static  JPanel createAdminPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        proje2.admin  admin =new proje2.admin("admin","123");
        admin.loginpanel(panel);




        panel.setLayout(null);
        panel.setVisible(true);

        return panel;
    }

    private static JPanel createCompanyPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);


        company company = new company();
        company.loginpanel(panel);





        panel.setLayout(null);
        panel.setVisible(true);

        return panel;
    }

    private static JPanel createCustomerPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null); // Set layout to null for manual positioning
        panel.setBackground(Color.WHITE);

        JLabel greetings = new JLabel("BİLETGO'YA HOŞ GELDİNİZ :)");
        greetings.setBounds(30, 40, 250, 40);
        greetings.setForeground(Color.ORANGE);
        greetings.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel fromWhere = new JLabel("Kalkış Noktası");
        fromWhere.setBounds(30, 100, 90, 30);
        fromWhere.setForeground(Color.ORANGE);
        fromWhere.setFont(new Font("Arial", Font.BOLD, 12));

        JComboBox<String> fromComboBox = new JComboBox<>();
        fromComboBox.setBounds(30, 130, 150, 25);
        fromComboBox.addItem("Ankara");
        fromComboBox.addItem("Bilecik");
        fromComboBox.addItem("Eskişehir");
        fromComboBox.addItem("Kocaeli");
        fromComboBox.addItem("Konya");
        fromComboBox.addItem("İstanbul");

        JLabel toWhere = new JLabel("Varış Noktası");
        toWhere.setBounds(200, 100, 90, 30);
        toWhere.setForeground(Color.ORANGE);
        toWhere.setFont(new Font("Arial", Font.BOLD, 12));

        JComboBox<String> toComboBox = new JComboBox<>();
        toComboBox.setBounds(200, 130, 150, 25);
        toComboBox.addItem("Ankara");
        toComboBox.addItem("Bilecik");
        toComboBox.addItem("Eskişehir");
        toComboBox.addItem("Kocaeli");
        toComboBox.addItem("Konya");
        toComboBox.addItem("İstanbul");

        JLabel dateLabel = new JLabel("Yolculuk Tarihi");
        dateLabel.setBounds(30, 170, 90, 30);
        dateLabel.setForeground(Color.ORANGE);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 12));

        JComboBox<String> dateComboBox = new JComboBox<>();
        dateComboBox.setBounds(30, 200, 150, 25);
        dateComboBox.addItem("04/12/2023");
        dateComboBox.addItem("05/12/2023");
        dateComboBox.addItem("06/12/2023");
        dateComboBox.addItem("07/12/2023");
        dateComboBox.addItem("08/12/2023");
        dateComboBox.addItem("09/12/2023");
        dateComboBox.addItem("10/12/2023");

        JLabel transportTypeLabel = new JLabel("Ulaşım Türü");
        transportTypeLabel.setBounds(200, 170, 90, 30);
        transportTypeLabel.setForeground(Color.ORANGE);
        transportTypeLabel.setFont(new Font("Arial", Font.BOLD, 12));

        JComboBox<String> transportTypeComboBox = new JComboBox<>();
        transportTypeComboBox.setBounds(200, 200, 150, 25);
        transportTypeComboBox.addItem("Uçak");
        transportTypeComboBox.addItem("Otobüs");
        transportTypeComboBox.addItem("Tren");

        JLabel passengerLabel = new JLabel("Yolcu Sayısı");
        passengerLabel.setBounds(155, 230, 90, 30);
        passengerLabel.setForeground(Color.ORANGE);
        passengerLabel.setFont(new Font("Arial", Font.BOLD, 12));

        JSpinner passengerSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
        passengerSpinner.setBounds(165, 260, 50, 25);

        JButton findTripButton = new JButton("SEFER BUL");
        findTripButton.setBounds(35, 300, 300, 30);
        findTripButton.setForeground(Color.ORANGE);
        findTripButton.setBackground(Color.DARK_GRAY);
        findTripButton.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel nameLabel = new JLabel("Ad");
        nameLabel.setBounds(30, 340, 90, 30);
        nameLabel.setForeground(Color.ORANGE);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 12));

        JTextField nameField = new JTextField();
        nameField.setBounds(30, 370, 150, 25);

        JLabel surnameLabel = new JLabel("Soyad");
        surnameLabel.setBounds(200, 340, 90, 30);
        surnameLabel.setForeground(Color.ORANGE);
        surnameLabel.setFont(new Font("Arial", Font.BOLD, 12));

        JTextField surnameField = new JTextField();
        surnameField.setBounds(200, 370, 150, 25);

        JLabel tcLabel = new JLabel("T.C. Numarası");
        tcLabel.setBounds(30, 410, 120, 30);
        tcLabel.setForeground(Color.ORANGE);
        tcLabel.setFont(new Font("Arial", Font.BOLD, 12));

        JTextField tcField = new JTextField();
        tcField.setBounds(30, 440, 150, 25);

        JLabel birthDateLabel = new JLabel("Doğum Tarihi");
        birthDateLabel.setBounds(200, 410, 120, 30);
        birthDateLabel.setForeground(Color.ORANGE);
        birthDateLabel.setFont(new Font("Arial", Font.BOLD, 12));

        JTextField birthDateField = new JTextField();
        birthDateField.setBounds(200, 440, 150, 25);

        JButton payButton = new JButton("ÖDEME YAP");
        payButton.setBounds(35, 480, 300, 30);
        payButton.setForeground(Color.ORANGE);
        payButton.setBackground(Color.DARK_GRAY);
        payButton.setFont(new Font("Arial", Font.BOLD, 14));

        panel.add(greetings);
        panel.add(fromWhere);
        panel.add(toWhere);
        panel.add(fromComboBox);
        panel.add(toComboBox);
        panel.add(dateLabel);
        panel.add(dateComboBox);
        panel.add(transportTypeLabel);
        panel.add(transportTypeComboBox);
        panel.add(passengerLabel);
        panel.add(passengerSpinner);
        panel.add(findTripButton);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(surnameLabel);
        panel.add(surnameField);
        panel.add(tcLabel);
        panel.add(tcField);
        panel.add(birthDateLabel);
        panel.add(birthDateField);
        panel.add(payButton);

        return panel;
    }

    static void printtext(String text, JPanel panel, int x, int y, int w, int h,int f) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, w, h);
        label.setForeground(Color.ORANGE);
        label.setFont(new Font("Arial", Font.BOLD, f));
        panel.add(label);
    }
}