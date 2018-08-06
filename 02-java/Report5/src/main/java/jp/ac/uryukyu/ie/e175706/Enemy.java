package jp.ac.uryukyu.ie.e175706;
/**
 * エネミークラス。継承しているためLivingThing要参照
 * 下の変数に与えられているものは
 * String name; //エネミーの名前（ここではスライム）
 * int maximumPoint; //エネミーのHP
 * int attack; //エネミーの攻撃力（現在は３）
 *
 * 加えてここでは見えないが
 * boolean dead; //エネミーの生死状態。true=死亡。
 * をエネミークラスは所持している。
 */
public class Enemy extends LivingThing
{
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack)
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
                if(Math.random() *100 < 30)
                {
                    damage = damage * 2;
                    System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName() , opponent.getName(),damage);
                }
                else
                {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                }
                opponent.wounded(damage);
                if( opponent.isDead())
                {
                    System.out.printf("%sは道半ばで力尽きてしまった。\n", opponent.getName());
                }
            }
        }
    }
}