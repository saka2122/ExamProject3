// Goblin.java
public class Goblin extends Monster {

    public Goblin(char suffix, int hp) {
        super(suffix, hp);
        this.name = "ゴブリン";
    }

    @Override
    public void attack(Creature target) {
        System.out.println(this.getName() + this.getSuffix() + "はナイフで切りつけた！" + target.getName() + "に8のダメージを与えた！");
        target.setHp(target.getHp() - 8);
    }
}