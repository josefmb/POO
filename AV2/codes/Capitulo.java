public class Capitulo extends DivisaoTextual {

    public Capitulo(String sTitulo, String sTexto) {
        super(sTitulo, sTexto);
    }

    public void setCapitulo(Capitulo capitulo) {
        this.setTitulo(capitulo.getTitulo());
        this.setTexto (capitulo.getTexto ());
    }

    public String getInfoCapitulo() {
        return this.getTitulo() + " : " + this.getTexto();
    }
}
