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

    public String getCategory() {
        Object[] categories = {"Hardness", "Specific Gravity", "Cleavage", "Crustal Abundance", "Economic Value"};
        int n = -1;
        while (n == -1) {
            n = JOptionPane.showOptionDialog(new JOptionPane(), "Please choose a category to play.", "Category Selection",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, categories, categories[0]);
        }
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
    }
}