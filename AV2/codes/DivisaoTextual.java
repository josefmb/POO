public abstract class DivisaoTextual {

    private String m_sTitulo;
    private String m_sTexto ;

    public DivisaoTextual(String sTitulo, String sTexto) {
        this.m_sTitulo = sTitulo;
        this.m_sTexto  = sTexto ;
    }

    public void setTitulo(String sTitulo) {
        this.m_sTitulo = sTitulo;
    }

    public String getTitulo() {
        return this.m_sTitulo;
    }

    public void setTexto(String sTexto) {
        this.m_sTexto = sTexto;
    }

    public String getTexto() {
        return this.m_sTexto;
    }
}