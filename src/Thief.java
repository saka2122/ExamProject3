// Thief.java
public class Thief extends Character {

    public Thief(String name, int hp) {
        super(name, hp);
    }

    @Override
    public void attack(Creature target) {
        System.out.println(this.getName() + "は素早く攻撃した！" + target.getName() + "に5のダメージを与えた！");
        target.setHp(target.getHp() - 5);//gethp    から直接-数値できるらしい。
    }
}
//これコッピって他クラスに八つけて名前だけ変える。