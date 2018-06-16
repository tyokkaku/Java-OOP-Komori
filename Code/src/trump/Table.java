package trump;

/**
 * テーブルを表すインタフェース。
 */

public interface Table {
    /**
     * カードを置く。
     * テーブルに置かれたカードをどのように扱うかは、サブクラスで実装する。
     *
     * @param card カード
     */
    public void putCard(Card[] card);

    /**
     * カードを見る。
     *
     * @return テーブルに置かれたカードを表す配列
     */
    public Card[][] getCards();
}
