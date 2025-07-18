// Matango.java
public class Matango extends Monster {

    public Matango(char suffix, int hp) {
        super(suffix, hp);
        this.name = "お化けキノコ";
    }

    @Override
    public void attack(Creature target) {
        System.out.println(this.getName() + this.getSuffix() + "は体当たり攻撃！" + target.getName() + "に6のダメージを与えた！");
        target.setHp(target.getHp() - 6);
    }
}