package page51;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.*;
import page7.GUIExample;
import page41.Main;
import page42.Main2;

public class Main_51 {

    public static Date selectedDate;
    public static String selectedRideLocation;
    public static String selectedDestination;

    public static String Firstname;
    public static String Lastname;
    public static String busID;
    public static String time;
    public static int price;
    public static String phonenumer;

    public static JFrame window;
    public static String numberseat;
    public static String category;

    public static void setVisible(Date selectedDate, String selectedRideLocation, String selectedDestination,String time,
     String Firstname, String Lastname,String busID , int price  ,String phone ,String seat , String ca) {
        Main_51.selectedDate = selectedDate;
        Main_51.selectedRideLocation = selectedRideLocation;
        Main_51.selectedDestination = selectedDestination;
        Main_51.Firstname = Firstname;
        Main_51.Lastname = Lastname;
        Main_51.busID = busID;
        Main_51.time=time;
        Main_51.price=price;
        Main_51.phonenumer=phone;
        Main_51.numberseat=seat;
        Main_51.category=ca;

        if (window == null) {
            createAndShowGUI();
        }
        window.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main_51::createAndShowGUI);
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
                ImageIcon backgroundImg = new ImageIcon(Main_51.class.getResource("background.png"));
                g.drawImage(backgroundImg.getImage(), -15, -20, this);
            }
        };
        canvas.setLayout(null);
        canvas.setBackground(new Color(5, 64, 91));
        canvas.setBounds(0, 0, 900, 551);
        window.add(canvas);
        
        // Labels 
        JLabel label_from = new JLabel(selectedRideLocation);
        label_from.setBounds(170,115,200,40 );
        label_from.setFont(new Font("Cambria", Font.BOLD, 21));
        label_from.setForeground(Color.WHITE); 
        canvas.add(label_from);

        JLabel label_to = new JLabel(selectedDestination);
        label_to.setBounds(140,177,200,40  );
        label_to.setFont(new Font("Cambria", Font.BOLD, 21));
        label_to.setForeground(Color.WHITE); 
        canvas.add(label_to);

        JLabel label_tripcode = new JLabel(busID);
        label_tripcode.setBounds(207,240,200,40 );
        label_tripcode.setFont(new Font("Cambria", Font.BOLD, 21));
        label_tripcode.setForeground(Color.WHITE); 
        canvas.add(label_tripcode);

        JLabel label_seat = new JLabel(numberseat);
        label_seat.setBounds(190,300,200,40);
        label_seat.setFont(new Font("Cambria", Font.BOLD, 21));
        label_seat.setForeground(Color.WHITE);
        canvas.add(label_seat);

        JLabel label_time = new JLabel(time);
        label_time.setBounds(540,115,200,40);
        label_time.setFont(new Font("Cambria", Font.BOLD, 21));
        label_time.setForeground(Color.WHITE); 
        canvas.add(label_time);

        JLabel label_price = new JLabel(String.valueOf(price)+"LE");
        label_price.setBounds(540,177,220,40 );
        label_price.setFont(new Font("Cambria", Font.BOLD, 21));
        label_price.setForeground(Color.WHITE); 
        canvas.add(label_price);

        JLabel label_bustype = new JLabel(category);
        label_bustype.setBounds(575,240,200,40  );
        label_bustype.setFont(new Font("Cambria", Font.BOLD, 21));
        label_bustype.setForeground(Color.WHITE); 
        canvas.add(label_bustype);

        ImageIcon entry0Img = new ImageIcon(Main_51.class.getResource("img_textBox0.png"));
        JLabel entry0Bg = new JLabel(entry0Img);
        entry0Bg.setBounds(163, 59, entry0Img.getIconWidth(), entry0Img.getIconHeight());
        canvas.add(entry0Bg);

        JTextField entry0 = new JTextField();
        entry0.setBackground(Color.WHITE);
        entry0.setBorder(null);
        entry0.setBounds(171, 60, 194, 23);
        entry0.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        canvas.add(entry0);


        ImageIcon entry1Img = new ImageIcon(Main_51.class.getResource("img_textBox1.png"));
        JLabel entry1Bg = new JLabel(entry1Img);
        entry1Bg.setBounds(567, 59, entry1Img.getIconWidth(), entry1Img.getIconHeight());
        canvas.add(entry1Bg);

        JTextField entry1 = new JTextField();
        entry1.setBackground(Color.WHITE);
        entry1.setBorder(null);
        entry1.setBounds(575, 60, 194, 23);
        entry1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        canvas.add(entry1);

        ImageIcon img0 = new ImageIcon(Main_51.class.getResource("img0.png"));
        ImageIcon hoverImg = new ImageIcon(Main_51.class.getResource("Hoverimg1.png"));
        ImageIcon clickimg = new ImageIcon(Main_51.class.getResource("new_image1.png"));
        JButton b0 = new JButton(img0);
        b0.setBorder(null);
        b0.setContentAreaFilled(false);
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
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                b0.setIcon(clickimg);
                String fullName = entry0.getText();
                String[] names = fullName.split("\\s+");
                if (names.length >= 2) {
                    Firstname = names[0];
                    Lastname = names[1];
                }
                String phone = entry1.getText();
                phonenumer=phone;
                System.out.println("Name: " + Firstname+" "+Lastname + ", Phone: " + phone);
                GUIExample.setVisible(selectedDate, selectedRideLocation, selectedDestination, time, Firstname, Lastname,phonenumer
                ,busID, price ,numberseat ,category);
                window.dispose();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                b0.setIcon(img0); 
            }
        });
        b0.setBounds(310, 383, 264, 48);
        canvas.add(b0);
        ImageIcon img1 = new ImageIcon(Main_51.class.getResource("img1.png"));
        ImageIcon hoverImg1 = new ImageIcon(Main_51.class.getResource("Hoverimg2.png"));
        ImageIcon clickimg1 = new ImageIcon(Main_51.class.getResource("new_image2.png"));
        JButton b1 = new JButton(img1);
        b1.setBorder(null);
        b1.setContentAreaFilled(false);
        b1.addMouseListener(new MouseListener() { 
            @Override
            public void mouseEntered(MouseEvent e) {
                b1.setIcon(hoverImg1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b1.setIcon(img1); 
            }

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                b1.setIcon(clickimg1);
                if(category=="Big"){ 
                    Main2.setVisiblebig(selectedDate, selectedRideLocation, selectedDestination, time, Firstname, Lastname
                    ,busID ,price,"","booker1");
                    window.dispose();
                }else if(category=="Mini"){
                    Main.setVisiblemini(selectedDate, selectedRideLocation, selectedDestination, time, Firstname, Lastname
                    ,busID ,price,"","booker1");
                    window.dispose();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                b1.setIcon(img1); 
            }
        });
        b1.setBounds(471, 307, 199, 48);
        canvas.add(b1);
        window.setVisible(true);
    }
}
