package Questao9e10.src;

public class App {
    public static void main(String[] args) throws Exception {
        int numero = 10;

        try {
            numero = numero / 0;
        }
        catch (Exception e) {
            System.out.println("Nao é possível dividir por 0");
            e.printStackTrace();
        }
    }
}
