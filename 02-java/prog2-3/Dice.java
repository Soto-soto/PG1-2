package jp.ac.uryukyu.ie.pair25;

public class Dice
{
    private int value; //出目を保存する変数

    public Dice()
    {
        play();
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public void play()
    {
         value = (int)(Math.random()*6)+1;
    }
}