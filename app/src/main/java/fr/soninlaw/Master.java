package fr.soninlaw;
import java.util.Random;

public class Master {


    private Random random = new Random();
    private int[] mastermind;
    int tries;

    //reponse = None
    //reponse_compteur = 0


    public Master() {
        this.mastermind = new int[] {random.nextInt(5), random.nextInt(5),
                random.nextInt(5), random.nextInt(5), random.nextInt(5)};
        this.tries = 0;
    }

    public String compareMind(int[] answer) {
        int goodNumbers = 0;
        int placedNumbers = 0;

        for (int i = 0; i < mastermind.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (mastermind[i] == answer[j]) {
                    goodNumbers++;
                    break;
                }
            }
        }

        if (answer[0] == mastermind[0]) {
            placedNumbers += 1;
        }
        if (answer[1] == mastermind[1]) {
            placedNumbers += 1;
        }
        if (answer[2] == mastermind[2]) {
            placedNumbers += 1;
        }
        if (answer[3] == mastermind[3]) {
            placedNumbers += 1;
        }
        if (answer[4] == mastermind[4]) {
            placedNumbers += 1;
        }

        switch (placedNumbers) {
            case 0:
                return String.format("%s chiffre(s) présent(s) dans la combinaison et\n0 chiffre bien placé... Nul ! -_-", goodNumbers);
            case 1:
                return String.format("%s chiffre(s) présent(s) dans la combinaison et\n1 chiffre bien placé... C'est un bon début !", goodNumbers);
            case 2:
                return String.format("%s chiffre(s) présent(s) dans la combinaison et\n%s chiffres bien placés, c'est pas mal !", goodNumbers, placedNumbers);
            case 3:
                return String.format("%s chiffre(s) présent(s) dans la combinaison et\n %s chiffres bien placés ! Pinaise !", goodNumbers, placedNumbers);
            case 4:
                return String.format("%s chiffre(s) présent(s) dans la combinaison et\n %s chiffres bien placés !!! OMG, presque !!", goodNumbers, placedNumbers);
            default:
                return String.format("Wouhou, c'est gagné !! Bravo !!\n Vous avez trouvé la combinaison en %s tentatives.", tries);
        }
    }
/*
    while reponse != mastermind:

        reponse = str(input("Devinez la série de 5 chiffres compris entre 0 et 5 : "))
        reponse_set = set(reponse)

        if reponse == "mastermind":
        print(mastermind, type(mastermind))

                if len(reponse) != 5:
        print("\n Il faut donner un nombre à 5 chiffres, banane !\n")

        else:

        reponse = list(reponse)
        reponse_compteur += 1

        nb_place = 0
        nb_exist = len(reponse_set & mastermind_set)*/

}
