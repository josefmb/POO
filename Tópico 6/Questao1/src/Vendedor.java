public class Vendedor extends Funcionario {

    private double m_dComissao = 0;
    
    public Vendedor(String sNome, String sMatricula, double dSalarioBase, double dComissao) {
        super(sNome, sMatricula, dSalarioBase);

        m_dComissao = dComissao;
    }

    public double calculaSalario() {
        return getSalarioBase() + m_dComissao;
    }
}
