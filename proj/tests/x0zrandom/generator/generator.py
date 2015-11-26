#!/bin/python2
# -*- coding: utf-8 -*-
import random

strs = ["Comboios", "SÃO", "\t\rUma\tgrande\r\t", "m"+"e"*100, "LDA.$%!%@# %@! ^!:\"E>!\"E>e21>ED:@!", "   t0d4 4 g3nt3 sabe que c4arr0s s40 + fixes  __ "]

'''
    Gera um numero com base na sua frequencia definida na funcao de distribuicao
'''
def randomIntProbInit(dist):
    realDist = []
    for i in range(0, len(dist)):
        realDist.extend([i]*dist[i])
    return realDist

def getRandomIntFromDist(dist):
    return dist[random.randint(0, len(dist)-1)]

'''
Gera um sequencia de numero aleatorios que e um input valido e que apenas fecha
o ficheiro passadas n chamadas (na teoria)
'''
def generator03(fid):
    random.seed(fid)
    f = open("../"+fid+".in", "w")
    for i in range(0, 10000):
        f.write(str(random.randint(1,11)));
        f.write("\n")
    for i in range(0,1000):
        f.write("0\n")
    f.close()

'''
Faz o mesmo que a versao 3, mas apenas corre alguns testes especificos para ajudar
a perceber quais a funcoes que falham.
Mais especificamente gera sempre os numeros de 0 a 5, e os de 6 a max gera
consoante o seu bit estiver ativo no numero n
'''
def generator04(n, fid):
    possible = [str(x) for x in [1,2,3,4,5,6,7,8,9,10,11]]
    random.seed(fid)
    f = open("../"+fid+".in", "w")
    for i in range(0, 10000):
        target = random.randint(0,len(possible)-1);
        if (('{0:08b}'.format(n))[::-1][target-6] == "1"): #se no bitset o bit do numero estiver ativo
            f.write(possible[target]);
        f.write("\n")
    for i in range(0,1000):
        f.write("0\n")
    f.close()

'''
Faz o mesmo que a versao 4, mas com uma funcao de distribuicao para incluir o 0
'''
def generator05(n, fid):
    possible = [2] + [5]*11
    random.seed(fid)
    dist = randomIntProbInit(possible);
    f = open("../"+fid+".in", "w")
    for i in range(0, 10000):
        target = getRandomIntFromDist(dist);
        if (target <= 6 or (('{0:08b}'.format(n))[::-1][target-6] == "1")): #se no bitset o bit do numero estiver ativo
            f.write(str(target));
        f.write("\n")
    for i in range(0,1000):
        f.write("0\n")
    f.close()

'''
Faz um teste de forma inteligente, apenas a parte das seccoes
'''

def generator06(n, fid):
    zerocnt=0;
    random.seed(fid)
    f = open("../"+fid+".in", "w")
    #Corre os testes de forma inteligente
    depth = 0
    #1) Com probabilidade 1/10 tenta abre o ficheiro antes de fazer 8
    if (random.randint(1,10)==1):
        f.write("2\n")
        f.write("input.test06\n")
        f.write("4\n")
    depth = 1;
    f.write("8\n")
    for i in range(0, 20000):
        target = random.randint(0,11)
        if (target == 0):
            zerocnt += 1
            if (zerocnt%3==0):
                f.write("0\n")
        else:
            f.write(str(target)+"\n")


        if (target in [4,5,6,7,8,9,10,11]):
            f.write(str(random.randint(0,3)) + "\n")
        if (target in [1,5,6,8,9,10]):
            f.write(strs[random.randint(0,len(strs)-1)] + "\n")

    for i in range(0,100):
        f.write("0\n3\ninput.test06\n")
    f.close()

def generateAll03():
    for i in range(1,100):
        generator03("X0-003-"+str(i).zfill(2))

def generateAll04():
    for i in range(1,100):
        generator04(i, "X0-004-"+str(i).zfill(2))

def generateAll05():
    for i in range(1,100):
        generator05(i, "X0-005-"+str(i).zfill(2))

def generateAll06():
    for i in range(1,100):
        generator06(i, "X0-006-"+str(i).zfill(2))

def generateAll():
    print "Gerando testes: esta linha vai falhar em python3 (usa python 2.7+ para que o RNG seja o mesmo que o original)"
    generateAll03()
    generateAll04()
    generateAll05()
    generateAll06()

generateAll();
