import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class HallwayGame {
    JFrame frame;
    public static ArrayList<String> items = new ArrayList<String>(4);

    public HallwayGame(JFrame frame) {
        this.frame = frame;
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsHallwayGame(true);
    }

    public static boolean checkWin() {
        for (String i : items) {
            if (i.equals("videoGame") || i.equals("dog") || i.equals("headphones")) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        frame.getContentPane().add(new Drawing());
        frame.setVisible(true);
    }

    class Drawing extends JComponent {
        public void paint(Graphics g) {
            super.paintComponent(g);
            // BACKGROUND
            g.setColor(Colours.backgroundBlue);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.WHITE);
            g.setFont(Colours.mediumSerifFont);
            g.drawString("Get 4 items you'll need for class", 100, 50);
            g.setColor(Color.GRAY);
            g.fillRect(180, 330, 440, 140);
            // DRAW SELECTED ITEMS
            int xPos = 180;
            for (String i : items) {
                try {
                    BufferedImage img = ImageIO.read(new File("images/items/" + i + ".png"));
                    Image newImage = img.getScaledInstance(110, 90, Image.SCALE_DEFAULT);
                    g.drawImage(newImage, xPos, 350, null);
                    xPos += 100;
                } catch (Exception e) {
                    System.out.println("Error with image");
                }
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/dog.png"));
                Image newImage = img.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 50, 100, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/notebook.png"));
                Image newImage = img.getScaledInstance(140, 140, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 160, 80, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/headphones.png"));
                Image newImage = img.getScaledInstance(140, 140, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 260, 85, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/textbooks.png"));
                Image newImage = img.getScaledInstance(130, 130, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 380, 90, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/pencilCase.png"));
                Image newImage = img.getScaledInstance(130, 130, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 520, 80, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/videoGame.png"));
                Image newImage = img.getScaledInstance(130, 130, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 300, 200, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/water.png"));
                Image newImage = img.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 460, 200, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            if (!checkWin() && items.size() == 4){
                g.setColor(Color.GRAY);
                g.fillRect(180, 330, 440, 140);
                g.setColor(Color.WHITE);
                g.drawString("Those are the incorrect items", 200, 400);
                g.drawString("press any key to try again", 200, 450);
            }
        }
    }
}