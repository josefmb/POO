public class Fibonacci {
    public static void main(String[] args){
        calculaFibonacci(10);
    }

    private static void calculaFibonacci(int iNumero) {
        int a = 0;
        int b = 1;
        int c = 0;
        
        for (int idx = 0; idx < iNumero; ++idx) {
            System.out.println(a);

            c = a + b;
            a = b;
            b = c;
        }
    }
}
