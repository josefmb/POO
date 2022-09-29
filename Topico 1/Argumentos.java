import java.math.BigInteger;
import java.util.Scanner;

public class Argumentos {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite um numero: ");

		int iFatorial = Integer.parseInt(teclado.nextLine());
		BigInteger iResultado = BigInteger.ONE;

		for (int idx = iFatorial; idx > 1; --idx) {
			iResultado = iResultado.multiply(BigInteger.valueOf(idx));
		}

		System.out.println("Fatorial de " + iFatorial + " = " + iResultado);
		teclado.close();
	}
}
