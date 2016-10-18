import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by noobtube on 17/10/2016.
 */
public class SelectCategoryGui extends JFrame {
    public STGame game;
    public String categoryInPlay;





//    public SelectCategoryGui(){
//          getCategory();
//        super("Select Category");
//        setSize(700,100);
//        setVisible(true);
//        setLocationRelativeTo(null);
//        setLayout(new FlowLayout());
//        JButton hardness = new JButton("Hardness");
//        hardness.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                game.categoryInPlay = "Hardness";
//            }
//        });
//        JButton specificGravity = new JButton("Specifi Gravity");
//        specificGravity.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                categoryInPlay = "Specific Gravity";
//            }
//        });
//        JButton cleavage = new JButton("Cleavage");
//        cleavage.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                categoryInPlay = "Cleavage";
//            }
//        });
//        JButton economicValue = new JButton("Economic Value");
//        economicValue.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                categoryInPlay = "Economic Value";
//            }
//        });
//        JButton crustalAbundance = new JButton("Crustal Abundance");
//        crustalAbundance.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                categoryInPlay = "Crustal Abundace";
//            }
//        });
//        JLabel msg = new JLabel();
//        msg.setText("Select a category!");
//        super.add(hardness);
//        super.add(specificGravity);
//        super.add(cleavage);
//        super.add(economicValue);
//        super.add(crustalAbundance);
//        super.add(msg);
//        super.revalidate();
////        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//
//
//    }
//
//}
        public String getCategory() {
            Object[] categories = {"Hardness", "Specific Gravity", "Cleavage", "Crustal Abundance", "Economic Value"};
            int n = -1;
            while (n == -1) {
                n = JOptionPane.showOptionDialog(new JOptionPane(), "Please choose a category to play.", "Category Selection",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, categories, categories[0]);
            }
//        System.out.println(n); //Checking value

            switch (n) {
                case 0:
                    categoryInPlay = "Hardness";
                    break;
                case 1:
                    categoryInPlay = "Specific Gravity";
                    break;
                case 2:
                    categoryInPlay = "Cleavage";
                    break;
                case 3:
                    categoryInPlay = "Crustal Abundance";
                    break;
                case 4:
                    categoryInPlay = "Economic Value";
                    break;
            }
            return categoryInPlay;

//        System.out.println(game.trumpCategoty); //Checking trump category


        }
}