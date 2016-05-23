'''
    This is a collection logical operators for reference uses.
    Currently, each operator has:
      -  A Description
      -  A Truth Table
'''

'''
    Logical operators:
    Negation(not): [~]
    Conjunction(and): [^]
    Disjunction(or): [V]
    Material Implication(if.. then): [>]
    Biconditional(If, and only if): [=]
'''

#Negation
class negation:
    '''Negation (~):"is not"'''
    def truthTable():
        print('NEGATION:\n'+
              'p | ~p\n'+
              '------\n'+
              'T |  F\n'+
              'F |  T\n')

    def compose(p1,p2,p3,p4):
        r = ['','','','']
        p = [p1,p2,p3,p4]
        for each in range(0,len(p)):
            r[each] = negation.test(p[each])

        print('NEGATION:\n'+
              'p | ~p\n'+
              '-------------')
        for each in range(0,len(p)):
            print(p[each]+' | '+r[each])

    def test(p='T'):
        if p=='F': r = 'T'
        else: r = 'F'
        return(r)

    def premise(p='T'):
        print('~p:',negation.test(p))

#Conjunction
class conjunction:
    '''Conjunction (^): "Both are true"'''
    def truthTable():
        print('CONJUNCTION:\n'+
              'p   q | p . q\n'+
              '-------------\n'+
              'T   T |   T\n'+
              'T   F |   F\n'+
              'F   T |   F\n'+
              'F   F |   F\n')
    def compose(p1,q1,p2,q2,p3,q3,p4,q4):
        r1=conjuction.test(p1,q1)
        r2=conjuction.test(p2,q2)
        r3=conjuction.test(p3,q3)
        r4=conjuction.test(p4,q4)

        print('CONJUNCTION:\n'+
              'p   q | p ^ q\n'+
              '-------------\n'+
              p1+'   '+q1+' |   '+r1+'\n'+
              p2+'   '+q2+' |   '+r2+'\n'+
              p3+'   '+q3+' |   '+r3+'\n'+
              p4+'   '+q4+' |   '+r4+'\n')

    def test(p='T',q='T'):
        if p=='T' and q=='T': r = 'T'
        else: r = 'F'
        return(r)

    def premise(p='T',q='T'):
        print('p ^ q:',conjuction.test(p,q))



#Disjunction
class disjunction:
    '''Disjunction(V): "one or more is true"'''
    def truthTable():
        print('DISJUNCTION:\n'+
              'p   q | p v q\n'+
              '-------------\n'+
              'T   T |   T\n'+
              'T   F |   T\n'+
              'F   T |   T\n'+
              'F   F |   F\n')
    def compose(p1,q1,p2,q2,p3,q3,p4,q4):
        r1=disjunction.test(p1,q1)
        r2=disjunction.test(p2,q2)
        r3=disjunction.test(p3,q3)
        r4=disjunction.test(p4,q4)

        print('DISJUNCTION:\n'+
              'p   q | p v q\n'+
              '-------------\n'+
              p1+'   '+q1+' |   '+r1+'\n'+
              p2+'   '+q2+' |   '+r2+'\n'+
              p3+'   '+q3+' |   '+r3+'\n'+
              p4+'   '+q4+' |   '+r4+'\n')

    def test(p='T',q='T'):
        if p=='F' and q=='F': r = 'F'
        else: r = 'T'
        return(r)

    def premise(p='T',q='T'):
        print('p V q:',disjunction.test(p,q))


#Materiral Conditional
class conditional:
    '''Material Conditional (>): "if p is true, then q is also true" '''
    def truthTable():
        print('MATERIAL CONDITIONAL:\n'+
              'p   q | p > q\n'+
              '-------------\n'+
              'T   T |   T\n'+
              'T   F |   F\n'+
              'F   T |   T\n'+
              'F   F |   T\n')

    def compose(p1,q1,p2,q2,p3,q3,p4,q4):
        r1=conditional.test(p1,q1)
        r2=conditional.test(p2,q2)
        r3=conditional.test(p3,q3)
        r4=conditional.test(p4,q4)

        print('MATERIAL CONDITIONAL:\n'+
              'p   q | p > q\n'+
              '-------------\n'+
              p1+'   '+q1+' |   '+r1+'\n'+
              p2+'   '+q2+' |   '+r2+'\n'+
              p3+'   '+q3+' |   '+r3+'\n'+
              p4+'   '+q4+' |   '+r4+'\n')

    def test(p='T',q='T'):
        if p=='T' and q=='F': r = 'F'
        else: r = 'T'
        return(r)

    def premise(p='T',q='T'):
        print('p > q:',conditional.test(p,q))

#Biconditional
class biconditional:
    '''Biconditional (=): "both or neither"'''


    def truthTable():
        print('BICONDITIONAL:\n'+
              'p   q | p = q\n'+
              '-------------\n'+
              'T   T |   T\n'+
              'T   F |   F\n'+
              'F   T |   F\n'+
              'F   F |   T\n')

    def compose(p1,q1,p2,q2,p3,q3,p4,q4):
        r1=biconditional.test(p1,q1)
        r2=biconditional.test(p2,q2)
        r3=biconditional.test(p3,q3)
        r4=biconditional.test(p4,q4)

        print('BICONDITIONAL:\n'+
              'p   q | p = q\n'+
              '-------------\n'+
              p1+'   '+q1+' |   '+r1+'\n'+
              p2+'   '+q2+' |   '+r2+'\n'+
              p3+'   '+q3+' |   '+r3+'\n'+
              p4+'   '+q4+' |   '+r4+'\n')

    def test(p='T',q='T'):
        if((p=='T' and q=='T') or (p=='F' and q=='F')): r = 'T'
        else: r = 'F'
        return(r)

    def premise(p='T',q='T'):
        print('p = q:',biconditional.test(p,q))




def allTruthTables():
    for each in [negation,
                 conjunction,
                 disjunction,
                 conditional,
                 biconditional]:
        each.truthTable()


def composeAll(p1='T',q1='T',p2='T',q2='F',p3='F',q3='T',p4='F',q4='F'):
    negation.compose(p1,p2,p3,p4)
    for each in [conjunction,
                 disjunction,
                 conditional,
                 biconditional]:
        each.compose(p1,q1,p2,q2,p3,q3,p4,q4)


#operator classinition
#print Operator properties
#print( P Q // p V q \\ Validity \\ Contradiction)
#print( T T //   T   \\   Valid  \\      Yes     )
#print( T F //   T   \\   Valid  \\      Yes     )
#print( F T //   T   \\   Valid  \\      Yes     )
#print( F F //   F   \\   Valid  \\      Yes     )


#Print Operator for an equation
