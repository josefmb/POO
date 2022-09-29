public class Pessoa {
    private String   m_sNome   ;
    private Endereco m_Endereco;

    public Pessoa(String sNome, Endereco endereco) {
        this.m_sNome    = sNome   ;
        this.m_Endereco = endereco;
    }

    public void setNome(String sNome) {
        this.m_sNome = sNome;
    }

    public String getNome() {
        return this.m_sNome;
    }

    public void setEndereco(Endereco endereco) {
        this.m_Endereco = endereco;
    }

    public Endereco getEndereco() {
        return this.m_Endereco;
    }
 }
