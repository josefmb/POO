package Questao6.src;

public class App {
    public static void main(String[] args) throws Exception {
        Pessoa pessoa = new Pessoa("Jorge", "jorge@gmail.com", "98899-1214");
        String sTeste = pessoa.toString();

        System.out.println("Pessoa em string: " + sTeste);
    }
}
