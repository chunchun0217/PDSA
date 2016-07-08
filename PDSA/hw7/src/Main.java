import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Created by cavitation on 2016/5/1.
 */
public class Main {
//    public static void main(String[] args) {
//
//        Card[] cards = new Card[5];
//        cards[0] = new Card("10","Spades");
//        cards[1] = new Card("K","Hearts");
//        cards[2] = new Card("Q","Hearts");
//        cards[3] = new Card("J","Hearts");
//        cards[4] = new Card("A","Hearts");
//        Hand h1 = new Hand(cards);
//
//        cards = new Card[5];
//        cards[0] = new Card("A","Clubs");
//        cards[1] = new Card("2","Hearts");
//        cards[2] = new Card("2","Diamonds");
//        cards[3] = new Card("3","Diamonds");
//        cards[4] = new Card("3","Clubs");
//        Hand h2 = new Hand(cards);
//
//        System.out.println(h1.compareTo(h2));
//}


    public static void main(String[] args) throws Exception {
        MinPQ<Hand> pq = new MinPQ();

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

            String[] header = br.readLine().split(",");
            int count = Integer.parseInt(header[0]);
            int target = Integer.parseInt(header[1]);

            for (int i = 0; i < count; i++) {
                String[] temp = br.readLine().split(",");
                Card[] cardsArray = new Card[5];
                for (int j = 0; j < 5; j++) {
                    String[] temp2 = temp[j].split("_");
                    Card c = new Card(temp2[1], temp2[0]);
                    cardsArray[j] = c;
                }
                Hand hand = new Hand(cardsArray);
                pq.insert(hand);
                if (pq.size() > target) {
                    pq.delMin();
                }
            }
            br.close();
        }
        Hand delHand = pq.delMin();
        Card[] delCard = delHand.getCards();
        Arrays.sort(delCard);

        String mix = "";
        String temp;
        for (int i = 0; i < 5; i++) {
            String face = delCard[i].getFace();
            String suit = delCard[i].getSuit();
            if (i == 0) {
                temp = suit + "_" + face;
            } else {
                temp = "," + suit + "_" + face;
            }
            mix = mix + temp;
        }
        System.out.println(mix);
    }
}
