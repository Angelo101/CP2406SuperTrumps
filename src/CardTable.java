import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by noobtube on 16/10/2016.
 */
public class CardTable extends JPanel {
    STGame game;
    STCard card;
    public STDeck deck = new STDeck();
    public STPlayer player;
    STPlayer[] players;
    static JLabel currentCardView;
    HumanCardsPanel humanCardsPanel;
//HumanCardsPanel cardsPanel = new HumanCardsPanel(player);

    public CardTable(STPlayer player) throws IOException {
//        System.out.println(cate);

        super();
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 300, 100));
        this.player = player;
        setBackground(Color.BLACK);
        currentCardView = new JLabel("Current Card In Play ");
        JLabel currentCategory = new JLabel("Current Category " + new SelectCategoryGui().getCategory());

        add(currentCardView);
        add(currentCategory);

    }
}
