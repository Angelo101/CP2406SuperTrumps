import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by noobtube on 16/10/2016.
 */
public class HumanCardsPanel extends JPanel {
    static STPlayer player;
    static STPlayer[] players;
    STGame game;
    static STDeck deck = new STDeck();
    static STCard card;
    static HumanCardsPanel humanCardsPanel;

    public HumanCardsPanel(STPlayer player) throws IOException {
        super();
        JButton addCard = new JButton("Pick Up Cards");
        addCard.setVisible(true);
        add(addCard);
        addCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addCard();
                revalidate();
                STMenuView.aiPlayCard();
            }
        });
        HumanCardsPanel.player = player;
        setVisible(true);
        setLayout(new FlowLayout());
        setBackground(Color.BLACK);
        for (STCard card : player.cards) {
            ShowCardImg cards = new ShowCardImg(card);
            add(cards);
        }
    }


    public void addCard() {
        STCard extraCard = deck.dealCards(1).remove(0);
        System.out.println(extraCard);
        try {
            ShowCardImg card2 = new ShowCardImg(extraCard);
            add(card2);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}