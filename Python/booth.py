def booth(m,r):
    print(' ',format(m))
    print('x',format(r))
    print('------')

def format(x):
    if len(str(x))==4:
        return str(x)
    else:
        return format('0'+str(x))
            
def binary(x):
    return(bin(x))
