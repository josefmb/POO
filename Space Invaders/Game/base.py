import random

class Base():
    def __init__(self):
        self.vidaBase = 100
        self.vivo     = True

    def setVidaBase(self):
        self.vidaBase -= random.randrange(10, 20)
        return self.vidaBase

    def validaVidaBase(self):
        if self.vidaBase <= 0:
            return False
        else:
            return True

    def adicionaVidaBase(self):
        self.vidaBase = 100
