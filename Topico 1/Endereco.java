public class Endereco {
    private String m_sRua   ;
    private int    m_iNumero; 

    public Endereco(String sRua, int iNumero) {
        this.m_sRua    = sRua   ;
        this.m_iNumero = iNumero;
    }

    public void setRua(String sRua) {
        this.m_sRua = sRua;
    }

    public String getRua() {
        return this.m_sRua;
    }

    public void setNumero(int iNumero) {
        this.m_iNumero = iNumero;
    }

    public int getNumero() {
        return this.m_iNumero;
    }
}