package page52;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.*;
import page6.Main_6;
import page41.Main;
import page42.Main2;

public class Main_52 {

    public static Date selectedDate;
    public static String selectedRideLocation;
    public static String selectedDestination;

    public static String Firstname;
    public static String Lastname;
    public static String busID;
    public static String time;
    public static int price;
    public static String phonenumber;

    public static JFrame window;
    public static String numberseat;
    public static String category;

    public static void setVisible(Date selectedDate, String selectedRideLocation, String selectedDestination, String time,
        String Firstname, String Lastname, String busID, int price, String phonenumber, String seat, String ca) {
    Main_52.selectedDate = selectedDate;
    Main_52.selectedRideLocation = selectedRideLocation;
    Main_52.selectedDestination = selectedDestination;
    Main_52.Firstname = Firstname;
    Main_52.Lastname = Lastname;
    Main_52.busID = busID;
    Main_52.time = time;
    Main_52.price = price;
    Main_52.phonenumber = phonenumber;
    Main_52.numberseat = seat;
    Main_52.category = ca;

    if (window == null) {
        createAndShowGUI();
    }
    window.setVisible(true);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main_52::createAndShowGUI);
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
                ImageIcon backgroundImg = new ImageIcon(Main_52.class.getResource("background.png"));
                g.drawImage(backgroundImg.getImage(), -15, -20, this);
            }
        };
        canvas.setLayout(null);
        canvas.setBackground(new Color(5, 64, 91));
        canvas.setBounds(0, 0, 900, 551);
        window.add(canvas);

        // Labels 
        JLabel label_name = new JLabel(Firstname+" "+Lastname);
        label_name.setBounds(170,51,200,40 );
        label_name.setFont(new Font("Cambria", Font.BOLD, 21));
        label_name.setForeground(Color.WHITE); 
        canvas.add(label_name);

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

        JLabel label_phone = new JLabel(phonenumber);
        label_phone.setBounds(580,51,200,40 );
        label_phone.setFont(new Font("Cambria", Font.BOLD, 21));
        label_phone.setForeground(Color.WHITE); 
        canvas.add(label_phone);

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
        
        ImageIcon img0 = new ImageIcon(Main_52.class.getResource("img0.png"));
        ImageIcon hoverImg = new ImageIcon(Main_52.class.getResource("Hoverimg1.png"));
        ImageIcon clickimg = new ImageIcon(Main_52.class.getResource("new_image1.png"));
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
                Main_6.setVisible(selectedDate, selectedRideLocation, selectedDestination, time, Firstname, Lastname,phonenumber
                ,busID ,price,numberseat,category);
                window.dispose();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                b0.setIcon(img0); 
            }
        });
        b0.setBounds(310, 383, 264, 48);
        canvas.add(b0);
        ImageIcon img1 = new ImageIcon(Main_52.class.getResource("img1.png"));
        ImageIcon hoverImg1 = new ImageIcon(Main_52.class.getResource("Hoverimg2.png"));
        ImageIcon clickimg1 = new ImageIcon(Main_52.class.getResource("new_image2.png"));
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
                    ,busID ,price,phonenumber,"user1");
                    window.dispose();
                }else if(category=="Mini"){
                    Main.setVisiblemini(selectedDate, selectedRideLocation, selectedDestination, time, Firstname, Lastname
                   ,busID ,price,phonenumber,"user1");
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
