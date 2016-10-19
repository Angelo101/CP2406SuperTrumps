import javax.swing.*;
import java.awt.*;
import java.io.IOException;


/**
 * Created by noobtube on 16/10/2016.
 */
public class GameGuiFrame extends JFrame {
    public HumanCardsPanel humanCardsPanel;
    STPlayer player;
    public CardTable cardTable = new CardTable(player);

    public GameGuiFrame(STPlayer[] players) throws IOException {
        super("SUPER TRUMPS GAME");
        humanCardsPanel = new HumanCardsPanel(players[0]);
        setLayout(new BorderLayout());
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JScrollPane playerViewScroll = new JScrollPane(humanCardsPanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        add(playerViewScroll, BorderLayout.SOUTH);
        add(cardTable, BorderLayout.NORTH);
        add(cardTable, BorderLayout.CENTER);


    }

}
