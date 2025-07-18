// Slime.java
public final class Slime extends Monster { // finalキーワードで継承を禁止

    public Slime(char suffix, int hp) {
        super(suffix, hp);
        this.name = "スライム";
    }

    @Override
    public void attack(Creature target) {
        System.out.println(this.getName() + this.getSuffix() + "は体当たり攻撃！" + target.getName() + "に5のダメージを与えた！");
        target.setHp(target.getHp() - 5);
    }
}