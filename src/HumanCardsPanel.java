import javax.swing.*;
import java.awt.*;

/**
 * Created by noobtube on 16/10/2016.
 */
public class HumanCardsPanel extends JPanel {
    STPlayer player;

    public HumanCardsPanel(){
        super();
        setVisible(true);
        setLayout(new FlowLayout());
        setBackground(Color.BLACK);
        int cards = 8;
//        int numOfCardsInHand = player.cards.size();
//        for(int i = 0; i < player.cards.size(); i ++){
//            JButton cards = new JButton();
//            add(cards);
//
//        }
        for (int i = 0; i < cards; i++){
            JButton playerCards = new JButton();
            add(playerCards);
        }
//        add(cards);
//        add(card);



    }
}
