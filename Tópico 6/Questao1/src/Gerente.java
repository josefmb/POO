public class Gerente extends Funcionario {

    public Gerente(String sNome, String sMatricula, double dSalarioBase) {
        super(sNome, sMatricula, dSalarioBase);
    }

    public double calculaSalario() {
        return 2. * getSalarioBase();
    }
}
