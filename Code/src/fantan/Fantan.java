package fantan;

import trump.*;

/**
 * 七並べプログラム
 */
public class Fantan {
    public static void main(String[] args) {
        // 進行役の生成
        Master master = new FantanMaster();
        // テーブルの生成
        Table table = new FantanTable();
        // ルールの生成
        Rule rule = new FantanRule();
        // プレイヤーの生成
        FantanPlayer Murata = new FantanPlayer("村田", master, table, rule);
        FantanPlayer Yamada = new FantanPlayer("山田", master, table, rule);
        FantanPlayer Saito = new FantanPlayer("斎藤", master, table, rule);
        // 進行役へプレイヤーを登録
        master.registerPlayer(Murata);
        master.registerPlayer(Yamada);
        master.registerPlayer(Saito);
        // トランプを生成する
        Hand trump = createTrump();
        // ゲームの準備をする
        master.prepareGame(trump);
        // ゲームを開始する
        master.startGame();
    }
    /**
     * 52枚のトランプを生成する。
     *
     * @return トランプを格納したDeal
     */
    private static Hand createTrump(){
        Hand trump = new Hand();

        // 各スート52枚のカードを生成する
        for (int number = 1; number <= Card.CARD_NUM; number++) {
            trump.addCard(new Card(Card.SUIT_CLUB, number));
            trump.addCard(new Card(Card.SUIT_DIAMOND, number));
            trump.addCard(new Card(Card.SUIT_HEART, number));
            trump.addCard(new Card(Card.SUIT_SPADE, number));
        }

        return trump;
    }
}
