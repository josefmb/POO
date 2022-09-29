package Questao5.src;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();
        menu.teclado = new Scanner(System.in);

        Nomes nome = new Nomes();

        int iOpcao = 0;

        do {
            menu.exibirMenu();
            iOpcao = Integer.parseInt(menu.teclado.nextLine());

            switch (iOpcao) {
                case 1: 
                    System.out.println("Insira 0 para cancelar a ação: ");
                    String sNome = menu.teclado.nextLine();

                    while (!sNome.equals("0"))
                    {
                        nome.setNomes(sNome);
                        sNome = menu.teclado.nextLine(); 
                    }
                    break;

                case 2:
                    System.out.println(nome.localizaNome(menu.teclado.nextLine()));
                    break;

                default:
                    break;
            }
        } while (iOpcao != 0);
    }
}

