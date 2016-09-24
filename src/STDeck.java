import java.util.ArrayList;
import java.util.Random;

/**
 * Created by noobtube on 24/09/2016.
 */
public class STDeck {
    private static final int NUMBER_OF_CARDS = 60;
    private  ArrayList<STCard> cards;


    public STDeck(){
        cards = new ArrayList<STCard>();
        for (int i = 0; i < NUMBER_OF_CARDS; ++i) {
            cards.add(new STCard(i));
        }
    }


    public ArrayList<STCard> dealCards(int numCardsToDeal) {
        ArrayList<STCard> result = new ArrayList<>();
        for (int i = 0; i < numCardsToDeal; ++i){
            int index = new Random().nextInt(cards.size());
            STCard card = cards.remove(index);
            result.add(card);
            System.out.println("\n card=" + card);


        }
//        System.out.println(cards.size());
//        System.out.println(result.size());
        return result;
    }
}
