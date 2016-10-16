import javax.swing.*;
import java.awt.*;

/**
 * Created by noobtube on 16/10/2016.
 */
public class CardTable extends JPanel{

    public CardTable(){
        super();
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 300, 100));

        setBackground(Color.BLACK);
        JLabel currentCardView = new JLabel("Current Card In Play");
        JLabel currentCategory = new JLabel("Current Category");
        JButton pickUpCard = new JButton("PICK UP");
        super.add(currentCardView);
        super.add(currentCategory);
        super.add(pickUpCard);

    }
}
