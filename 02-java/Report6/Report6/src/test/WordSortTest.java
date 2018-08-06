//モードの振り分けからの書き出し
public class WordSortTest// extends TxtControl
{
	static String[] word;
	
	static TxtControlTest tc;
	
	public static void WordSortTest1(String filename)
	{
		tc = new TxtControlTest (filename);
	}	
	
	public static void main(String[] args)
	{
		WordSortTest1("メモ.txt");
		
		FirstSort("kaku #2");
		
		System.out.println(tc.readTxt()); 
	}
	
	public static void FirstSort(String memo)
	{
		int modenum = mode(memo);//モードを調べる
		
		System.out.println("mode"+modenum);//デバッグ（モードの表示）
		switch (modenum)
		{
			case 0:
				//writeモード
				System.out.println(word[0]+"\n");//デバッグ
				tc.writeTxt(word[0]);
				
				break;
			case 1:
				//search(タグを検索)モード
				//searchtag(word[1]);
				break;
			case 2:
				//deleteモード
				System.out.println(word[1]);
				break;
			case 3:
				//searchtag（タグの一覧表示）モード
				//serchtag();
				break;
		}
	}
	
	//モードの切り替えを行う関数
	public static int mode(String memo)
	{
		//モード一覧
		String[] modelist = new String[] {"search","delete","searchtag"};
		
		for(int i = 0;i < modelist.length;i++)//どのモードであるかを確かめる
		{
			word = memo.split(modelist[i] + " ");
			if (word[0].equals(""))
				return i + 1;
		}
		return 0;//writeモード
	}
	
	
	
}