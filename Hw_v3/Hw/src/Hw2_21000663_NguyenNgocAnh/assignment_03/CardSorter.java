package Hw2_21000663_NguyenNgocAnh.assignment_03;

import java.util.Arrays;

public class CardSorter {
    public static void main(String[] args) {

        // create an array of cards
        Card[] cards = new Card[] {
            new Card(2, 0),
            new Card(10, 1),
            new Card(5, 2),
            new Card(12, 3),
            new Card(1, 0)
        };

        // sort the cards using the compareCard comparator
        System.out.println("Using the compareCard comparator");
        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(cards));

        Arrays.sort(cards, Card.compareCard);

        System.out.println("_____________");
        System.out.println("After sorting:");
        System.out.println(Arrays.toString(cards));

        System.out.println("=====================================");

        // create a deck of cards
        Card[] deck = new Card[52];
        int index = 0;

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                deck[index] = new Card(i, j);
                index++;
            }
        }

        System.out.println("Before shuffling:");
        System.out.println(Arrays.toString(deck));

        // shuffle the deck
        for (int i = 0; i < 100; i++) {
            int randomIndex1 = (int) (Math.random() * 52);
            int randomIndex2 = (int) (Math.random() * 52);

            Card temp = deck[randomIndex1];
            deck[randomIndex1] = deck[randomIndex2];
            deck[randomIndex2] = temp;
        }

        System.out.println("_____________");
        System.out.println("After shuffling:");
        System.out.println(Arrays.toString(deck));
        
        SortTAlgorithm.quickSort(deck, 52);
        System.out.println("_____________");
        System.out.println("After sorting:");
        System.out.println(Arrays.toString(deck));
    }
}