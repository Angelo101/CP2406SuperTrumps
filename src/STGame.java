import java.util.Random;

/**
 * Created by Angelo Minchio on 02-Sep-16.
 */
public class STGame {

    private static final int NUM_CARDS_TO_DEAL = 8 ;
    private int numPlayers = A1STGame.getNumPlayers();
    public int dealerId;
    public STPlayer[] players;

    public STGame (int numPlayers) {
        this.numPlayers = numPlayers;
    }
    public int selectDealer() {
        Random rand = new Random();
        dealerId = rand.nextInt(numPlayers - 2) + 2;
        return dealerId;

        }




    public void dealRandomCards() {
        players = new STPlayer[numPlayers];
        for (STPlayer player : players) {
            STCard cards = DeckBuilder.dealCards (NUM_CARDS_TO_DEAL);
            player.setCards;

        }
    }
}
