import java.util.ArrayList;


public class GameMaster {

    public static void main(String[] args) {
        // --- 味方パーティ ---の情報を作る。
        // System.out.println("--- 味方パーティ ---");
        ArrayList<Character> party = new ArrayList<>();
        Hero hero = new Hero("勇者", 100, "剣");//ステを入力
        Wizard wizard = new Wizard("魔法使い", 60, 20); // MPは20
        Thief thief = new Thief("盗賊", 70);

        party.add(hero);
        party.add(wizard);
        party.add(thief);

        // --- 敵グループ ---上と同様に作る。
        //System.out.println("--- 敵グループ ---");
        ArrayList<Monster> monsters = new ArrayList<>();
        Matango matangoA = new Matango('A', 45);
        Goblin goblinA = new Goblin('A', 50);
        Slime slimeA = new Slime('A', 40);

        monsters.add(matangoA);
        monsters.add(goblinA);
        monsters.add(slimeA);

        // 戦闘開始前ステータス表示させる。　なんか改行されない　　解決 改行要らない
        System.out.println("--- 味方パーティ ---");
        for (Character member : party) {
            member.showStatus();
        }
        System.out.println("--- 敵グループ ---");
        for (Monster enemy : monsters) {
            enemy.showStatus();
        }

        // 味方の総攻撃　
        System.out.println("\n味方の総攻撃！");
        for (Character member : party) {
            for (Monster enemy : monsters) {
                member.attack(enemy);
            }
        }

        //  敵の総攻撃
        System.out.println("\n 敵の総攻撃！");
        for (Monster enemy : monsters) {
            for (Character member : party) {
                enemy.attack(member);
            }
        }
//メモーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
//多分ここでクラスを変える。
        //HeroからSuperHeroにかえる。
        //Heroの情報をsuperheroに渡さないといけない

        //どうするか考える。


        System.out.println("\nダメージを受けた勇者が突然光りだした！");

        // 勇者のHPが81なので、SuperHeroにクラスチェンジ
        // Heroインスタンスから SuperHeroインスタンスを生成し、パーティリストのメンバーを入れ替える。
        SuperHero superHero = new SuperHero(hero); // HeroインスタンスからSuperHeroを生成するらしいどうゆうことや？ここでヒーロークラスから継承してるのか？// パーティリストのHeroをSuperHeroに置き換え　セットでヒーローの場所にスーパーヒーローをいれる上書きみたいなことかも
        System.out.println(superHero.getName() + "はスーパーヒーローに進化した！");
        //スーパーヒーローにならない。
        //うまくHeroクラスから移行できてない。
        for (Monster enemy : monsters) {
            superHero.attack(enemy);
        }

        //戦闘後の両者の最終ステ
        System.out.println("\n--- 味方パーティ 最終ステータス ---");
        System.out.println("勇者：HP " + hero.getHp()); // SuperHeroになった後も元のHeroインスタンスのHPを参照するように調整することでｈｐがうまく出るらしい。

        //ーーーーーーーーここまでのエラーめもーーーーーー
        //ｈｐが正常に表示されない
        //勇者のステータスが二回表示される。　色々消してたら治ってた。解決。
        //仕様書通りの順番で表示されない。　　ＩＦ文の位置変えて解決。
        //何故かダメージをくらっていない
        //ｈｐにばらつきがある
        //死んでいる場合に戦闘不能と表示されない。　　解決。
        //そもそも、isAlive が違うのかも　　　　解決。

        //new
        //敵もｈｐがゼロになった時の表示が出ない。　解決。

        //疑問：総攻撃は二重ループにしたが、生存、戦闘不能もFOR文で書くべきなのか
        //FOＲ文で書こうと思ったができなかったので止めた。

        if (hero.isAlive()) {
            System.out.println("生存状態：生存");
        } else {
            System.out.println("生存状態：戦闘不能");
        }


       // System.out.println("勇者：HP " + hero.getHp());
        System.out.println("魔法使い：HP " + wizard.getHp());//魔法使いの現在のｈｐを獲得する

        if (wizard.isAlive()) {//生きているかをＩＦ文で判別する。
            System.out.println("生存状態：生存");
        } else {
            System.out.println("生存状態：戦闘不能");
        }

        System.out.println("盗賊：HP " + thief.getHp());//盗賊の現在のｈｐを獲得する

        if (thief.isAlive()) {//生きているかどうかをＩＦ文で判別する。
            System.out.println("生存状態：生存");
        } else {
            System.out.println("生存状態：戦闘不能");
        }

        System.out.println("\n--- 敵グループ最終ステータス ---");//敵さんのステの表示と生死判定

        System.out.println("お化けキノコA：HP " + matangoA.getHp());
        if (matangoA.isAlive()) {
            System.out.println("生存状態：生存");
        } else {
            System.out.println("生存状態：討伐済み");
        }

        System.out.println("ゴブリンA：HP " + goblinA.getHp());
        if (goblinA.isAlive()) {
            System.out.println("生存状態：生存");
        } else {
            System.out.println("生存状態：討伐済み");
        }

        System.out.println("スライムA：HP " + slimeA.getHp());
        if (slimeA.isAlive()) {
            System.out.println("生存状態：生存");
        } else {
            System.out.println("生存状態：討伐済み");
        }


    }
}

//めも

//シーフクラスだけは何とか終わった。
//明後日はほかの人とモンスターのクラスを作る。

//CretureとsuperHero、Heroが全くできない。
//ゲームマスターの大まかな流れだけ作る。

//諦めて頼る。

//仕様書通りの結果が出るようにはなった。
//来週仕様書のエラーを試す。
