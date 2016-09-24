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
        dealerId = rand.nextInt(numPlayers - 1) + 1;
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
}
