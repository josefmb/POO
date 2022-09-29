import arcade
import os

from tiro import Tiro

from constantes import TAMANHO_DO_TIRO, MOVIMENTACAO_DA_NAVE

DIRETORIO_ATUAL = os.path.dirname(os.path.abspath(__file__))

class Nave(arcade.Sprite):
    def __init__(self, imagem, zoom, esquerda, direita):
        super().__init__(imagem, zoom) 

        self.movimentacaoEsquerda = esquerda
        self.movimentacaoDireita  = direita
        self.center_y             = 123
        self.center_x             = 400
        self.contadorDeTiros      = 10
    
    def on_key_press(self, key, modifiers):
        if key == self.movimentacaoEsquerda:
            self.change_x = -MOVIMENTACAO_DA_NAVE
        elif key == self.movimentacaoDireita:
            self.change_x = MOVIMENTACAO_DA_NAVE
        elif key == arcade.key.SPACE and self.contadorDeTiros > 0:
            self.removeTiro()
            return self.atira()
                
    def on_key_release(self, key, modifiers):
        if key == self.movimentacaoEsquerda:
            self.change_x = 0
        elif key == self.movimentacaoDireita:
            self.change_x = 0 

    def atira(self):
        TIRO = Tiro(DIRETORIO_ATUAL + "/img/tiro.png", TAMANHO_DO_TIRO, self.center_x, self.top)
        return TIRO

    def removeTiro(self):
        self.contadorDeTiros -= 1
    
    def adicionaTiros(self):
        self.contadorDeTiros += 13
