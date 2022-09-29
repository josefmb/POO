import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) throws Exception {
        ArrayList<Funcionario> aFuncionarios = new ArrayList<Funcionario>();

        Gerente gerente = new Gerente("Jorge", "102030", 1000);
        aFuncionarios.add(gerente);

        Assistente assistente = new Assistente("Cleber", "010203", 1000);
        aFuncionarios.add(assistente);

        Vendedor vendedor = new Vendedor("Marcinho", "112233", 1000, 200);
        aFuncionarios.add(vendedor);

        double dValorTotal = 0;
        for (Funcionario funcionario : aFuncionarios) {
            System.out.println("Funcionario: " + funcionario.getNome() + "\nSalario: " + funcionario.calculaSalario() + "\n");
            dValorTotal += funcionario.calculaSalario();
        }

        System.out.println("Valor Total: " + dValorTotal);
    }
}
