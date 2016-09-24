import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Angelo Minchio on 02-Sep-16.
 */
public class STGame {

    private static final int NUM_CARDS_TO_DEAL = 8 ;
    private int numPlayers;
    public int dealerId;
    public STPlayer[] players;
    private STDeck deck;
    private int humanPlayerID;

    public STGame (int numPlayers) {
        this.numPlayers = numPlayers;
        deck = new STDeck();
    }
    public int selectDealer() {
        Random rand = new Random();
        dealerId = rand.nextInt(numPlayers);
        System.out.println("Dealer ID = " + dealerId);
        return dealerId;

        }




    public void dealRandomCards() {
        players = new STPlayer[numPlayers];
        for (int i = 0; i < numPlayers; i++){
            players[i] = new STPlayer("Player ID =" + i);
        }

        for (STPlayer player : players) {
            ArrayList<STCard> cards = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.setCards(cards);


        }

    }
    public void setHumanPlayer() {
        humanPlayerID = 0;
    }
    public STPlayer getHumanPlayer(){
        return players[humanPlayerID];
    }

    public void playTheGame() {
        //game logic
        boolean gameIsOn = true;
        while (gameIsOn){
            int idxPlayer = dealerId + 1;
            for (int  i = idxPlayer + 1; i < players.length; i++){
                int currentPlayer = i;
                if (i == 0){
                    players[i] = new STPlayer("Player ID =" + i);
                }


            }
            //todo: setup players in correct order


//            showTurnPlayer();
//            showHumanCards();

        }
    }

}
