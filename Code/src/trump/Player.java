package trump;

/**
 * プレイヤーを表すクラス。
 */
public abstract class Player {
    /** 名前 */
    protected String name_;

    /** フィールド */
    protected Table table_;

    /** 手札 */
    protected Hand myHand_ = new Hand();

    /** 進行役 */
    protected Master master_;

    /** ルール */
    protected Rule rule_;

    /**
     * コンストラクタ。
     *
     * @param name 名前
     * @param master 進行役
     * @param table テーブル
     * @param rule ルール
     */
    public Player(String name, Master master, Table table, Rule rule){
        this.name_ = name;
        this.master_ = master;
        this.table_ = table;
        this.rule_ = rule;
    }

    /**
     * 順番を指名する。
     * 実際の処理はサブクラスで記述すること。
     *
     * @param nextPlayer 次のプレイヤー
     */
    public abstract void play(Player nextPlayer);

    /**
     * カードを配る。
     * カードを受け取った時の処理を拡張したい場合は、
     * 本メソッドをサブクラスでオーバーライドすること。
     *
     * @param card 受け取ったカード
     */
    public void receiveCard(Card card){
        // 受け取ったカードを手札に加える
        myHand_.addCard(card);
    }

    /**
     * プレイヤーの名前を返す。
     * ObjectクラスのtoStringメソッドをオーバーライドしたメソッド
     *
     * @return プレイヤーの名前
     */
    public String toString(){
        return name_;
    }
}
