package fantan;

import trump.Card;
import trump.Hand;
import trump.Rule;
import trump.Table;

/**
 * 七並べ用クラス
 */

public class FantanRule implements Rule {
    /**
     * テーブルに置けるカードを探す。
     *
     * @param hand 手札
     * @param table テーブル
     * @return 見つかったカードの組み合わせ。見つからなかった場合はnullを返す
     */
    public Card[] findCandidate(Hand hand, Table table){
        // テーブルに置けるカードの候補
        Card[] candidate = null;

        // 手札にあるカードを1枚ずつチェックして、テーブルに置けるかを調べる
        int numberOfHand = hand.getNumberOfCards();
        for (int position = 0; position < numberOfHand; position++) {

            // 手札にあるカードを見る
            Card lookingCard = hand.lookCard(position);
            int number = lookingCard.getNumber();
            int suit = lookingCard.getSuit();

            // 今注目している手札の左か右にカードがあれば、カードを置ける
            int leftNumber = (number != 1) ? number - 1 : Card.CARD_NUM;
            int rightNumber = (number != Card.CARD_NUM) ? number + 1 : 1;

            if ((isThereCard(table, suit, leftNumber))
              || (isThereCard(table, suit, rightNumber))){
            // 手札からカードを引いて候補とする
                candidate = new Card[1];
                candidate[0] = hand.pickCard(position);
                break;
            }
        }
        return candidate;
    }

    /**
     * テーブルにカードが置かれているか調べる
     *
     * @param table テーブル
     * @param suit スート
     * @param number 数
     * @return カードが置かれている場合はtrue
     */

    private boolean isThereCard(Table table, int suit, int number){
        // テーブルにあるカードを調べ、カードが置かれているか調べる
        Card[][] cards = table.getCards();
        if (cards[suit - 1][number - 1] != null){
            return true;
        } else {
            return false;
        }
    }
}