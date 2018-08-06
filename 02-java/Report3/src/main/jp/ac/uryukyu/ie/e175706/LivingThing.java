package jp.ac.uryukyu.ie.e175706;
/**
 * ヒーロークラスとエネミークラスの親クラス。
 * 下の変数に与えられているものは
 * String name; //名前
 * int maximumPoint; //HP
 * int attack; //攻撃力
 * boolean dead; //生死状態。true=死亡。
 * を所持し、子クラスへと継承している。
 */
public class LivingThing
{
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public int getHitPoint()
    {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint)
    {
        this.hitPoint = hitPoint;
    }

    public void setDead(boolean dead)
    {
        this.dead = dead;
    }

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 名
     * @param maximumHP HP
     * @param attack 攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack)
    {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public boolean isDead()
    {
        return dead;
    }

    public String getName()
    {
        return name;
    }

    /**
     * 攻撃する時のダメージ量を算出するメソッド。
     * ある程度ランダムなダメージ量を算出する。
     * @param LivingThing あらゆるデータを持ってくる。
     */
    public void attack(LivingThing LivingThing)
    {
        if (!isDead())
        {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, LivingThing.getName(), damage);
            LivingThing.wounded(damage);
        }
    }

    /**
     * 攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage)
    {
        hitPoint -= damage;
        if( hitPoint < 0 )
        {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
