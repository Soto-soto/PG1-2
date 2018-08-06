//モードの振り分けからの書き出し
public class WordSort// extends TxtControl
{
	String filename = null;
	String[] word;
	TxtControl tc;
	
	public WordSort(String filename)
	{
		this.filename = filename;
		tc = new TxtControl(filename);
	}
	
	public void firstSort(String memo)
	{
		System.out.println("-------------------------------------");
		
		switch (mode(memo))
		{
			case -1:
				//readモード
				System.out.println("リードモード\n-------------------------------------");
				System.out.println(tc.readTxt());
				break;
			case 0:
				//writeモード
				System.out.println("ライトモード\n-------------------------------------");
				tc.writeTxt(word[0]);
				System.out.println(tc.readTxt());
				break;
			case 1:
				//search(タグを検索)モード
				System.out.println("検索するタグ"+word[1]);
				System.out.println("タグ検索モード\n-------------------------------------");
				System.out.println(searchtag(word[1]));
				break;
			case 2:
				//deleteモード
				//未実装
				break;
			case 3:
				//searchtag（タグの一覧表示）モード
				//未実装
				break;
		}
		System.out.println("-------------------------------------");
	}
	
	//モードの切り替えを行う関数
	public int mode(String memo)
	{
		if(memo.equals(""))
			return -1;
		
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
	
	public String searchtag(String tagname)
	{
		String[] memotag = tc.readTxt().split("\n");
		String[] materials;
		String memo = "";
		
		for(int i = 0;i < memotag.length;i++)//メモ１つ１つ調べる
		{
			materials=memotag[i].split(" ");//それぞれのメモを半角空白で区切る
				for(int j = 0;j < materials.length;j++)//タグが２つ以上ある場合も考える
				{
					if(materials[j].equals(tagname))//探してるタグと一致した場合
						memo += memotag[i] + "\n";//memoに加える。
				}
		}
		return memo;
	}
}