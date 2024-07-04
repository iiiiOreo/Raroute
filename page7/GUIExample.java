package page7;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GUIExample {

    public static Date selectedDate;
    public static String selectedRideLocation;
    public static String selectedDestination ;

    public static String Firstname ;
    public static String Lastname;
    public static String busID;
    public static String time;
    public static int price;

    public static JFrame window;
    public static String numberseat;
    public static String phonenumber;
    public static String category;
    public static JComboBox<String> entry0;

    public static void setVisible(Date selectedDate, String selectedRideLocation, String selectedDestination, String time,
            String Firstname, String Lastname, String phone, String busID, int price, String seat, String ca) {
        GUIExample.selectedDate = selectedDate;
        GUIExample.selectedRideLocation = selectedRideLocation;
        GUIExample.selectedDestination = selectedDestination;
        GUIExample.Firstname = Firstname;
        GUIExample.Lastname = Lastname;
        GUIExample.time = time;
        GUIExample.busID = busID;
        GUIExample.price = price;
        GUIExample.numberseat = seat;
        GUIExample.category = ca;
        GUIExample.phonenumber = phone;

        if (window == null) {
            createAndShowGUI();
        }
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
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
                ImageIcon backgroundImg = new ImageIcon(GUIExample.class.getResource("background.png"));
                g.drawImage(backgroundImg.getImage(), -10, -25, this);
            }
        };
        canvas.setLayout(null);
        canvas.setBackground(new Color(5, 64, 91));
        canvas.setBounds(0, 0, 900, 551);
        window.add(canvas);

        // Labels 
        JLabel label_name = new JLabel(Firstname + " " + Lastname);
        label_name.setBounds(30, 165, 200, 40);
        label_name.setFont(new Font("Cambria", Font.BOLD, 21));
        label_name.setForeground(Color.WHITE);
        canvas.add(label_name);

        JLabel label_from = new JLabel(selectedRideLocation);
        label_from.setBounds(30, 265, 200, 40);
        label_from.setFont(new Font("Cambria", Font.BOLD, 21));
        label_from.setForeground(Color.WHITE);
        canvas.add(label_from);

        JLabel label_to = new JLabel(selectedDestination);
        label_to.setBounds(30, 360, 200, 40);
        label_to.setFont(new Font("Cambria", Font.BOLD, 21));
        label_to.setForeground(Color.WHITE);
        canvas.add(label_to);

        JLabel label_tripcode = new JLabel(busID);
        label_tripcode.setBounds(580, 170, 200, 40);
        label_tripcode.setFont(new Font("Cambria", Font.BOLD, 21));
        label_tripcode.setForeground(Color.decode("#05405B"));
        canvas.add(label_tripcode);

        JLabel label_seat = new JLabel(numberseat);
        label_seat.setBounds(547, 255, 200, 40);
        label_seat.setFont(new Font("Cambria", Font.BOLD, 21));
        label_tripcode.setForeground(Color.decode("#05405B"));
        canvas.add(label_seat);

        JLabel label_phone = new JLabel(phonenumber);
        label_phone.setBounds(260, 165, 200, 40);
        label_phone.setFont(new Font("Cambria", Font.BOLD, 21));
        label_phone.setForeground(Color.WHITE);
        canvas.add(label_phone);

        JLabel label_Date = new JLabel(String.valueOf(selectedDate));
        label_Date.setBounds(260, 265, 135, 40);
        label_Date.setFont(new Font("Cambria", Font.BOLD, 21));
        label_Date.setForeground(Color.WHITE);
        canvas.add(label_Date);

        JLabel label_time = new JLabel(time);
        label_time.setBounds(260, 360, 200, 40);
        label_time.setFont(new Font("Cambria", Font.BOLD, 21));
        label_time.setForeground(Color.WHITE);
        canvas.add(label_time);

        JLabel label_price = new JLabel(String.valueOf(price) + "LE");
        label_price.setBounds(590, 360, 200, 40);
        label_price.setFont(new Font("Cambria", Font.BOLD, 21));
        label_price.setForeground(Color.WHITE);
        canvas.add(label_price);

        JLabel label_bustype = new JLabel(category);
        label_bustype.setBounds(668, 255, 200, 40);
        label_bustype.setFont(new Font("Cambria", Font.BOLD, 21));
        label_bustype.setForeground(Color.decode("#05405B"));
        canvas.add(label_bustype);

        ImageIcon img0 = new ImageIcon(GUIExample.class.getResource("img0.png"));
        ImageIcon hoverImg = new ImageIcon(GUIExample.class.getResource("Hoverimg.png"));
        ImageIcon clickimg = new ImageIcon(GUIExample.class.getResource("img2.png"));
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
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                b0.setIcon(img0);
            }
        });
        b0.setBounds(370, 462, 149, 34);
        canvas.add(b0);

        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateTicket();
               window.dispose();
            }
        });

        window.setVisible(true);
    }

    private static void generateTicket() {
        BufferedImage ticketImage = new BufferedImage(900, 551, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = ticketImage.createGraphics();

        window.getContentPane().paint(g2d);
        g2d.dispose();

        int x = 0;
        int y = 25;
        int width = 885;
        int height = 418;
        BufferedImage croppedImage = ticketImage.getSubimage(x, y, width, height);

        try {
            // Create "ticket" directory if not exists
            File ticketDir = new File("ticket");
            if (!ticketDir.exists()) {
                ticketDir.mkdir();
            }
            
            // Save cropped image as PNG
            File outputFile = new File(ticketDir, "ticket.png");
            ImageIO.write(croppedImage, "png", outputFile);
            System.out.println("Ticket generated and cropped successfully.");
            
            // Call the method to convert PNG to PDF
            PNGToPDFConverter.takePath(outputFile.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
