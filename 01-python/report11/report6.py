import math

"""このコードは、iris.dataの中身を読み込み平均値と標準偏差を算出する。

このコードは以下の順序で実行される。
１）iris.dataの中から要素を抜き出す。
２）抜き出した要素の平均を求める。
３）抜き出した要素の標準偏差を求める。

"""

sepal_length = []
sepal_width = []
petal_length = []
petal_width = []

def ave(num):
	"""この関数は平均値を求める。
	
	要素を含んだlist型の変数を入れ、
	その要素の平均値を返す。
	
	>>> ave([1,2,3,4,5])
	3.0
	
	"""
	
	sum_ave = 0
	
	for ave in num:
		sum_ave += ave#要素を全て足していく。

	ave = sum_ave / len(num)#合計を要素数で割り、平均値を算出する。
	
	return ave

def sta_dev(num):
	"""この関数は標準偏差を求める。
	
	要素を含んだlist型の変数を入れ、
	その要素の標準偏差を返す。
	
	>>> sta_dev([7,7,7,7,7,7,7])
	0.0
	
	"""
	sum_sta_dev = 0
	
	for sta_dev in num:
		sum_sta_dev += (sta_dev - ave(num))**2#要素１つに対して平均値で引く。それを二乗したものを足してゆく。
	
	sta_dev = math.sqrt(sum_sta_dev/len(num))#上述のものを要素数で割る。それを平方根に入れる。
	
	return sta_dev

for data in open("iris.data").read().split():#ひとまず１文ずつに分ける。
    data = data.split(',')#一文に分けたものを要素ごとに区切る。
    sepal_length.append(float(data[0]))
    sepal_width.append(float(data[1]))
    petal_length.append(float(data[2]))
    petal_width.append(float(data[3]))

print ('sepal_length	:  average  =  {0},  standard deviation  =  {1}'.format(ave(sepal_length),sta_dev(sepal_length)))
print ('sepal_width	:  average  =  {0},  standard deviation  =  {1}'.format(ave(sepal_width),sta_dev(sepal_width)))
print ('petal_length	:  average  =  {0},  standard deviation  =  {1}'.format(ave(petal_length),sta_dev(petal_length)))
print ('petal_width	:  average  =  {0},  standard deviation  =  {1}'.format(ave(petal_width),sta_dev(petal_width)))

if __name__ == '__main__':
    import doctest
    doctest.testmod()