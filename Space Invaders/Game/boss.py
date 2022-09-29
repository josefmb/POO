import arcade 
import random

class Boss(arcade.Sprite):
    def __init__(self, imagem, zoom):
        super().__init__(imagem, zoom)

        self.center_x = random.randrange(800) 
        self.center_y = random.randrange(480, 600) 

    def update(self):
        self.center_y -= 1

    def kill(self):
        self.remove_from_sprite_lists()
