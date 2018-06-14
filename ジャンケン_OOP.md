# ジャンケン

## クラス

- Player
  - Yamada
  - Murata
- Judge
- ObjectJanken

## OOPを用いたジャンケンプログラム

Player

```java
/**
 * ジャンケンのプレイヤーを表すクラス。*
 */


public class Player {
    // ジャンケンの手を表す定数
    public static final int STONE = 0; // グー
    public static final int SCISSORS = 1; // チョキ
    public static final int PAPER = 2; // パー


    private String name_;
    private int winCount_ = 0;

    /**
     プレイヤークラスのコンストラクタ。
      @param name 名前
    */
    public Player(String name) {
        this.name_ = name;
    }


    /**
     * ジャンケンの手を出す。
     *
     * @return ジャンケンの手
     */
    public int showHand() {
        int Hand = 0;
        double randomNum = Math.random() * 3;
        // 0.0以上3.0未満の少数として乱数を得る

        if (randomNum < 1) {
            Hand = STONE;
        } else if (randomNum < 2) {
            Hand = SCISSORS;
        } else if (randomNum < 3) {
            Hand = PAPER;
        }
        return Hand;
    }

    /**
     * 審判から勝敗を聞く。
     * @param result true:勝ち,false:負け
    */
    public void notifyResult(boolean result) {
        if (result) {
            winCount_ += 1;
        }
    }

    /**
     * 自分の勝った回数を答える。
     * @return 勝った回数
    */
    public int getWinCount() {
        return winCount_;
    }
    /**
     * 自分の名前を答える。
     * @return 名前
    */
    public String getName() {
        return name_;
    }
}
```

Judge

```java
/**
 * ジャンケンの審判を表すクラス
  */

public class Judge {

    /**
     * ジャンケンを開始する。
     * @param player1 判定対象プレイヤー1
     * @param player2 判定対象プレイヤー2
     */
    public void startJanken(Player player1, Player player2){
        System.out.println("【ジャンケン開始】\n");

        for(int cnt = 0; cnt < 3; cnt++){
            System.out.println("【" + (cnt + 1) + "回戦目】");
            Player winner = judgeJanken(player1, player2);

            if(winner != null) {
                // 勝者を表示する
                System.out.println("\n" + winner.getName() + "が勝ちました！\n");
                winner.notifyResult(true);
            } else {
                // 引き分けの場合
                System.out.println("\n引き分けです！\n");
            }
        }

        System.out.println("【ジャンケン終了】\n");

        // 最終的な勝者を判定する
        Player finalWinner = judgeFinalWinner(player1, player2);

        System.out.print(
                player1.getWinCount() + "対" + player2.getWinCount() + "で");
        if(finalWinner != null) {
            System.out.println(finalWinner.getName() + "の勝ちです！\n");
        } else {
            System.out.println("引き分けです！\n");
        }
    }

    /**
     * 「ジャンケン、ポン！」と声をかけ、
     * プレイヤーの手を見て、どちらが勝ちかを判定する。
     *
     * @param player1 判定対象プレイヤー1
     * @param player2 判定対象プレイヤー2
     * @return 勝ったプレイヤー。引き分けの場合は、nullを返す。
     */
    private Player judgeJanken(Player player1, Player player2){
        Player winner = null;

        int player1hand = player1.showHand();
        int player2hand = player2.showHand();

        // それぞれの手を表示する
        printHand(player1hand);
        System.out.print("vs");
        printHand(player2hand);
        System.out.print("\n");

        // プレイヤー1が勝つ場合
        // プレイヤー1が勝つ場合
        if ((player1hand == Player.STONE && player2hand == Player.SCISSORS)
                || (player1hand == Player.SCISSORS && player2hand == Player.PAPER)
                || (player1hand == Player.PAPER && player2hand == Player.STONE)) {
            winner = player1;
            // プレイヤー2が勝つ場合
        } else if ((player1hand == Player.STONE && player2hand == Player.PAPER)
                || (player1hand == Player.SCISSORS && player2hand == Player.STONE)
                || (player1hand == Player.PAPER && player2hand == Player.SCISSORS)) {
            winner = player2;
        }
        // 引き分け
        return winner;
    }

    /**
     * 最終的な勝者を判定する。

     * @param player1 判定対象プレイヤー1
     * @param player2 判定対象プレイヤー2
     * @return 勝ったプレイヤー。引き分けの場合は null を返す。
     */
    private Player judgeFinalWinner(Player player1, Player player2){
        Player winner = null;

        int player1WinCount = player1.getWinCount();
        int player2WinCount = player2.getWinCount();

        // プレイヤー1の勝ち数が多い時
        if (player1WinCount > player2WinCount) {
            winner = player1;
        }
        // プレイヤー2の勝ち数が多い時
        else if (player2WinCount > player1WinCount) {
            winner = player2;
        }
        return winner;
        }

        /**
         * ジャンケンの手を表示する。
         *
         * @param hand ジャンケンの手
         */
        private void printHand(int hand){
            switch(hand){
                case Player.STONE :
                    System.out.print("グー");
                    break;
                case Player.SCISSORS :
                    System.out.print("チョキ");
                    break;
                case Player.PAPER :
                    System.out.print("パー");
                    break;
                default :
                    break;
            }
    }
}
```

ObjectJanken

```java
/**
 * オブジェクト指向によるジャンケンプログラム。
 */

public class ObjectJanken {
    public static void main(String[] args) {
        // 審判(斎藤さん)のインスタンス生成
        Judge saito = new Judge();

        // プレイヤーの生成
        Player murata = new Murata("村田さん");
        Player yamada = new Yamada("山田さん");

        saito.startJanken(murata, yamada);
    }
}
```

Murata,Yamada

```java
/**
 * プレイヤーを継承した村田さんクラス。
 */

public class Murata extends Player {
    /**
     * コンストラクタ
     *
     * @param name 名前
     */

    public Murata(String name){
        super(name);
    }

    public int showHand() {
        return STONE;
    }
}
```

```java
/**
 * プレイヤーを継承した村田さんクラス。
 */

public class Yamada extends Player {
    /**
     * コンストラクタ。
     *
     * @param name 名前
     */

    public Yamada(String name){
        super(name);
    }

    public int showHand() {
        return PAPER;
    }
}
```