import java.util.ArrayList;

/**
 * Created by noobtube on 3/09/2016.
 */
public class STPlayer {

    public ArrayList<STCard> cards = new ArrayList<STCard>();
    private String playerId;

    public STPlayer(String playerId) {
        this.playerId = playerId;
    }

    public void setCards(ArrayList<STCard> cards) {
        this.cards = cards;

    }

    @Override
    public String toString() {
        return playerId;
    }


}
