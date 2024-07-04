package page3;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import page41.Main;
import page42.Main2;

public class Test2{ 

    public static JFrame frame;
    public static Date selectedDate;
    public static String selectedRideLocation;
    public static String selectedDestination;

    public String Firstname;
    public String Lastname;
    public String phonenumber;
    public String username;


     public Test2(Date selectedDate, String selectedRideLocation, String selectedDestination ,String fname , String lname ,String phone ,
     String user) {
        this.Firstname=fname;
        this.Lastname=lname;
        this.phonenumber=phone;
        this.username=user;
        Test2.selectedDate = selectedDate;
        Test2.selectedRideLocation = selectedRideLocation;
        Test2.selectedDestination = selectedDestination;
        initializeFrame();
    }
    
    private void initializeFrame() {

        // Backenend
        Bus b1= new Bus("Mini Bus",12,260,"10:30AM");
        Bus b2= new Bus("Bus",49,220,"11:00AM");
        Bus b3= new Bus("Mini Bus",12,260,"06:00PM");
        Bus b4= new Bus("Bus",49,220,"10:00PM");
        
        String from = selectedRideLocation != null ? selectedRideLocation : "";
        String to = selectedDestination != null ? selectedDestination : "";
        Date date = selectedDate != null ? selectedDate : new Date();

        // Frontend
        frame = new JFrame("Available Busses");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(912, 585);
    
        // Create a custom JPanel with the background image
        ImagePanel backgroundPanel = new ImagePanel(Test2.class.getResource("background3.png")); // Use the same background image as Test1
        backgroundPanel.setLayout(null); // Ensure the background panel has null layout
        frame.setContentPane(backgroundPanel);

        Color transparentGrey = new Color(217, 217, 217, 127);
        Color separatorColor = Color.decode("#05273E");
        
        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setBackground(transparentGrey);
        panel1.setBounds(50, 33, 800, 100);
        backgroundPanel.add(panel1);

        // Create a custom separator for panel1
        CustomSeparator separator1 = new CustomSeparator(SwingConstants.VERTICAL, separatorColor);
        separator1.setBounds(656, 0, 4, 100); // Adjust position and size of the separator
        panel1.add(separator1); // Add separator to panel1
        
        // Create a JButton
        ImageIcon img0 = new ImageIcon(Test2.class.getResource("img000.png"));
        ImageIcon hoverImg = new ImageIcon(Test2.class.getResource("img111.png"));
        ImageIcon clickimg = new ImageIcon(Test2.class.getResource("img222.png"));
        JButton button1 = new JButton(img0);
        button1.setBorder(null);
        button1.setBounds(656,59, 148, 48);
        button1.setContentAreaFilled(false);
        button1.addMouseListener(new MouseListener() { 
            @Override
            public void mouseEntered(MouseEvent e) {
                button1.setIcon(hoverImg);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button1.setIcon(img0); 
            }
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                button1.setIcon(clickimg);
                Main.setVisiblemini(selectedDate, selectedRideLocation, selectedDestination, b1.time, Firstname, Lastname,b1.id ,b1.get_price() ,
                phonenumber , username);
                frame.dispose();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button1.setIcon(img0); 
            }
        });
        panel1.add(button1);

        JLabel label1 = new JLabel("From :");
        label1.setBounds(19,13,70,39 );
        label1.setFont(new Font("Cambria", Font.BOLD, 21));
        label1.setForeground(Color.decode("#05273E")); // Set foreground color to #05273E
        panel1.setLayout(null); // Set BorderLayout for panel1 (to center label)
        panel1.add(label1);
        
        JLabel label_from1 = new JLabel(from);
        label_from1.setBounds(90,13,200,39 );
        label_from1.setFont(new Font("Cairo", Font.BOLD, 21));
        label_from1.setForeground(Color.WHITE);
        panel1.add(label_from1);
        
        JLabel label2 = new JLabel("To :");
        label2.setBounds(32,48,100,39 );
        label2.setFont(new Font("cambria", Font.BOLD, 21));
        label2.setForeground(Color.decode("#05273E")); // Set foreground color to #05273E
        panel1.add(label2);
        
        JLabel label_to1 = new JLabel(to);
        label_to1.setBounds(90,48,200,39 );
        label_to1.setFont(new Font("Cairo", Font.BOLD, 21));
        panel1.add(label_to1);
        label_to1.setForeground(Color.WHITE);

        JLabel label_bus1 = new JLabel("#"+b1.id);
        label_bus1.setBounds(542,11,100,39 );
        label_bus1.setFont(new Font("Cairo", Font.BOLD, 21));
        label_bus1.setForeground(Color.WHITE);
        panel1.add(label_bus1);
        
        JLabel label_type1 = new JLabel(b1.get_category());
        label_type1.setBounds(542,48,100,39 );
        label_type1.setFont(new Font("Cairo", Font.BOLD, 21));
        label_type1.setForeground(Color.WHITE);
        panel1.add(label_type1);
        
        JLabel label_price1 = new JLabel(String.valueOf(b1.get_price())+"LE");
        label_price1.setBounds(700,10, 100, 39 );
        label_price1.setFont(new Font("Cairo", Font.BOLD, 21));
        label_price1.setForeground(Color.WHITE);
        panel1.add(label_price1);
        
        JLabel label_date1 = new JLabel(date.toString());
        label_date1.setBounds(300,11,140,39);
        label_date1.setFont(new Font("Cairo", Font.BOLD, 21));
        label_date1.setForeground(Color.WHITE);
        panel1.add(label_date1);
        
        JLabel label_time1 = new JLabel(b1.time);
        label_time1.setBounds(320,48,150,39 );
        label_time1.setFont(new Font("Cairo", Font.BOLD, 21));
        label_time1.setForeground(Color.WHITE);
        panel1.add(label_time1);
        
        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setBackground(transparentGrey);
        panel2.setBounds(50, 37 + 100 + 26, 800, 100);
        backgroundPanel.add(panel2);

        // Create a JButton
        JButton button2 = new JButton(img0);
        button2.setBorder(null);
        button2.setBounds(656,59, 148, 48);
        button2.setContentAreaFilled(false);
        button2.addMouseListener(new MouseListener() { 
            @Override
            public void mouseEntered(MouseEvent e) {
                button2.setIcon(hoverImg);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button2.setIcon(img0); 
            }
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                button2.setIcon(clickimg);
                frame.dispose(); 
                Main2.setVisiblebig(selectedDate, selectedRideLocation, selectedDestination,b2.time, Firstname, Lastname,b2.id ,b2.get_price() 
                ,phonenumber  , username);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button2.setIcon(img0); 
            }
        });
        panel2.add(button2);
        
        // Create a custom separator for panel2
        CustomSeparator separator2 = new CustomSeparator(SwingConstants.VERTICAL, separatorColor);
        separator2.setBounds(656, 0, 4, 100); 
        panel2.add(separator2); // Add separator to panel2

        JLabel label3 = new JLabel("From :");
        label3.setBounds(19,13,100,39 );
        label3.setFont(new Font("cambria", Font.BOLD, 21));
        label3.setForeground(Color.decode("#05273E")); // Set foreground color to #05273E
        panel2.setLayout(null); // Set BorderLayout for panel1 (to center label)
        panel2.add(label3);
        
        JLabel label_from2 = new JLabel(from);
        label_from2.setBounds(90,13,200,39 );
        label_from2.setFont(new Font("Cairo", Font.BOLD, 21));
        label_from2.setForeground(Color.WHITE);
        panel2.add(label_from2);
        
        JLabel label4 = new JLabel("To :");
        label4.setBounds(32,48,100,39 );
        label4.setFont(new Font("cambria", Font.BOLD, 21));
        label4.setForeground(Color.decode("#05273E")); // Set foreground color to #05273E
        panel2.add(label4);
        
        JLabel label_to2 = new JLabel(to);
        label_to2.setBounds(90,48,200,39 );
        label_to2.setFont(new Font("Cairo", Font.BOLD, 21));
        label_to2.setForeground(Color.WHITE);
        panel2.add(label_to2);
        
        JLabel label_bus2 = new JLabel("#"+b2.id);
        label_bus2.setBounds(542,11,100,39 );
        label_bus2.setFont(new Font("Cairo", Font.BOLD, 21));
        label_bus2.setForeground(Color.WHITE);
        panel2.add(label_bus2);
        
        JLabel label_type2 = new JLabel(b2.get_category());
        label_type2.setBounds(567,48,100,39 );
        label_type2.setFont(new Font("Cairo", Font.BOLD, 21));
        label_type2.setForeground(Color.WHITE);
        panel2.add(label_type2);
        
        JLabel label_price2 = new JLabel(String.valueOf(b2.get_price())+"LE");
        label_price2.setBounds(700,10, 100, 39 );
        label_price2.setFont(new Font("Cairo", Font.BOLD, 21));
        label_price2.setForeground(Color.WHITE);
        panel2.add(label_price2);
        
        JLabel label_date2 = new JLabel(date.toString());
        label_date2.setBounds(300,11,140,39);
        label_date2.setFont(new Font("Cairo", Font.BOLD, 21));
        label_date2.setForeground(Color.WHITE);
        panel2.add(label_date2);
        
        JLabel label_time2 = new JLabel(b2.time);
        label_time2.setBounds(320,48,150,39 );
        label_time2.setFont(new Font("Cairo", Font.BOLD, 21));
        label_time2.setForeground(Color.WHITE);
        panel2.add(label_time2);
        
        // Panel 3
        JPanel panel3 = new JPanel();
        panel3.setBackground(transparentGrey);
        panel3.setBounds(50, 37 + 2 * (100 + 26), 800, 100);
        backgroundPanel.add(panel3);

        // Create a JButton
        JButton button3 = new JButton(img0);
        button3.setBorder(null);
        button3.setBounds(656,59, 148, 48);
        button3.setContentAreaFilled(false);
        button3.addMouseListener(new MouseListener() { 
            @Override
            public void mouseEntered(MouseEvent e) {
                button3.setIcon(hoverImg);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button3.setIcon(img0); 
            }
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                button3.setIcon(clickimg);
                Main.setVisiblemini(selectedDate, selectedRideLocation, selectedDestination,b3.time, Firstname, Lastname,b3.id,b3.get_price() ,
                 phonenumber , username);
                frame.dispose();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button3.setIcon(img0); 
            }
        });
        panel3.add(button3);
        
        // Create a custom separator for panel3
        CustomSeparator separator3 = new CustomSeparator(SwingConstants.VERTICAL, separatorColor);
        separator3.setBounds(656, 0, 4, 100); 
        panel3.add(separator3); // Add separator to panel3

        JLabel label5 = new JLabel("From :");
        label5.setBounds(19,13,100,39 );
        label5.setFont(new Font("cambria", Font.BOLD, 21));
        label5.setForeground(Color.decode("#05273E")); // Set foreground color to #05273E
        panel3.setLayout(null); // Set BorderLayout for panel1 (to center label)
        panel3.add(label5);
        
        JLabel label_from3 = new JLabel(from);
        label_from3.setBounds(90,13,200,39 );
        label_from3.setFont(new Font("Cairo", Font.BOLD, 21));
        label_from3.setForeground(Color.WHITE);
        panel3.add(label_from3);
        
        JLabel label6 = new JLabel("To :");
        label6.setBounds(32,48,100,39 );
        label6.setFont(new Font("cambria", Font.BOLD, 21));
        label6.setForeground(Color.decode("#05273E")); // Set foreground color to #05273E
        panel3.add(label6);
        
        JLabel label_to3 = new JLabel(to);
        label_to3.setBounds(90,48,200,39 );
        label_to3.setFont(new Font("Cairo", Font.BOLD, 21));
        label_to3.setForeground(Color.WHITE);
        panel3.add(label_to3);
        
        JLabel label_bus3 = new JLabel("#"+b3.id);
        label_bus3.setBounds(542,11,100,39 );
        label_bus3.setFont(new Font("Cairo", Font.BOLD, 21));
        label_bus3.setForeground(Color.WHITE);
        panel3.add(label_bus3);
        
        JLabel label_type3 = new JLabel(b3.get_category());
        label_type3.setBounds(542,48,100,39 );
        label_type3.setFont(new Font("Cairo", Font.BOLD, 21));
        label_type3.setForeground(Color.WHITE);
        panel3.add(label_type3);
        
        JLabel label_price3 = new JLabel(String.valueOf(b3.get_price())+"LE");
        label_price3.setBounds(700,10, 100, 39 );
        label_price3.setFont(new Font("Cairo", Font.BOLD, 21));
        label_price3.setForeground(Color.WHITE);
        panel3.add(label_price3);
        
        JLabel label_date3 = new JLabel(date.toString());
        label_date3.setBounds(300,11,140,39);
        label_date3.setFont(new Font("Cairo", Font.BOLD, 21));
        label_date3.setForeground(Color.WHITE);
        panel3.add(label_date3);
        
        JLabel label_time3 = new JLabel(b3.time);
        label_time3.setBounds(320,48,150,39 );
        label_time3.setFont(new Font("Cairo", Font.BOLD, 21));
        label_time3.setForeground(Color.WHITE);
        panel3.add(label_time3);
        
        // Panel 4
        JPanel panel4 = new JPanel();
        panel4.setBackground(transparentGrey);
        panel4.setBounds(50, 37 + 3 * (100 + 26), 800, 100);
        backgroundPanel.add(panel4);

        // Create a JButton
        JButton button4 = new JButton(img0);
        button4.setBorder(null);
        button4.setBounds(656,59, 148, 48);
        button4.setContentAreaFilled(false);
        button4.addMouseListener(new MouseListener() { 
            @Override
            public void mouseEntered(MouseEvent e) {
                button4.setIcon(hoverImg);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button4.setIcon(img0); 
            }
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                button4.setIcon(clickimg);
                Main2.setVisiblebig(selectedDate, selectedRideLocation, selectedDestination,b4.time, Firstname, Lastname, b4.id,b4.get_price() ,
                phonenumber , username);
                frame.dispose();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button4.setIcon(img0); 
            }
        });
        panel4.add(button4);
        
        // Create a custom separator for panel4
        CustomSeparator separator4 = new CustomSeparator(SwingConstants.VERTICAL, separatorColor);
        separator4.setBounds(656, 0, 4, 100); 
        panel4.add(separator4); // Add separator to panel4

        JLabel label7 = new JLabel("From :");
        label7.setBounds(19,13,100,39 );
        label7.setFont(new Font("cambria", Font.BOLD, 21));
        label7.setForeground(Color.decode("#05273E")); // Set foreground color to #05273E
        panel4.setLayout(null); // Set BorderLayout for panel1 (to center label)
        panel4.add(label7);
        
        JLabel label_from4 = new JLabel(from);
        label_from4.setBounds(90,13,200,39 );
        label_from4.setFont(new Font("Cairo", Font.BOLD, 21));
        label_from4.setForeground(Color.WHITE);
        panel4.add(label_from4);
        
        JLabel label8 = new JLabel("To :");
        label8.setBounds(32,48,100,39 );
        label8.setFont(new Font("cambria", Font.BOLD, 21));
        label8.setForeground(Color.decode("#05273E")); // Set foreground color to #05273E
        panel4.add(label8);
        
        JLabel label_to4 = new JLabel(to);
        label_to4.setBounds(90,48,200,39 );
        label_to4.setFont(new Font("Cairo", Font.BOLD, 21));
        label_to4.setForeground(Color.WHITE);
        panel4.add(label_to4);
        
        JLabel label_bus4 = new JLabel("#"+b4.id);
        label_bus4.setBounds(542,11,100,39 );
        label_bus4.setFont(new Font("Cairo", Font.BOLD, 21));
        label_bus4.setForeground(Color.WHITE);
        panel4.add(label_bus4);
        
        JLabel label_type4 = new JLabel(b4.get_category());
        label_type4.setBounds(542,48,100,39 );
        label_type4.setFont(new Font("Cairo", Font.BOLD, 21));
        label_type4.setForeground(Color.WHITE);
        panel4.add(label_type4);
        
        JLabel label_price4 = new JLabel(String.valueOf(b4.get_price())+"LE");
        label_price4.setBounds(700,10, 100, 39 );
        label_price4.setFont(new Font("Cairo", Font.BOLD, 21));
        label_price4.setForeground(Color.WHITE);
        panel4.add(label_price4);
        
        JLabel label_date4 = new JLabel(date.toString());
        label_date4.setBounds(300,11,140,39);
        label_date4.setFont(new Font("Cairo", Font.BOLD, 21));
        label_date4.setForeground(Color.WHITE);
        panel4.add(label_date4);
        
        JLabel label_time4 = new JLabel(b4.time);
        label_time4.setBounds(320,48,150,39 );
        label_time4.setFont(new Font("Cairo", Font.BOLD, 21));
        label_time4.setForeground(Color.WHITE);
        panel4.add(label_time4);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                // Just for testing purpose, you can remove this and call your constructor
                new Test2(new Date(), "Location A", "Destination B", "John", "Doe", "123456789", "johndoe");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        });
    }

    public void setframeVisible() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setframeVisible'");
    }
}

class CustomSeparator extends JSeparator {
    private static final long serialVersionUID = 1L;
    private Color lineColor;

    public CustomSeparator(int orientation, Color lineColor) {
        super(orientation);
        this.lineColor = lineColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (g instanceof Graphics2D) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(lineColor);
            if (getOrientation() == JSeparator.HORIZONTAL) {
                g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
            } else {
                g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
            }
        }
    }
}

class ImagePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image image;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(URL imgUrl) {
        this(new ImageIcon(imgUrl).getImage());
    }

    public ImagePanel(Image image) {
        this.image = image;
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
class Bus {
    private Scanner input = new Scanner(System.in);
    @SuppressWarnings("unused")
    private int availableSeats;
    private int ticketPrice;
    protected String id;
    protected String time;
    private String category;

    // Constructor with parameters
    public Bus( String category, int availableSeats, int ticketPrice , String time)
    {
        this.id = generateRandomNumber(); // Generate unique ID
        this.category = category;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
        this.time=time;
    }

    // Default constructor
    public Bus() {
        System.out.print("Enter category: ");
        this.category = input.next();
        System.out.print("Enter availableSeats: ");
        this.availableSeats = input.nextInt();
        System.out.print("Enter ticket price: ");
        this.ticketPrice = input.nextInt();
        this.id = generateRandomNumber(); // Generate unique ID
        System.out.print("Enter time: ");
        this.time = input.next();
    }

    // Method to generate a random number with 6 characters
    public static String generateRandomNumber() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        // Append "RA" as the first two characters
        stringBuilder.append("RA");

        // Append random digits for the remaining 4 characters
        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10); // Generate a random digit (0-9)
            stringBuilder.append(digit);
        }

        return stringBuilder.toString();
    }
    
    public String get_category()
    {
        return category ;
    }
    
    public int get_price()
    {
        return ticketPrice;
    }
    
}

