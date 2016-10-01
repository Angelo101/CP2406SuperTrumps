import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Angelo Minchio on 02-Sep-16.
 */
public class STGame {

    private static final int NUM_CARDS_TO_DEAL = 8;
    public String categoryInPlay;
    private int numPlayers;
    public int dealerId;
    public STPlayer[] players;
    private STDeck deck = new STDeck();
    private int humanPlayerID;
    public STCard cardInPlay;
    public String categoryChoice;


//    public STGame(int numPlayers) {
//        this.numPlayers = numPlayers;
//        deck = new STDeck();
//    }

    public int selectDealer() {
        Random rand = new Random();
        dealerId = rand.nextInt((numPlayers - 1) + 1);
        System.out.println("Dealer ID = " + dealerId);
        return dealerId;

    }
//    public void trumpCard(){
//        STCard
//    }

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


    //todo: setup players in correct order

//    private void endTurn(){
//        playTheGame();
//    }

    public void aiTakeTurn() {
        int aiChoice;
        STPlayer aiPlayer = players[A1STGame.currentPlayer];
        if (categoryInPlay == null) {
          categoryInPlay =  aiChoosesCategory();
        }
        if (cardInPlay == null){
            Random rand = new Random();
            cardInPlay = aiPlayer.cards.remove(rand.nextInt(aiPlayer.cards.size() - 1));
        }
//        System.out.println("AI selecting a Card to play");
//        if (cardInPlay != null) {
////            System.out.println(cardInPlay);
//            System.out.println(" AI Selecting a card to play");
//        }
        if (aiPlayer.cards.size() == 0) {
            System.out.println("AI WON");
            System.out.println(finishGame());
        }
        else {
            for(int i = 0; i < aiPlayer.cards.size(); i++){
                aiChoice = i;

                if (aiPlayer.cards.get(aiChoice).getCategory(categoryInPlay) < cardInPlay.getCategory(categoryInPlay)){

                    System.out.println("AI Checking cards to play ");

                }else {
                    STCard selectedCard = aiPlayer.cards.remove(aiChoice);
                    System.out.println("AI selecting a card to play\n");
                    System.out.println("AI's Choice is: " + selectedCard);
                    cardInPlay = selectedCard;
                }

            }
        }
    }



    public int humanPlayerTakeTurn() {
        int choice = 0;
        if (categoryInPlay == null) {
            Scanner cardCat = new Scanner(System.in);
            System.out.println("Enter Card Category");

            categoryChoice = cardCat.nextLine();
            boolean choiceError = true;
            while (choiceError) {

                choiceError = checkCardCategory(categoryChoice);
                if (choiceError) {
                    System.out.println("Enter Card Category 2");
                    categoryChoice = cardCat.nextLine();
                }
            }
            categoryInPlay = categoryChoice;
        }


        Scanner userInput = new Scanner(System.in);
//        System.out.println("Human select a Card to play \n");

        if (cardInPlay != null) {
//            System.out.println(cardInPlay + "\n");
            System.out.println("Human Select a card to play\n");
            choice = userInput.nextInt() - 1;
            boolean errorInCard = true;
            while (errorInCard) {
                errorInCard = checkIfCardIsFucked(choice);
                if (errorInCard) {
                    System.out.println("Error in card");
                    System.out.println("Human select a Card to play");
                    choice = userInput.nextInt() - 1;
                }
            }
        }


        cardInPlay = players[0].cards.remove(choice);//removes users card they just played

        if (players[0].cards.size() == 0) {// if player has 0 cards, the game is finished and the player wins
            System.out.println(finishGame());
        }

        //// TODO: 26/09/2016 Make method to error check input range and if the card selected can be played

        return choice;
    }

    protected static void printCards(STPlayer player) {
        int cardNumber = 1;
        for (STCard card : player.cards) {
            System.out.println("\nCard: " + cardNumber);// giving the dealt cards a number so I can remove them and use them more easily
            System.out.println(card);
            cardNumber += 1;
        }

    }

    public String finishGame() {
        System.out.println("You Won!");
        System.exit(1);


        return "You Just WON!";
    }

    public boolean checkCardCategory(String categoryChoice) {
        if (categoryChoice.equals("Hardness") || (categoryChoice.equals("Specific Gravity") ||
                (categoryChoice.equals("Cleavage") || (categoryChoice.equals("Crustal abundance") || (categoryChoice.equals("Economic value")))))) {
            return false;
        }
        System.out.println("Category error");
        return true;
    }

    // compare cards
    public boolean checkIfCardIsFucked(int choice) {

//        if(choice == 100){// enter 101 to skip turn
//            skipTurn();
//
//        }

        if (players[0].cards.size() <= choice || choice < 0) {
            System.out.println("Cannot play this card, the card number is out of range");
            return true;
        }
//        if (players[0].cards.get(choice)){
//
//        }
        if (players[0].cards.get(choice).getCategory(categoryInPlay) < cardInPlay.getCategory(categoryInPlay)){
            System.out.println("Cannot play this card, the card category value is too low");
            return true;
        }
        return false;
    }
    public void setNumPlayers(int numberOfPlayers) {
        this.numPlayers = numberOfPlayers;
    }

    public String aiChoosesCategory() {
        String[] aiCategoryChoice = {"Hardness", "Cleavage", "Specific Gravity", "Crustal abundance", "Economic value"};
        String aiChoiceCat;
        System.out.println("AI is choosing a category:");
        aiChoiceCat = (aiCategoryChoice[new Random().nextInt(aiCategoryChoice.length)]);
        System.out.println(aiChoiceCat);

        return aiChoiceCat;
    }
    public void skipTurn(){
        System.out.println("Skipping Turn");
        A1STGame.currentPlayer ++;



    }

}


