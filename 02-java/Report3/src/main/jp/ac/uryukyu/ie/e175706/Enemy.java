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
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }
}