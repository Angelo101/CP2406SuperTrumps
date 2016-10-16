import javax.swing.*;
import java.awt.*;


/**
 * Created by noobtube on 16/10/2016.
 */
public class GameGuiFrame extends JFrame {
    public HumanCardsPanel humanCardsPanel = new HumanCardsPanel();
    public CardTable cardTable = new CardTable();

    public GameGuiFrame() {
        super("SUPER TRUMPS GAME");
        setLayout(new BorderLayout());
        setVisible(true);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        add(humanCardsPanel, BorderLayout.SOUTH);
        add(cardTable, BorderLayout.NORTH);
        add(cardTable, BorderLayout.CENTER);


    }

}
