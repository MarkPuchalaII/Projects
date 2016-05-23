from math import *
def cosine(x):
    return cos(radians(x))

def sine(x):
    return sin(radians(x))

def aCosine(x):
    return degrees(acos(x))



def aSine(x):
    return degrees(asin(x))

def cosSide(a,b,C): #find side c using SSA
    return round(sqrt(a**2 + b**2 -( 2 * a * b * cosine(C))),2)

def cosAngle(a,b,c): #Find angle a using SSS
    return round(aCosine((b**2 + c**2 - a**2) / (2*b*c)),1)

def sinSide(A,B,a): #find side c using AAS
    return round((a * sine(B))/(sine(A)),2)

def aSinSide(a,b,A):
    return round(aSine((b * sine(A))/a),2)

def sinAngle(a,b,c): #Find angle a using SSS
    return round(aCosine((b**2 + c**2 - a**2) / (2*b*c)),1)


#
# Computing ENTIRE Triangles
#

def sas(a,b,C):
    c =  cosSide(a,b,C)
    A = cosAngle(a,b,c)
    print(' first side: ', c, '\n',
          'first angle: ', A, '\n',
          'second angle: ', 180-C-A, '\n')

def sss(a,b,c):
    print(' first angle: ', cosAngle(a,b,c), '\n',
          'second angle: ', cosAngle(b,a,c), '\n',
          'third  angle: ', cosAngle(c,a,b), '\n')

def aas(A,B,a):
    print('First angle: ', 180-A-B, '\n',             #Angle C
          'First Side: ', sinSide(A,B,a), '\n',       #Side b
          'Second side: ', sinSide(A,180-A-B,a),'\n') # Side c

def asa(A,b,C):
    B = 180 - A - C
    print('First angle: ', B, '\n',             # Angle B
          'First Side: ', sinSide(B,A,b), '\n', # Side a
          'Second side: ', sinSide(B,C,b),'\n') # Side c

def ssaOneTriangle(a,b,A):
    B = aSinSide(a,b,A)
    C = 180-A-B
    c = sinSide(A,C,a)
    print (' First Angle', B, '\n', # Angle B
           'Second Angle', C, '\n', # Angle C
           'First Side', c, '\n',) # Side c

def ssaTwoTriangles(a,b,A):

    ssaOneTriangle(a,b,A)
    B = 180 - aSinSide(a,b,A)
    C = 180-A-B
    c = sinSide(A,C,a)
    print ('OR')
    print (' First Angle', B, '\n', # Angle B
           'Second Angle', C, '\n', # Angle C
           'First Side', c, '\n',) # Side c

def ssa(a,b,A):
    h = b * sine(A)

    if a >= b:
        print ('One Triangle')
        ssaOneTriangle(a,b,A)
        return 1
    elif h < a and a < b:
        print ('Two Triangles')
        ssaTwoTriangles(a,b,A)
        return 2
    elif a < h:
        print ('no triangles')
        return 0
    elif a == h:
        print ('One right triangle')
        return 90
    else:
        print ('What the hell did you do?')
        return 666

def correct(angle, speed, time, destination):
    # a =                   A = angle   D =         d =
    # b =  speed * time     B =         E =         e =
    # c =  destination - f  C =         F =         f = destination - c
    b = speed * time
    c = cosSide(destination,b,angle)
    A = cosAngle(destination,b,c)

    D = round(180-A,1)

    print("Correct angle by ", D, "degrees")
    print("Distance to destination:",c)
    print("Time Left: ",round(c/speed,1))

def area(a,C,b):
    return round((a * b * sine(C) / 2),2)

def bearing(ab,ac,bc):
    A = 180-ab-ac
    B = ab-bc
    C = 180 - A - B
    print("Angle A: ", round(A,2), "\n",
          "Angle B: ", round(B,2), "\n",
          "Angle C: ", round(C,2), "\n",)

def quad(a,b,c):
    A = round((-b+sqrt(b**2-4*a*c))/(2*a),2)
    B = round((-b-sqrt(b**2-4*a*c))/(2*a),2)
    print("It's",A,"\n",
          "Or..",B,"\n",)
def evaluate(a,b,c,x):
    result = (a*(x**2)) + (b*x) + (c)
    print(result)

def parametric():
    t = 0
    while t < 361:
        x = round(t-7,2)
        y = round(sqrt(t),2)
        
        print("t:",t/45,"x:",x,"y:",y,"\n",)
        t += 45
