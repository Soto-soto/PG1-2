package jp.ac.uryukyu.ie.e175706;
/**
 * ヒーロークラス。継承しているためLivingThing要参照
 * 下の変数に与えられているものは
 * String name; //勇者の名前（ここでは勇者）
 * int maximumPoint; //勇者のHP
 * int attack; //勇者の攻撃力（現在は５）
 *
 * 加えてここでは見えないが
 * boolean dead; //勇者の生死状態。true=死亡。
 * をヒーロークラスは所持している。
 */
public class Hero extends LivingThing
{
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 勇者名
     * @param maximumHP 勇者のHP
     * @param attack 勇者の攻撃力
     */
    public Hero (String name, int maximumHP, int attack)
    {
        super(name, maximumHP, attack);
    }

    @Override
    public void attack(LivingThing opponent)
    {
        if(!isDead())
        {
            int damage = (int) (Math.random() * getAttack());
            if(damage==0)
            {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName() , opponent.getName());
            }
            else
            {
                if(Math.random() *100 < 40)
                {
                    damage = damage * 2;
                    System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName() , opponent.getName(),damage);
                }
                else
                {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                }
                opponent.wounded(damage);
            }
        }
    }
}