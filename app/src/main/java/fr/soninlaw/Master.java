package fr.soninlaw;
import java.util.Random;

public class Master {


    private Random random = new Random();
    private int[] mastermind;
    private int tries;
    private int goodNumbers;
    private int placedNumbers;
    private boolean win;

    public Master() {
        this.mastermind = new int[]{random.nextInt(6), random.nextInt(6),
                random.nextInt(6), random.nextInt(6), random.nextInt(6)};
        this.tries = 0;
        this.goodNumbers = 0;
        this.placedNumbers = 0;
        this.win = false;
    }

    public int getGoodNumbers() {
        return this.goodNumbers;
    }

    public int getPlacedNumbers() {
        return this.placedNumbers;
    }

    public boolean isWin() {
        return this.win;
    }

    public String compareMind(int[] answer) {
        this.tries++;
        this.goodNumbers = 0;
        this.placedNumbers = 0;

        for (int i = 0; i < mastermind.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (mastermind[i] == answer[j]) {
                    this.goodNumbers++;
                    break;
                }
            }
        }

        if (answer[0] == mastermind[0]) {
            this.placedNumbers += 1;
        }
        if (answer[1] == mastermind[1]) {
            this.placedNumbers += 1;
        }
        if (answer[2] == mastermind[2]) {
            this.placedNumbers += 1;
        }
        if (answer[3] == mastermind[3]) {
            this.placedNumbers += 1;
        }
        if (answer[4] == mastermind[4]) {
            this.placedNumbers += 1;
        }

        switch (this.placedNumbers) {
            case 0:
                return String.format("%s chiffre(s) présent(s) et\n0 chiffre bien placé... Nul ! -_-", this.goodNumbers);
            case 1:
                return String.format("%s chiffre(s) présent(s) et\n1 chiffre bien placé... C'est un bon début !", this.goodNumbers);
            case 2:
                return String.format("%s chiffre(s) présent(s) et\n%s chiffres bien placés, c'est pas mal !", this.goodNumbers, this.placedNumbers);
            case 3:
                return String.format("%s chiffre(s) présent(s) et\n %s chiffres bien placés ! Pinaise !", this.goodNumbers, this.placedNumbers);
            case 4:
                return String.format("%s chiffre(s) présent(s) et\n %s chiffres bien placés !!! OMG, presque !!", this.goodNumbers, this.placedNumbers);
            default:
                this.win = true;
                return String.format("Wouhou, c'est gagné !! Bravo !!\n Vous avez trouvé la combinaison en %s tentatives.", this.tries);
        }
    }
}