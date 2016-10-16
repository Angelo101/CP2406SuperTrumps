import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by noobtube on 15/10/2016.
 */
public class STMenuView {
    private JFrame frame;
    private JPanel panel;
    private JButton instructionsButton;
    private JButton playGameButton;
    private JComboBox selectPlayers;
    public STGame game;

    public STMenuView() {
        frame = new JFrame("SUPER TRUMPS CARD GAME");
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setBackground(Color.gray);
        selectPlayers = new JComboBox();
        instructionsButton = new JButton("INSTRUCTIONS");
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("INSTRUCTIONS");
                frame2.setVisible(true);
                frame2.setSize(600, 700);
                JPanel panel2 = new JPanel();
                panel2.setVisible(true);
                JTextArea area = new JTextArea();
                area.setEditable(false);
                area.append(A1STGame.instructions());
                panel2.add(area);
                frame2.add(panel2);
            }
        });
        playGameButton = new JButton("Play Game");
        playGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameGuiFrame gameGuiFrame = new GameGuiFrame();
                game = new STGame();
                game.selectDealer();
                game.dealRandomCards();
                game.setHumanPlayer();
                A1STGame.playTheGame();


            }
        });
        JLabel numberOfPlayersString = new JLabel("Select the number of players");
        selectPlayers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stringNumPlayers = selectPlayers.getSelectedItem().toString();
                int numPlayers = Integer.parseInt(stringNumPlayers);
                STGame.setNumPlayers(numPlayers);

            }
        });


        selectPlayers.addItem(2);
        selectPlayers.addItem(3);
        selectPlayers.addItem(4);
        panel.add(instructionsButton);
        panel.add(playGameButton);
        panel.add(numberOfPlayersString);
        panel.add(selectPlayers);
        frame.add(panel);
        frame.revalidate();


    }

}
