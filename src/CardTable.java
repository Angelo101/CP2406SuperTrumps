import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by noobtube on 16/10/2016.
 */
public class CardTable extends JPanel {
    static JLabel currentCardView;


    public CardTable() throws IOException {

        super();
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 300, 100));
        setBackground(Color.BLACK);
        currentCardView = new JLabel("Current Card In Play ");
        JLabel currentCategory = new JLabel("Current Category " + new SelectCategoryGui().getCategory());
        add(currentCardView);
        add(currentCategory);
    }
}


