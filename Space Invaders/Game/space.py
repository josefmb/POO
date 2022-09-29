import random
import arcade
import math
import os

from constantes  import *
from naveInimiga import NaveInimiga
from base        import Base
from nave        import Nave
from boss        import Boss

DIRETORIO_ATUAL = os.path.dirname(os.path.abspath(__file__))

class Jogo(arcade.Window):
    def __init__(self):
        super().__init__(SCREEN_WIDTH, SCREEN_HEIGHT, SCREEN_TITLE)
       
        self.vidaBase = 100

        self.listaNave     = None
        self.listaInimigos = None
        self.listaBoss     = None
        self.listaTiros    = None
        self.playerSprite  = None
        self.listaTiroBoss = None
        
        self.vivo = True
        
        self.pontuacao       = 0
        self.contagemRanking = 0

        self.contadorInimigo = 0
       
        self.set_mouse_visible(False)

        self.tempo    = 0.0
        self.segundos = 0
        self.segAux   = 0
        self.minutos  = 0
        
        self.QUANTIDADE_DE_INIMIGOS = 1
        self.qtdNovosInimigosHorda  = 1
        self.contNovosInimigos      = 0
        self.contBoss               = 0
        self.contTiroBoss           = 0
        self.contVidaPlayer         = 3

        self.horda     = 0
        self.contHorda = 0
        self.highScore = 0

    def setup(self):
        self.listaNave      = arcade.SpriteList()
        self.listaInimigo   = arcade.SpriteList()
        self.listaTiro      = arcade.SpriteList()
        self.listaBoss      = arcade.SpriteList()
        self.listaTirosBoss = arcade.SpriteList()
        
        self.background = arcade.load_texture(DIRETORIO_ATUAL + "/img/fundo.jpg") 

        self.playerSprite = Nave(DIRETORIO_ATUAL + "/img/nave.png",
                                 TAMANHO_DA_NAVE, arcade.key.LEFT, arcade.key.RIGHT)
                                
        self.listaNave.append(self.playerSprite)

        self.statusJogo = RODAR_JOGO

        self.instructions = []

        texture = arcade.load_texture(DIRETORIO_ATUAL + "/img/GameOver.png")
        self.instructions.append(texture)
    
    def drawInstructionsPage(self, pageNumber):
        pageTexture = self.instructions[pageNumber]
        arcade.draw_texture_rectangle(SCREEN_WIDTH // 2, SCREEN_HEIGHT // 2,
                                      pageTexture.width, pageTexture.height, pageTexture, 0)
           
    def draw_game_over(self):
        self.drawInstructionsPage(0)

        output = f"{self.pontuacao}"
        arcade.draw_text(output, 590, 505, arcade.color.WHITE, 30)

        output = f" {self.highScore}"
        arcade.draw_text(output, 655, 161, arcade.color.WHITE, 25)

    def salvar(self):
        self.contagemRanking += 1

        arquivoScore = open(DIRETORIO_ATUAL + "/dados.txt", 'a')

        linha = str(self.pontuacao) + "\n"

        arquivoScore.write(linha)
        arquivoScore.close()
        
    def ranking(self):
        arquivoScore = open(DIRETORIO_ATUAL + "/dados.txt", 'r')
        aPalavras = []

        for linha in arquivoScore:
            linha = linha.strip("\n")
            aPalavras.append(linha)
                
        arquivoScore.close()

        lista = [float(i) for i in aPalavras]

        self.highScore = max(lista)

    def on_draw(self):
        arcade.start_render()
        arcade.draw_texture_rectangle(SCREEN_WIDTH // 2, SCREEN_HEIGHT // 2,
                                      SCREEN_WIDTH, SCREEN_HEIGHT, self.background)

        if self.statusJogo == RODAR_JOGO: 
            self.draw_game()
        else: #game over
            self.draw_game     ()
            self.draw_game_over()

        if self.statusJogo == RODAR_JOGO:
            self.minutos  = int(self.tempo) // 60
            self.segundos = int(self.tempo) % 60
           
            outputPontuacao  = f"Sua pontuação: {self.pontuacao}"
            outputHorda      = f"Horda: {self.horda:02d}"
            outputTempo      = f"Tempo jogando: {self.minutos:02d}:{self.segundos:02d}" 
            outputVidaBase   = f"Base: {self.vidaBase:02d}%"
            outputTiros      = f"Tiros disponíveis: {self.contadorDeTiros:02d}"
            outputVidaPlayer = f"vida: {self.contVidaPlayer:02d}"

            arcade.draw_text(outputPontuacao , 10 , 20 , arcade.color.WHITE, 14) 
            arcade.draw_text(outputHorda     , 680, 576, arcade.color.WHITE, 14)
            arcade.draw_text(outputTempo     , 10 , 576, arcade.color.WHITE, 14) 
            arcade.draw_text(outputVidaBase  , 680, 20 , arcade.color.WHITE, 14) 
            arcade.draw_text(outputTiros     , 350, 576, arcade.color.WHITE, 14) 
            arcade.draw_text(outputVidaPlayer, 350, 13 , arcade.color.WHITE, 14) 
      
    def draw_game(self):
        self.listaInimigo  .draw()
        self.listaTiro     .draw()
        self.listaNave     .draw()
        self.listaBoss     .draw()
        self.listaTirosBoss.draw()
        
    def on_mouse_press(self, x, y, button, modifiers):
        if self.statusJogo == GAME_OVER:
            self.QUANTIDADE_DE_INIMIGOS = 1
            self.statusJogo = RODAR_JOGO

            self.vivo            = True
            self.horda           = 0
            self.pontuacao       = 0
            self.tempo           = 0
            self.contagemRanking = 0
            self.contVidaPlayer  = 3

            self.contadorDeTiros = self.playerSprite.contadorDeTiros
            Base.adicionaVidaBase(self)
        
        self.setup()
            
    def on_key_press(self, key, modifiers):
        if self.vivo == True:
            for player in self.listaNave:
                verificador = player.on_key_press(key, modifiers)
                if verificador is not None:
                    self.listaTiro.append(verificador) 
           
    def on_key_release(self, key, modifiers):
        for player in self.listaNave:
            player.on_key_release(key, modifiers)
    
    def update(self, delta_time):
        if self.contVidaPlayer <= 0:
            self.vivo = False
        
        if self.vivo == False:
            if self.contagemRanking < 1:
                self.salvar()

            self.statusJogo = GAME_OVER

        if self.vivo == True and self.statusJogo == RODAR_JOGO:
            self.tempo += delta_time
            self.ranking()

            if self.playerSprite.center_x < 35:
                self.playerSprite.center_x = 35

            if self.playerSprite.center_x > 765:
                self.playerSprite.center_x = 765

            self.contadorDeTiros = self.playerSprite.contadorDeTiros
            
            for nave in self.listaInimigo:
                if nave.center_y < 20:
                    nave.kill()
                    self.vidaBase = Base.setVidaBase(self)
                    print(self.vidaBase)
                    self.vivo = Base.validaVidaBase(self)
                    
            if int(self.segundos) != 0 and int(self.segundos) != 20 and +\
            int(self.segundos) != 40 and self.vivo == True:

                if int(self.segundos) % 4 == 0:
                    self.contadorInimigo   = 0
                    self.contHorda         = 0
                    self.contNovosInimigos = 0 
                    self.contBoss          = 0

                if int(self.segundos) % 5  == 0:
                    while self.contHorda < 1:
                        self.horda += 1
                        self.contHorda += 1
                               
                    while self.QUANTIDADE_DE_INIMIGOS > self.contadorInimigo: 
                        naveInimiga = NaveInimiga(DIRETORIO_ATUAL + "/img/naveInimiga.png", 
                                                  TAMANHO_DA_NAVE_INIMIGA)

                        sobreposicao = [1]
                        while len(sobreposicao) != 0:
                            naveInimiga.center_x = random.randrange(SCREEN_WIDTH) 
                            naveInimiga.center_y = random.randrange(480, SCREEN_HEIGHT) 
                            sobreposicao         = arcade.check_for_collision_with_list(
                                                   naveInimiga, self.listaInimigo)
                        
                        self.listaInimigo.append(naveInimiga) 
                        self.contadorInimigo += 1 
                        
                        if int(self.segundos) % 15 == 0:
                            if self.contNovosInimigos < 1:
                                self.QUANTIDADE_DE_INIMIGOS += self.qtdNovosInimigosHorda 
                                self.contNovosInimigos += 1
                                self.playerSprite.adicionaTiros()    
                    
                            while self.contBoss < 1:
                                self.contBoss += 1
                                boss = Boss(DIRETORIO_ATUAL + "/img/boss.png", TAMANHO_DA_NAVE_INIMIGA) 
                                self.listaBoss.append(boss)
                                
                self.segAux = self.segundos
    
            self.listaInimigo  .update()
            self.listaTiro     .update()
            self.listaNave     .update()
            self.listaBoss     .update()
            self.listaTirosBoss.update()

            for TIRO in self.listaTiro:
                TIRO_ACERTADO      = arcade.check_for_collision_with_list(TIRO, self.listaInimigo)
                TIRO_ACERTADO_BOSS = arcade.check_for_collision_with_list(TIRO, self.listaBoss   )

                for naveInimiga in TIRO_ACERTADO:
                    if naveInimiga.center_y > 135:
                        naveInimiga.kill()
                        self.pontuacao += 1

                        TIRO.kill()

                if len(TIRO_ACERTADO_BOSS) > 0:
                    TIRO.kill()

                for boss in TIRO_ACERTADO_BOSS:
                    boss.kill()
                    self.pontuacao += 10

                if TIRO.bottom > self.width or TIRO.top < 0 or TIRO.right < 0 or TIRO.left > self.width:
                    TIRO.kill()

            for boss in self.listaBoss:
                start_x = boss.center_x
                start_y = boss.center_y

                dest_x = self.playerSprite.center_x
                dest_y = self.playerSprite.center_y

                x_diff = dest_x - start_x
                y_diff = dest_y - start_y

                angle = math.atan2(y_diff, x_diff)
                boss.angle = math.degrees(angle) - 90
                    
                self.contTiroBoss += 1
                    
                if self.contTiroBoss % 60 == 0:
                    tiroBoss = arcade.Sprite(DIRETORIO_ATUAL + "/img/tiroBoss.png")

                    tiroBoss.center_x = start_x
                    tiroBoss.center_y = start_y

                    tiroBoss.angle    = math.degrees(angle)
                    tiroBoss.change_x = math.cos    (angle) * 3.5
                    tiroBoss.change_y = math.sin    (angle) * 3.5

                    self.listaTirosBoss.append(tiroBoss)

            for tiroBoss in self.listaTirosBoss:
                TIRO_ACERTADO_PLAYER = arcade.check_for_collision_with_list(tiroBoss, self.listaNave)
                
                for self.playerSprite in TIRO_ACERTADO_PLAYER: 
                    tiroBoss.kill()
                    self.contVidaPlayer -= 1
                               
def main():
    game = Jogo()

    game.setup()
    arcade.run()

main()
