//package jp.ac.uryukyu.ie.e175706;
public class Main
{
    public static void main(String[] args)
    {

        try
        {
            String str = "3．14";
            //変数strに3．14を代入。「．」は全角のピリオドである点に注意。
            Double.parseDouble(str);
            //strをdouble型に変換するメソッド。しかし「．」によりエラーが発生する。
        }

        catch (NullPointerException e)
        {
            System.out.println("NullPointerExceptionが発生しました。");
            //何のエラーが起こっているのかを出力する。この場合はNullPointerException
            System.out.println(e.getMessage());
        }
    }
}