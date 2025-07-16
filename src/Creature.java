// Creature.java
public interface Creature {
    /**
     * 生存しているかを確認する。
     * @return true 生存している場合、false 死亡している場合
     */
    boolean isAlive();

    /**
     * 現在の状態（名前、HPなど）を表示する。
     */
    void showStatus();

    /**
     * 指定されたターゲットに攻撃を行う。
     * @param target 攻撃対象のCreature
     */
    void attack(Creature target);

    /**
     * クリーチャーの名前を取得する。
     * @return クリーチャーの名前
     */
    String getName();

    /**
     * クリーチャーの現在のHPを取得する。
     * @return クリーチャーのHP
     */
    int getHp();

    /**
     * クリーチャーのHPを設定する。
     * @param hp 設定するHPの値
     */
    void setHp(int hp);
}