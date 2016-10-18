import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by noobtube on 16/10/2016.
 */
public class CardTable extends JPanel{
    STGame game;
    static JLabel currentCardView;


    public CardTable(){
//        System.out.println(cate);

        super();
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 300, 100));

        setBackground(Color.BLACK);
        currentCardView = new JLabel("Current Card In Play " );
        JLabel currentCategory = new JLabel("Current Category " + new SelectCategoryGui().getCategory() );
        JButton pickUpCard = new JButton("PICK UP");
        pickUpCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(currentCardView);
        add(currentCategory);
        add(pickUpCard);

    }
}
