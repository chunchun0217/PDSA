/**
 * Created by cavitation on 2016/4/19.
 */
public class test {
    public static void main(String[] args) {
        Card c1 = new Card("A","Spades");
        Card c2 = new Card("J","Clubs");
        int result = c1.compareTo(c2);
        System.out.println(result);


        Player p1 = new Player("Qaz");
        Player p2 = new Player("Wsx");

        Card[] cards1 = new Card[5];
        Card[] cards2 = new Card[5];

        cards1[0] = new Card("","");
        cards1[1] = new Card("","");
        cards1[2] = new Card("","");
        cards1[3] = new Card("","");
        cards1[4] = new Card("","");

        cards2[0] = new Card("","");
        cards2[1] = new Card("","");
        cards2[2] = new Card("","");
        cards2[3] = new Card("","");
        cards2[4] = new Card("","");

        p1.setCards(cards1);
        p2.setCards(cards2);

        int result2 = p1.compareTo(p2);
        System.out.println(result2);

    }
}
