package page6 ;
import java.awt.*;
import java.util.Date;
import java.util.Random;
import javax.swing.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import page7.GUIExample;


public class Main_6 {
    public static Date selectedDate;
    public static String selectedRideLocation;
    public static String selectedDestination;

    public static String Firstname;
    public static String Lastname;
    public static String busID;
    public static String time;
    public static int price;

    public static JFrame window;
    public static String numberseat;
    public static String phonenumber;
    public static String category;
    public static JComboBox<String> entry0;

    public static class CopyableLabel extends JLabel {
        public CopyableLabel(String text) {
            super(text);
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    StringSelection stringSelection = new StringSelection(getText());
                    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clpbrd.setContents(stringSelection, null);
                }
            });
        }
    }

    public static void setVisible(Date selectedDate, String selectedRideLocation, String selectedDestination,String time,
     String Firstname, String Lastname,String phone,String busID , int price,String seat , String ca) {
        Main_6.selectedDate = selectedDate;
        Main_6.selectedRideLocation = selectedRideLocation;
        Main_6.selectedDestination = selectedDestination;
        Main_6.Firstname = Firstname;
        Main_6.Lastname = Lastname;
        Main_6.busID = busID;
        Main_6.price=price;
        Main_6.category=ca;
        Main_6.time=time;
        Main_6.numberseat=seat;
        Main_6.phonenumber=phone;

        if (window == null) {
            createAndShowGUI();
        }
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main_6::createAndShowGUI);
    }

    public static StringBuilder FawaryNumberGenerator(){
        Random random = new Random();        
        int firstDigit = random.nextInt(9) + 1;
        StringBuilder randomNumber = new StringBuilder();
        randomNumber.append(firstDigit);
        for (int i = 0; i < 9; i++) {
            randomNumber.append(random.nextInt(10)); // Generates a random digit (0-9)
        }
        return randomNumber;
    }

    private static void createAndShowGUI() {
        window = new JFrame();
        window.setSize(900, 551);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImg = new ImageIcon(Main_6.class.getResource("background.png"));
                g.drawImage(backgroundImg.getImage(), -15, -21, this);
            }
        };
        canvas.setLayout(null);
        canvas.setBackground(new Color(5, 64, 91));
        canvas.setBounds(0, 0, 900, 551);
        window.add(canvas);
   
        CopyableLabel label_fawary = new CopyableLabel("#"+FawaryNumberGenerator());
        label_fawary.setBounds(370,137, 150, 40 );
        label_fawary.setFont(new Font("Cairo", Font.BOLD, 25));
        label_fawary.setForeground(Color.WHITE);
        canvas.add(label_fawary);

        ImageIcon img0 = new ImageIcon(Main_6.class.getResource("img0.png"));
        ImageIcon hoverImg = new ImageIcon(Main_6.class.getResource("Hoverimg.png")); 
        ImageIcon clickimg = new ImageIcon(Main_6.class.getResource("img5.png")); 
        JButton b0 = new JButton(img0);
        b0.setBorder(null);
        b0.setContentAreaFilled(false);
        b0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b0.setIcon(hoverImg);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                b0.setIcon(img0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                b0.setIcon(clickimg);
                GUIExample.setVisible(selectedDate, selectedRideLocation, selectedDestination, time, Firstname, Lastname,phonenumber,
                busID ,price,numberseat,category);
                window.dispose();
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {
                b0.setIcon(img0);
            }
    });
        b0.setBounds(342, 400, 214, 40);
        canvas.add(b0);        
        

        
        window.setVisible(true);
        
    }
}
