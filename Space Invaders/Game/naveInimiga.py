import arcade

class NaveInimiga(arcade.Sprite):
    def __init__(self, imagem, zoom):
        super().__init__(imagem, zoom)

    def update(self):
        self.center_y -= 1
        
    def kill(self):
        self.remove_from_sprite_lists()
