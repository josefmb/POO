public abstract class CartaoWeb {

    private String m_sDestinatario;

    public CartaoWeb(String sDestinatario) {
        this.m_sDestinatario = sDestinatario;
    }

    public abstract void showMessage();

    public void setDestinatario(String sDestinatario) {
        this.m_sDestinatario = sDestinatario;
    }

    public String getDestinatario() {
        return m_sDestinatario;
    }
}
