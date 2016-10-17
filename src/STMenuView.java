import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
//    public SelectCategoryGui selectCategoryGui;
//    public SelectCategoryGui selectCategoryGui;

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
        new SelectCategoryGui();
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
                game = new STGame();
                game.selectDealer();
                game.dealRandomCards();
                game.setHumanPlayer();


//                playTheGame();
                try {
                    GameGuiFrame gameGuiFrame = new GameGuiFrame(game.players);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
                private void playTheGame(){
                    //game logic
                    boolean gameIsOn = true;
                    int currentPlayer = game.dealerId + 1;
                    while (gameIsOn) {
                        System.out.println();
                        if (currentPlayer > game.players.length -1) {
                            currentPlayer = 0;
                        }
                        if (currentPlayer == 0) {
                            System.out.println(game.players[0]);
                            game.printCards(game.players[0]);
                            System.out.println("\nCurrent Category is: " + game.categoryInPlay);
                            System.out.println("Current Card in play is: " + game.cardInPlay);
                            game.humanPlayerTakeTurn();

                        } else {
                            game.aiTakeTurn();
                        }
                        currentPlayer += 1;
                    }
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