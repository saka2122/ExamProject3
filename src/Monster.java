// Monster.java
public abstract class Monster implements Creature {
    protected String name;
    protected int hp;
    protected char suffix;

    public Monster(char suffix, int hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("初期設定に誤りがあるため、モンスターを作成できませんでした");
        }
        this.suffix = suffix;
        setHp(hp);
    }

    @Override
    public final boolean isAlive() {
        return this.hp > 0;
    }

    @Override
    public void showStatus() {
        System.out.println(this.name + this.suffix + "：HP " + this.hp);
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
            this.hp = 0; // HPが0未満にならないようにする じゃないと負の値が出てしまう？とにかくエラー出たから調整。
        } else {
            this.hp = hp;
        }
    }

    // suffixのgetter
    public char getSuffix() {
        return suffix;
    }

    @Override
    public abstract void attack(Creature target);
}