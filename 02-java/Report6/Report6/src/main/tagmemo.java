//created by Yuto Uechi

//Main

import java.util.Scanner;

public class tagmemo
{
    public static void main(String[] args)
    {
        String memo =null;
        WordSort ws = new WordSort("メモ.txt");
        Scanner scan = new Scanner(System.in);
        
        while(true)
        {
            System.out.println("メモしてね！検索は「search #タグ名」終了は「bye.」");
            
            memo = scan.nextLine();
            
            if(memo.equals("bye.") ==true)
                break;
            
            ws.firstSort(memo);
        }
    }
}