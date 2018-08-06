import java.nio.file.*;
import java.io.*;

public class TxtControlTest
{
    String txtdata = null;//全ての文章
    String file = null;//操作するファイル

    public TxtControlTest(String filename)
    {
        file = filename;
    }

    /*
    public static void main(String[] args)
    {
        //ちゃんと.txtを読み込めているか確認用
        readTxt();
        System.out.println(txtdata);
        
        //ちゃんと.txtに書き込めているか確認
        writeTxt("大丈夫。ちゃんと書き込まれてる");
        System.out.println(txtdata);
    }
    */

    public String readTxt()
    //txtファイルから文章を読み取る関数
    {
        txtdata = "";//初期化
        try
        {
            BufferedReader br = Files.newBufferedReader(Paths.get(file));
            String line = br.readLine();
            while (line != null)
            {
                txtdata += line+"\n";
                line=br.readLine();
            }
            br.close();
            return txtdata;
        }
        catch (NoSuchFileException e)
        {
            System.out.println("エラー：.txtファイルが存在しません");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "error";
    }

    public void writeTxt(String word)
    //txtファイルに文章を書き込む関数
    {
        readTxt();
        try
        {
            BufferedWriter bw = Files.newBufferedWriter(Paths.get(file));

            txtdata = word +"\n"+ txtdata;//上の行に追加
            //txtdata = txtdata += word;//下の行に追加
            bw.write(txtdata);
            bw.close();
        }
        catch (NoSuchFileException e)
        {
            System.out.println("エラー：.txtファイルが存在しません");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
