import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by noobtube on 16/10/2016.
 */
public class HumanCardsPanel extends JPanel {
    STPlayer player;
    STGame game;
    STDeck cardd;

    public HumanCardsPanel(STPlayer player) throws IOException {
        super();
        this.player = player;
        setVisible(true);
        setLayout(new FlowLayout());
        setBackground(Color.BLACK);
//        int numOfCardsInHand = player.cards.size();

        for (STCard card: player.cards) {
            ShowCardImg  cards = new ShowCardImg(card);
            add(cards);
        }

    }
}