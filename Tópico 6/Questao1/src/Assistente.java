public class Assistente extends Funcionario {

    public Assistente(String sNome, String sMatricula, double dSalarioBase) {
        super(sNome, sMatricula, dSalarioBase);
    }

    public double calculaSalario() {
        return getSalarioBase();
    }
}
