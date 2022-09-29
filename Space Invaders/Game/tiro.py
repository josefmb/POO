import arcade
from constantes import VELOCIDADE_DO_TIRO

class Tiro(arcade.Sprite):
    def __init__(self, imagem, zoom, centerX, localDeSaida):
        super().__init__(imagem, zoom)

        self.angle    = 90
        self.center_x = centerX
        self.top      = localDeSaida

    def locomoveTiro(self):
        self.top += VELOCIDADE_DO_TIRO
        return self.top

    def update(self):
        self.locomoveTiro()
