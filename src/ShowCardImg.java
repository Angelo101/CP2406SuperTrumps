import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by noobtube on 17/10/2016.
 */
public class ShowCardImg extends JPanel {

    BufferedImage cardImage;
    String workingDirectory = System.getProperty("user.dir");
    JButton cardView;
    JLabel currentCardView = CardTable.currentCardView;
    public ShowCardImg(STCard card) throws IOException{
        try {
            cardImage = ImageIO.read(new File(workingDirectory + "/res/" + card.fileName));
        }catch (IOException e){
            e.printStackTrace();
        }

        cardImage = cardResize(cardImage, 250, 350, BufferedImage.TYPE_INT_ARGB);
        cardView = new JButton(new ImageIcon(cardImage));
        add(cardView);
        cardView.addActionListener(e -> {
            currentCardView.setIcon(new ImageIcon(cardImage));
            remove(cardView);
            revalidate();

            // add card to cardinplay on cardtable
            //remove card when pressed
//            System.out.println("i got ressed");

        });
    }

    private BufferedImage cardResize(BufferedImage cardImage, int i, int i1, int typeIntArgb) {
        BufferedImage cardResized = new BufferedImage(i, i1,typeIntArgb);
        Graphics2D g = cardResized.createGraphics();
        g.drawImage(cardImage, 0, 0, i, i1, null);
        g.dispose();
        return cardResized;
    }


}
