package Questao6.src;

public class Pessoa {
    private String m_sNome    ;
    private String m_sEmail   ;
    private String m_sTelefone;

    @Override
    public String toString() {
        return m_sNome + ", " + m_sEmail + ", " + m_sTelefone;
    }

    public Pessoa(String sNome, String sEmail, String sTelefone) {
        m_sNome     = sNome    ;
        m_sEmail    = sEmail   ;
        m_sTelefone = sTelefone;
    }

    public void setNome(String sNome) {
        m_sNome = sNome;
    }

    public String getNome() {
        return m_sNome;
    }

    public void setEmail(String sEmail) {
        m_sEmail = sEmail;
    }

    public String getEmail() {
        return m_sEmail;
    }

    public void setTelefone(String sTelefone) {
        m_sTelefone = sTelefone;
    }

    public String getTelefone() {
        return m_sTelefone;
    }
}
