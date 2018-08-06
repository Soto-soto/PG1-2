def ave(x):
    b=0
    for a in x:
        b=b+a
    a=len(x)
    b=b/a
    return b

x=[1,2,3,4]
b2=ave(x)
print(b2)
