package page1;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import page2.Test1;


public class Main {
    public static void main(String[] args) {

        ArrayList<person> data = new ArrayList<>();
        person booker = new person("youesf", "hamed", "booker1", "1234" , "01143675949");
        person user = new person("mohamed", "younis", "user1", "1234","01123551527");
        data.add(booker);
        data.add(user);

        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame();
            window.setSize(900, 551);
            window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel canvas = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    ImageIcon backgroundImg = new ImageIcon(Main.class.getResource("background.png"));
                    g.drawImage(backgroundImg.getImage(), -120, -200, this);
                }
            };
            canvas.setLayout(null);
            canvas.setBackground(new Color(5, 64, 91));
            canvas.setBounds(0, 0, 900, 551);
            window.add(canvas);

            JLabel errorMessage = new JLabel("");
            errorMessage.setForeground(Color.decode("#FFAB15"));
            errorMessage.setBounds(350, 400, 400, 40);
            canvas.add(errorMessage);

            JPasswordField entry0 = new JPasswordField();
            entry0.setBackground(Color.WHITE);
            entry0.setBorder(null);
            entry0.setBounds(353, 370, 130, 23);
            entry0.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
            canvas.add(entry0);

            ImageIcon img3 = new ImageIcon(Main.class.getResource("img3.png"));
            ImageIcon hoverUnsee = new ImageIcon(Main.class.getResource("HoverUnsee.png"));
            ImageIcon clicksee = new ImageIcon(Main.class.getResource("Clicksee.png"));
            JButton b1 = new JButton(img3);
            b1.setBorder(null);
            b1.setContentAreaFilled(false);
            b1.addMouseListener(new MouseListener() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    b1.setIcon(hoverUnsee);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    b1.setIcon(img3);
                }

                @Override
                public void mouseClicked(MouseEvent e) {}

                @Override
                public void mousePressed(MouseEvent e) {
                    b1.setIcon(clicksee);
                    entry0.setEchoChar((char) 0);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    b1.setIcon(img3);
                    entry0.setEchoChar('*');
                }
            });
            b1.setBounds(384, 370, 300, 25);
            canvas.add(b1);

            ImageIcon entry0Img = new ImageIcon(Main.class.getResource("img_textBox0.png"));
            JLabel entry0Bg = new JLabel(entry0Img);
            entry0Bg.setBounds(346, 370, entry0Img.getIconWidth(), entry0Img.getIconHeight());
            canvas.add(entry0Bg);

            ImageIcon entry1Img = new ImageIcon(Main.class.getResource("img_textBox1.png"));
            JLabel entry1Bg = new JLabel(entry1Img);
            entry1Bg.setBounds(346, 251, entry1Img.getIconWidth(), entry1Img.getIconHeight());
            canvas.add(entry1Bg);

            JTextField entry1 = new JTextField();
            entry1.setBackground(Color.WHITE);
            entry1.setBorder(null);
            entry1.setBounds(353, 252, 194, 23);
            entry1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
            canvas.add(entry1);

            ImageIcon img0 = new ImageIcon(Main.class.getResource("img0.png"));
            ImageIcon hoverImg = new ImageIcon(Main.class.getResource("Hoverimg.png"));
            ImageIcon clickimg = new ImageIcon(Main.class.getResource("new_image.png"));
            JButton b0 = new JButton(img0);
            b0.setBorder(null);
            b0.setContentAreaFilled(false);
            b0.addActionListener(new ActionListener() {
                @SuppressWarnings("deprecation")
                @Override
                public void actionPerformed(ActionEvent e) {
                    String enteredUsername = entry1.getText();
                    String enteredPassword = entry0.getText();
                    
                boolean found = false;
                int i;
                for (i =0 ; i<data.size() ; i++) {
                     if (data.get(i).getUsername().equals(enteredUsername) && data.get(i).getPassword().equals(enteredPassword)) {
                // Correct username and password, move to page2
                found = true;
                Test1 test1 = new Test1(data.get(i).getFirstName(),data.get(i).getLastName(),
                                    data.get(i).getPhonenumber(),data.get(i).getUsername()); // Create instance of Test1
                test1.setCanvasVisible();
                
                window.dispose(); // Close the login window
                break;
                
            }   
        }
        
        if (!found) {
            // Incorrect username or password
            errorMessage.setText("Error: Incorrect username or password.");
        }
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
                public void mouseClicked(MouseEvent e) {}

                @Override
                public void mousePressed(MouseEvent e) {
                    b0.setIcon(clickimg);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    b0.setIcon(img0);
                }
            });

            b0.setBounds(387, 448, 126, 37);
            canvas.add(b0);
            entry0.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        // Simulate button click
                        b0.doClick();
                    }
                }
            });
            
            entry1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        // Simulate button click
                        b0.doClick();
                    }
                }
            });
            
            window.setVisible(true);
        });
    }
}
