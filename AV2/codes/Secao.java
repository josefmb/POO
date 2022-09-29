public class Secao extends DivisaoTextual {
    
    public Secao(String sTitulo, String sTexto) {
        super(sTitulo, sTexto);
    }

    public void setSecao(Secao secao) {
        this.setTitulo(secao.getTitulo());
        this.setTexto (secao.getTexto ());
    }

    public String getInfoSecao() {
        return this.getTitulo() + " : " + this.getTexto();
    }
}
