import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by noobtube on 17/10/2016.
 */
public class SelectCategoryGui extends JFrame {
    STGame game;


    public SelectCategoryGui(){
        super("Select Category");
        setSize(700,100);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        JButton hardness = new JButton("Hardness");
        hardness.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.categoryInPlay = "Hardness";
            }
        });
        JButton specificGravity = new JButton("Specifi Gravity");
        specificGravity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.categoryInPlay = "Specific Gravity";
            }
        });
        JButton cleavage = new JButton("Cleavage");
        cleavage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.categoryInPlay = "Cleavage";
            }
        });
        JButton economicValue = new JButton("Economic Value");
        economicValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game. categoryInPlay = "Economic Value";
            }
        });
        JButton crustalAbundance = new JButton("Crustal Abundance");
        crustalAbundance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.categoryInPlay = "Crustal Abundace";
            }
        });
        JLabel msg = new JLabel();
        msg.setText("Select a category!");
        super.add(hardness);
        super.add(specificGravity);
        super.add(cleavage);
        super.add(economicValue);
        super.add(crustalAbundance);
        super.add(msg);
        super.revalidate();
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}
