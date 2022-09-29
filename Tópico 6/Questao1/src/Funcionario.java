public abstract class Funcionario {

    private String m_sNome           ;
    private String m_sMatricula      ;
    private double m_dSalarioBase = 0;

    public Funcionario(String sNome, String sMatricula, double dSalarioBase) {
        this.m_sNome        = sNome       ;
        this.m_sMatricula   = sMatricula  ;
        this.m_dSalarioBase = dSalarioBase;
    }

    public abstract double calculaSalario();

    public void setNome(String sNome) {
        this.m_sNome = sNome;
    }

    public String getNome() {
        return this.m_sNome;
    }

    public void setMatricula(String sMatricula) {
        this.m_sMatricula = sMatricula;
    }

    public String getMatricula() {
        return this.m_sMatricula;
    }

    public void setSalarioBase(double dSalarioBase) {
        this.m_dSalarioBase = dSalarioBase;
    }

    public double getSalarioBase() {
        return this.m_dSalarioBase;
    }
}
