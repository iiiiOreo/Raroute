package page2;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import page3.Test2;

public class Test1 extends JFrame {

    public static JPanel canvas;
    public static String selectedRideLocation;
    public static String selectedDestination;
    public static Date selectedDate;

    public String Firstname;
    public String Lastname;
    public String phonenumber;
    public String username;

    public Test1(String fname, String lname, String phone, String user) {
        this.Firstname = fname;
        this.Lastname = lname;
        this.phonenumber = phone;
        this.username = user;
        initComponents();
    }

    private void initComponents() {
        this.setSize(900, 551);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(5, 64, 91));
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImg = new ImageIcon(Test1.class.getResource("back2.png"));
                g.drawImage(backgroundImg.getImage(), 0, 0, this);
            }
        };
        canvas.setSize(900, 551);
        canvas.setLayout(null);
        canvas.setBackground(new Color(5, 64, 91));
        this.add(canvas);

        JLabel errorMessage = new JLabel("");
        errorMessage.setForeground(Color.decode("#FFAB15"));
        errorMessage.setBounds(613, 351, 400, 40);
        canvas.add(errorMessage);

        Date today = new Date();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(today, null, null, Calendar.DAY_OF_MONTH);
        JSpinner entry0 = new JSpinner(spinnerDateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(entry0, "dd/MM/yyyy");
        entry0.setEditor(dateEditor);
        entry0.setBackground(Color.WHITE);
        entry0.setBorder(null);
        entry0.setBounds(638, 321, 194, 23);
        entry0.setFont(entry0.getFont().deriveFont(Font.BOLD));
        canvas.add(entry0);

        String[] options1 = {"Cairo", "Alexandria", "Sharm Elsheikh", "El Tor", "Dahb", "Mansoura", "Ahmad Hamdy"};
        JComboBox<String> entry1 = new JComboBox<>(options1);
        entry1.insertItemAt("Please choose ride location", 0);
        entry1.setSelectedIndex(0);
        entry1.setEditable(true);
        entry1.setBackground(Color.WHITE);
        entry1.setBorder(null);
        entry1.setBounds(638, 201, 194, 23);
        entry1.setFont(entry1.getFont().deriveFont(Font.BOLD));
        AutoCompleteDecorator.decorate(entry1);
        canvas.add(entry1);

        String[] options2 = {"Cairo", "Alexandria", "Sharm Elsheikh", "El Tor", "Dahb", "Mansoura", "Ahmad Hamdy"};
        JComboBox<String> entry2 = new JComboBox<>(options2);
        entry2.insertItemAt("Please choose destination", 0);
        entry2.setSelectedIndex(0);
        entry2.setEditable(true);
        entry2.setBackground(Color.WHITE);
        entry2.setBorder(null);
        entry2.setBounds(638, 261, 194, 23);
        entry2.setFont(entry2.getFont().deriveFont(Font.BOLD));
        AutoCompleteDecorator.decorate(entry2);
        canvas.add(entry2);

        ImageIcon entry0Img = new ImageIcon(Test1.class.getResource("img_textBox0.png"));
        JLabel entry0Bg = new JLabel(entry0Img);
        entry0Bg.setBounds(630, 320, entry0Img.getIconWidth(), entry0Img.getIconHeight());
        canvas.add(entry0Bg);

        ImageIcon entry1Img = new ImageIcon(Test1.class.getResource("img_textBox1.png"));
        JLabel entry1Bg = new JLabel(entry1Img);
        entry1Bg.setBounds(630, 200, entry1Img.getIconWidth(), entry1Img.getIconHeight());
        canvas.add(entry1Bg);

        ImageIcon entry2Img = new ImageIcon(Test1.class.getResource("img_textBox2.png"));
        JLabel entry2Bg = new JLabel(entry2Img);
        entry2Bg.setBounds(630, 260, entry2Img.getIconWidth(), entry2Img.getIconHeight());
        canvas.add(entry2Bg);

        ImageIcon img0 = new ImageIcon(Test1.class.getResource("sear0.png"));
        ImageIcon hoverImg = new ImageIcon(Test1.class.getResource("sear2.png"));
        ImageIcon clickimg = new ImageIcon(Test1.class.getResource("sear3.png"));
        JButton b0 = new JButton(img0);
        b0.setBorder(null);
        b0.setContentAreaFilled(false);
        b0.addActionListener((ActionEvent e) -> {
            selectedDate = (Date) entry0.getValue();
            selectedRideLocation = (String) entry1.getSelectedItem();
            selectedDestination = (String) entry2.getSelectedItem();

            if (selectedRideLocation.equals("Please choose ride location") || selectedDestination.equals("Please choose destination") || selectedDate == null) {
                String title1 = "Error: Please choose a valid info.";
                errorMessage.setText(title1);
                errorMessage.setVisible(true);
            } else if (selectedRideLocation==selectedDestination) {
                String title1 = "Error: location & Distenation is same.";
                errorMessage.setText(title1);
                errorMessage.setVisible(true);
            } else if (selectedDate.compareTo(today) < 0) {
                String title1 = "Error: Please choose a valid date.";
                errorMessage.setText(title1);
                errorMessage.setVisible(true);
            } else {
                Test2 t = new Test2(selectedDate, selectedRideLocation, selectedDestination, Firstname, Lastname, phonenumber, username);
                t.setframeVisible();
                setVisible(false);
            }
            
        });
        b0.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b0.setIcon(hoverImg);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b0.setIcon(img0);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                b0.setIcon(clickimg);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                b0.setIcon(img0);
            }
        });
        b0.setBounds(640, 398, 126, 34);
        canvas.add(b0);

        this.setVisible(true);
    }

    public void setCanvasVisible()
    {
        canvas.setVisible(true);
    }
}


