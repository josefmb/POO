package Questao4.src;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Soma: " + getSoma(1, 2, 3));
        System.out.println("Soma: " + getSoma(4, 5));
        System.out.println("Soma: " + getSoma(6, 7, 8, 9));
    }

    public static int getSoma(int ... iNumeros) {
        
        int iSoma = 0;

        for (int iNumeroAtual : iNumeros) {
            iSoma += iNumeroAtual;
        }

        return iSoma;
    }

}
