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
    private static STCard currentCard;
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

    public int aiTakeTurn() {
        int aiChoice;
        if (categoryInPlay == null) {
          categoryInPlay =  aiChoosesCategory();


        }

        System.out.println("AI selecting a Card to play");


        if (cardInPlay != null) {
            System.out.println(cardInPlay);
            System.out.println(" AI Selecting a card to play");
        }
        Random rand = new Random();
        STPlayer aiPlayer = players[A1STGame.currentPlayer];
        if (aiPlayer.cards.size() == 0) {
            System.out.println("AI WON");
            System.out.println(finishGame());
        }
        aiChoice = rand.nextInt(aiPlayer.cards.size());
        STCard selectedCard = aiPlayer.cards.remove(aiChoice);
        System.out.println("AI's Choice is: " + selectedCard);
        cardInPlay = selectedCard;

        return aiChoice;
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

        if (currentCard != null) {
            System.out.println(currentCard + "\n");
            System.out.println("Human Select a card to play\n");

            choice = userInput.nextInt() - 1;
            boolean errorInCard = true;
            while (errorInCard) {

                currentCard = cardInPlay;
                errorInCard = checkIfCardIsFucked(choice);

                if (errorInCard) {
                    System.out.println("Error in card");
                    System.out.println("Human select a Card to play");
                    choice = userInput.nextInt() - 1;
                }
            }
//        while (choice != categoryInPlay){
//
//        }
            // while choice != categoryInPlay
            // print Wrong category, please choose a card in the current category
            //get choice

        }
        currentCard = players[0].cards.remove(choice);//removes users card they just played
        cardInPlay = currentCard;

//            System.out.println("ASHDGFHASDHFAHSDFHSAHDFHASDHFAHSDFHASDHFHSADHFHSADF" + currentCard);

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
        //get cardInPlay
        //get currentCard

        //while
        // (if currentCard < cardInPlay)
        // print"Card Cannot be played"
        //else{
        //print"Card accepted"
        //continue playing
//        cardInPlay = currentCard;
        currentCard = cardInPlay;

        if (players[0].cards.size() <= choice || choice < 0) {
            return true;
        }
//        System.out.println(currentCard);
        if (currentCard.getCategory(categoryInPlay) < cardInPlay.getCategory(categoryInPlay)) {
            return true;
        }
        return false;
    }
//    public static void getCurrentCard(STCard cardInPlay){
//        cardInPlay = currentCard;
//
//
//
//    }

    //
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


}


