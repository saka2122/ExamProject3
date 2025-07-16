// Character.java
public abstract class Character implements Creature {
    protected String name;
    protected int hp;

    public Character(String name, int hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("初期設定に誤りがあるため、キャラクターを作成できませんでした");
        }
        this.name = name;
        setHp(hp); // setHpを使って初期化することで、負の値がセットされないようにする
    }

    @Override
    public final boolean isAlive() {
        return this.hp > 0;
    }

    @Override
    public void showStatus() {
        System.out.println(this.name + "：HP " + this.hp);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0; // HPが0未満にならないようにする
        } else {
            this.hp = hp;
        }
    }

    @Override
    public abstract void attack(Creature target);
}
