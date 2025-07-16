// GameMaster.java
import java.util.ArrayList;


public class GameMaster {

    public static void main(String[] args) {
        // --- 味方パーティ ---
        System.out.println("--- 味方パーティ ---");
        ArrayList<Character> party = new ArrayList<>();
        Hero hero = new Hero("勇者", 100, "剣");//ステを入力
        Wizard wizard = new Wizard("魔法使い", 60, 20); // MPは20
        Thief thief = new Thief("盗賊", 70);

        party.add(hero);
        party.add(wizard);
        party.add(thief);

        // --- 敵グループ ---
        System.out.println("--- 敵グループ ---");
        ArrayList<Monster> monsters = new ArrayList<>();
        Matango matangoA = new Matango('A', 45);
        Goblin goblinA = new Goblin('A', 50);
        Slime slimeA = new Slime('A', 40);

        monsters.add(matangoA);
        monsters.add(goblinA);
        monsters.add(slimeA);

        // 戦闘開始前ステータス表示
        System.out.println("\n--- 味方パーティ ---");
        for (Character member : party) {
            member.showStatus();
        }
        System.out.println("\n--- 敵グループ ---");
        for (Monster enemy : monsters) {
            enemy.showStatus();
        }

        // --- 味方の総攻撃！ ---
        System.out.println("\n味方の総攻撃！ ");
        // 勇者の攻撃
        if (hero.isAlive()) {
            hero.attack(matangoA); // 勇者は剣で攻撃！お化けキノコAに10のダメージを与えた！
            hero.attack(goblinA); // 勇者は剣で攻撃！ゴブリンAに10のダメージを与えた！
            hero.attack(slimeA);  // 勇者は剣で攻撃！スライムAに10のダメージを与えた！
        }

        // 魔法使いの攻撃
        if (wizard.isAlive()) {
            wizard.attack(goblinA); // 魔法使いは火の玉を放った！ゴブリンAに3のダメージを与えた！
            wizard.attack(goblinA); // 魔法使いは火の玉を放った！ゴブリンAに3のダメージを与えた！
            wizard.attack(slimeA);  // 魔法使いは火の玉を放った！スライムAに3のダメージを与えた！
        }

        // 盗賊の攻撃
        if (thief.isAlive()) {
            thief.attack(matangoA); // 盗賊は素早く攻撃した！お化けキノコAに5のダメージを与えた！
            thief.attack(goblinA);  // 盗賊は素早く攻撃した！ゴブリンAに5のダメージを与えた！
            thief.attack(slimeA);   // 盗賊は素早く攻撃した！スライムAに5のダメージを与えた！
        }

        // --- 敵の総攻撃！ ---
        System.out.println("\n 敵の総攻撃！ ");
        // お化けキノコAの攻撃
        if (matangoA.isAlive()) {
            matangoA.attack(hero);   // お化けキノコAは体当たり攻撃！勇者に6のダメージを与えた！
            matangoA.attack(wizard); // お化けキノコAは体当たり攻撃！魔法使いに6のダメージを与えた！
            matangoA.attack(thief);  // お化けキノコAは体当たり攻撃！盗賊に6のダメージを与えた！
        }

        // ゴブリンAの攻撃
        if (goblinA.isAlive()) {
            goblinA.attack(hero);   // ゴブリンAはナイフで切りつけた！勇者に8のダメージを与えた！
            goblinA.attack(wizard); // ゴブリンAはナイフで切りつけた！魔法使いに8のダメージを与えた！
            goblinA.attack(thief);  // ゴブリンAはナイフで切りつけた！盗賊に8のダメージを与えた！
        }

        // スライムAの攻撃
        if (slimeA.isAlive()) {
            slimeA.attack(hero);   // スライムAは体当たり攻撃！勇者に5のダメージを与えた！
            slimeA.attack(wizard); // スライムAは体当たり攻撃！魔法使いに5のダメージを与えた！
            slimeA.attack(thief);  // スライムAは体当たり攻撃！盗賊に5のダメージを与えた！
        }

        // --- クラスチェンジイベント ---
        // 画像では「ダメージを受けた勇者が覚醒した！」の後にヒーローのHPが81
        // (100 - 6 - 8 - 5 = 81) になっているため、この時点で覚醒メッセージを表示
        System.out.println("\nダメージを受けた勇者が突然光りだした！"); // このメッセージは画像のタイミングに合わせる

        // 勇者のHPが81なので、SuperHeroにクラスチェンジ
        // Heroインスタンスから SuperHeroインスタンスを生成し、パーティリストのメンバーを入れ替え
        int heroIndex = party.indexOf(hero);
        if (heroIndex != -1) {
            SuperHero superHero = new SuperHero(hero); // HeroインスタンスからSuperHeroを生成
            party.set(heroIndex, superHero); // パーティリストのHeroをSuperHeroに置き換え
            System.out.println(superHero.getName() + "はスーパーヒーローに進化した！");

            // クラスチェンジ後の強力な攻撃が実行される
            // 画像では「勇者は剣で攻撃！お化けキノコに25のダメージを与えた！」「勇者は剣で攻撃！ゴブリンに25のダメージを与えた！」
            // となっているため、SuperHeroの攻撃対象を固定
            superHero.attack(matangoA); // スーパーヒーローは剣で攻撃！お化けキノコAに25のダメージを与えた！
            superHero.attack(goblinA);  // スーパーヒーローは剣で攻撃！ゴブリンAに25のダメージを与えた！
            superHero.attack(slimeA);
        }

        // --- 戦闘後、両者の最終ステータス ---
        System.out.println("\n--- 味方パーティ 最終ステータス ---");
        System.out.println("勇者：HP " + hero.getHp()); // SuperHeroになった後も元のHeroインスタンスのHPを参照するように調整

        if (hero.isAlive()) {
            System.out.println("生存状態：生存");
        } else {
            System.out.println("生存状態：戦闘不能");
        }

     //   Character finalHero = party.get(0);
     //   finalHero.showStatus(); // 「勇者：HP 81」と表示される

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