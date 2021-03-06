import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Angelo on 6/09/2016.
 */

//TODO: Fix Occurrence not displaying when printed

public class STCard extends JLabel {
    private String cardType, title, chemistry, classification, crystalSystem, cleavage, crustalAbundance, economicValue, occurString;
    private ArrayList<String> occurrence = new ArrayList<>();
    private double hardness, specificGravity;
    public String fileName;

    public STCard(String fileName, String cardType, String title,
                  String chemistry, String classification, String crystalSystem,
                  ArrayList<String> occurrence, double hardness, double specificGravity,
                  String cleavage, String crustalAbundance, String economicValue) {
        this.fileName = fileName;
        this.cardType = cardType;
        this.title = title;
        this.chemistry = chemistry;
        this.classification = classification;
        this.crystalSystem = crystalSystem;
        this.cleavage = cleavage;
        this.crustalAbundance = crustalAbundance;
        this.economicValue = economicValue;
        this.occurrence = occurrence;
        this.hardness = hardness;
        this.specificGravity = specificGravity;
        occurString = "";
        for (int i = 0; i < occurrence.size(); i++) {
            occurString = occurString + " " + occurrence.get(i);
        }
    }

    public String toString() {
        String ret;
        if (cardType.equals("play")) {
            ret = "\n" + title + "\n Chemistry: " + chemistry + "\n Classification: " + classification +
                    "\n Crystal System: " + crystalSystem + "\n Occurrence: " + occurString +
                    "\n Hardness: " + hardness + "\n Specific Gravity: " + specificGravity +
                    "\n Cleavage: " + cleavage + "\n Crustal Abundance: " + crustalAbundance +
                    "\n Economic Value: " + economicValue;
            return ret;
        } else if (cardType.equals("trump")) {
            ret = "\n" + title + "\n Change trump category to: " + chemistry;
            return ret;
        } else
            return "cardError-1";
    }

    public double getCategory(String cardCategory) {
        if (cardCategory.equals("Hardness")) {
            return this.hardness;
        }
        if (cardCategory.equals("Specific Gravity")) {
            return this.specificGravity;
        }
        if (cardCategory.equals("Cleavage")) {
            switch (this.cleavage) {
                case "none":
                    return 0.0;
                case "poor/none":
                    return 1.0;
                case "1 poor":
                    return 2.0;
                case "2 poor":
                    return 3.0;
                case "1 good":
                    return 4.0;
                case "1 good/ 1 poor":
                    return 5.0;
                case "2 good":
                    return 6.0;
                case "3 good":
                    return 7.0;
                case "1 perfect":
                    return 8.0;
                case "1 perfect, 1 good":
                    return 9.0;
                case "1 perfect, 2 good":
                    return 10.0;
                case "2 perfect, 1 good":
                    return 11.0;
                case "3 perfect":
                    return 12.0;
                case "4 perfect":
                    return 13.0;
                case "6 perfect":
                    return 14.0;
            }
        }
        if (cardCategory.equals("Crustal abundance")) {
            switch (this.crustalAbundance) {
                case "ultratrace":
                    return 1.0;
                case "trace":
                    return 2.0;
                case "low":
                    return 3.0;
                case "moderate":
                    return 4.0;
                case "high":
                    return 5.0;
                case "very high":
                    return 6.0;
            }
        }
        if (cardCategory.equals("Economic value")) {
            switch (this.economicValue) {
                case "trivial":
                    return 1.0;
                case "low":
                    return 2.0;
                case "moderate":
                    return 3.0;
                case "high":
                    return 4.0;
                case "very high":
                    return 5.0;
                case "i'm rich":
                    return 6.0;
            }
        }
        return -1;
    }

    public String getFileName() {
        return fileName;
    }

    public String getCardType() {
        return cardType;
    }

    public String getTitle() {
        return title;
    }

    public String getChemistry() {
        return chemistry;
    }

    public String getClassification() {
        return classification;
    }

    public String getCrystalSystem() {
        return crystalSystem;
    }

    public String getCleavage() {
        return cleavage;
    }

    public String getCrustalAbundance() {
        return crustalAbundance;
    }

    public String getEconomicValue() {
        return economicValue;
    }

    public String getOccurString() {
        return occurString;
    }

    public ArrayList<String> getOccurrence() {
        return occurrence;
    }

    public double getHardness() {
        return hardness;
    }

    public double getSpecificGravity() {
        return specificGravity;
    }
}
