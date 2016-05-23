from math import sqrt



def foil(x,y):
    a=x*x
    b=2*(x*y)
    if b == 1:
        b=''
    c=y*y
    if c < 1:
        for each in range(0,10000):
            if c*each == 1:
                c = '1/'+str(each)
    print(str(a)+'x^2+'+str(b)+'x+'+str(c))

def quadratic(a,b,c):
    determinant=(b**2)-(4*a*c)
    if determinant < 0:
        print('no real solutions')
        print('solution1:' + str(-b) + ' + \/' + str(determinant) + '/' + str(2*a))
        print('solution2:' + str(-b) + ' - \/' + str(determinant) + '/' + str(2*a))
    else:
        solution1 = (-b + sqrt(determinant))/(2*a)
        solution2 = (-b - sqrt(determinant))/(2*a)
        return(solution1,solution2)

def findC(a,b):
    c = (b/(2*a))**2
    print('c = ' + str(c))

def factor(a,b,c):
    for each in range(a,b):
        test = each * (each - a)
        if test == c:
            return(each,each-9)
    if test != c:
        print('failed at ' + str(test))

def pointEquation(x1,y1,x2,y2):
    '''Find a slope-equationtwo values, '''
    #change in y / change in x
    my = y2 - y1
    mx = x2 - x1
    #y-intercept
    by = (y1*x1)-(my*x1)
    bx = (y1*x1)-(mx*x1)
    print('y = ' + str(my) + '/' + str(mx) + 'x' + ' + ' + str(by) + '/' + str(bx))

def slopeIntercept(x,my,mx,by,bx):
    y = (my/mx)*x + (by/bx)
    print(y)

'''************************************************************************
***************************************************************************
** Determine which of the given points are on the graph of the equation: **
**                         Equation: x^2+y^2=2                           **
**                           Points: (1,-1),(-1,0),(1,1)                 **
***************************************************************************
************************************************************************'''

class onTheGraph():
    def determine():
        print('Determine which of the given points are on the graph of the equation:')
        equation = input('Equation: ')
        points = int(input('how many points?'))
        output('3')
        pointsList = []
        for each in range(0,points):
            if each <1:
                pointsList.append(input('First point: '))
            else:
                pointsList.append(input('next point: '))

        print('\nEquation: ',equation)
        print('points: ',end='')
        for each in range(points):
            if each < (points-1):
                print(pointsList[each],', ',end='')
            else: print(pointsList[each])
        onTheGraph.compute(equation)

    def compute(equation):
        print(equation)

def output(output):
    return(output)


'''************************************************************************
***************************************************************************
**                        Graphing Functions:                            **
**         If a > 0, graph opens up; If a < 0, graph opens down          **
**              Find a Vertex (h,k): h = -b/2a; k = f(-b/2a)             **
**                    Points: (1,-1),(-1,0),(1,1)                        **
***************************************************************************
************************************************************************'''
class graphing():
    def vertex(function):
        read(function)
        return('(',h(function),',',k(function),')')
    
    def h(function):
        read(function)
        return(-(b/(2*a)))
    
    def k(function):
        h = h(function)
        read(h)
        solve(h)
        
    def read(function):
        return(function)


'''************************************************************************
***************************************************************************
**                        Figuring out i                                 **
**    Just type i(x) to compute i^x                                      **
**    This function is for quickly simplifying i to any power.           **
***************************************************************************
************************************************************************'''

def i(x):
    x %= 4
    result = 'i^'+str(x)
    if x == 1: result += '=  i'
    if x == 2: result += '=   -1'
    if x == 3: result += '=     -i'
    if x == 0:
        result = result[:-1] + '4=        1'
    return result

'''*****************************
***      Rate of Change      ***
***                          ***
***  Delta(y)     f(b)-f(a)  ***
***  --------  =  ---------  ***
***  Delta(x)        b-a     ***
*****************************'''
