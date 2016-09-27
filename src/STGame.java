import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Angelo Minchio on 02-Sep-16.
 */
public class STGame {

    private static final int NUM_CARDS_TO_DEAL = 8;
    private int numPlayers;
    public int dealerId;
    public STPlayer[] players;
    private STDeck deck;
    private int humanPlayerID;
    private static STCard currentCard;

    public STGame(int numPlayers) {
        this.numPlayers = numPlayers;
        deck = new STDeck();
    }

    public int selectDealer() {
        Random rand = new Random();
        dealerId = rand.nextInt((numPlayers - 1) + 1);
        System.out.println("Dealer ID = " + dealerId);
        return dealerId;

    }

    public void dealRandomCards() {
        players = new STPlayer[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
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

    public STPlayer getHumanPlayer() {
        return players[humanPlayerID];
    }

    public void playTheGame() {
        //game logic
        boolean gameIsOn = true;
        int currentPlayer = dealerId + 1;
        while (gameIsOn) {
            if (currentPlayer > players.length){
                currentPlayer = 0;
            }

            if (currentPlayer == 0) {
                System.out.println(players[0]);
                printCards(players[0]);
                //humanplayer takes turn
                humanPlayerTakeTurn();
                
            } else {
                System.out.println(aiTakeTurn());
            }
            currentPlayer += 1;

        }}
        //todo: setup players in correct order

    private void endTurn(){
        playTheGame();
    }

    private String aiTakeTurn() {
        String playTurn = "AI taking turn";
        return playTurn;
    }


    public int humanPlayerTakeTurn() {

        int choice;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Human select a Card to play");
        System.out.println(currentCard);
        choice = userInput.nextInt() -1;
        while (players[0].cards.size() < choice || choice < 0){
            System.out.println("Out of range");
            System.out.println("Human select a Card to play");
            choice = userInput.nextInt() -1;
        }
        currentCard = players[0].cards.remove(choice);//removes users card they just played

        if (players[0].cards.size() == 0){// if player has 0 cards, the game is finished and the player wins
            System.out.println(finishGame());
        }

        //// TODO: 26/09/2016 Make method to error check input range and if the card selected can be played

        return choice;
    }
    protected static void printCards(STPlayer player){
        int cardNumber = 1;
        for (STCard card: player.cards){
            System.out.println("\nCard: " + cardNumber);// giving the dealt cards a number so I can remove them and use them more easily
            System.out.println(card);
            cardNumber += 1;
        }

    }

    public String finishGame(){
        System.out.println("You Won!");
        System.exit(1);
        return "You Just WON!";
    }


}


