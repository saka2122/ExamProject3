// SuperHero.java
public class SuperHero extends Hero {

    // Heroインスタンスを引数にとるコンストラクタ
    public SuperHero(Hero hero) {
        super(hero.getName(), hero.getHp(), hero.getWeapon());
    }

    @Override
    public void attack(Creature target) {
        System.out.println(this.getName() + "は" + this.getWeapon() + "で攻撃！" + target.getName() + "に25のダメージを与えた！");
        target.setHp(target.getHp() - 25);
    }
}