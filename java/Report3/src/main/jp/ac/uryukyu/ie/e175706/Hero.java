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

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    @Override
    public void wounded(int damage)
    {
        setHitPoint(getHitPoint() - damage);
        if( getHitPoint() < 0 )
        {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }
}
