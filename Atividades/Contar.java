import java.util.Scanner;

public class Contar {

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite um número: ");
        
        int iNumero = Integer.parseInt(teclado.nextLine());

        for (int idx = 1; idx <= iNumero; ++idx) {
            System.out.print(idx + " ");
        }

        teclado.close();
    }
}