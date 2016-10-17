import javax.swing.*;
import java.awt.*;
import java.io.IOException;


/**
 * Created by noobtube on 16/10/2016.
 */
public class GameGuiFrame extends JFrame {
    public HumanCardsPanel humanCardsPanel;
    public CardTable cardTable = new CardTable();

    public GameGuiFrame(STPlayer[] players) throws IOException {
        super("SUPER TRUMPS GAME");
        humanCardsPanel = new HumanCardsPanel(players[0]);
        setLayout(new BorderLayout());
        setVisible(true);
        setSize(1500, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        add(humanCardsPanel, BorderLayout.SOUTH);
        add(cardTable, BorderLayout.NORTH);
        add(cardTable, BorderLayout.CENTER);


    }

}
