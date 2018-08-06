#include <stdio.h>

int maxsort(int str[], int size);
void intprint(int str[], int size);

int maxsort(int str[], int size)
{
	int max;
	for (int i=0;i<size-1;i++)
	{
		for(int j=0;j<size-1;j++)//1-2,2-3,3-4,4-5番目を比べる
		{
			if(str[j]<str[j+1])
			{
				max=str[j+1];
				str[j+1]=str[j];
				str[j]=max;
			}
		}
	}
	intprint(str, size);
	return str[size];
}

void intprint(int str[], int size)
{
	for (int k=0;k<size;k++)
		printf("%d ",str[k]);
	printf("\n");
}


int main()
{
    const int SIZE = 6; //定数として配列のサイズを宣言                          
    int scores[SIZE] = {100, 60, 70, 100, 90, 80};
    int max;

	printf("初期値：");
	intprint(scores, SIZE);

	printf("結　果：");
	maxsort(scores, SIZE);

    return 0;
    
    
}