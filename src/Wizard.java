// Wizard.java
public class Wizard extends Character {
    private int mp;

    public Wizard(String name, int hp, int mp) {
        super(name, hp);
        this.setMp(mp);
    }

    @Override
    public void attack(Creature target) {
        if (this.getMp() >= 1) { // MPが足りるか確認しないといけないらしい。
            System.out.println(this.getName() + "は火の玉を放った！" + target.getName() + "に3のダメージを与えた！");
            target.setHp(target.getHp() - 3);
            this.setMp(this.getMp() - 1); // MPを1消費
        } else {
            System.out.println(this.getName() + "はMPが足りず、魔法を使えなかった！");
            // MPが足りない場合の処理は多分ここに書く　
            //
             //MP足りない時の処理をかく所　あとでかく
             //
        }
    }


    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        if (mp < 0) {
            this.mp = 0; // MPが負の値にならないようにする
        } else {
            this.mp = mp;
        }
    }
}