import java.util.ArrayList;

public class Livro extends Publicacao {

    private ArrayList<Capitulo> m_aCapitulos = new ArrayList<Capitulo>();

    public Livro(String sTitulo, String sAutor, int iAno, ArrayList<Capitulo> aCapitulos) {
        super(sTitulo, sAutor, iAno);
        this.m_aCapitulos = aCapitulos;
    }

    public void setCapitulos(ArrayList<Capitulo> aCapitulos) {
        this.m_aCapitulos = aCapitulos;
    }

    public ArrayList<Capitulo> getCapitulos() {
        return m_aCapitulos;
    }

    public void imprimir() {
        System.out.println("\nTitulo: " + this.getTitulo());
        System.out.println("Autor: "    + this.getAutor ());
        System.out.println("Ano: "      + this.getAno   ());

        if (this.getCapitulos().size() == 0)
            return;

        System.out.println("Capítulos: ");

        for (Capitulo capitulo : this.getCapitulos()) {
            System.out.println("Titulo do capítulo: " + capitulo.getTitulo());
            System.out.println("Texto do capítulo: "  + capitulo.getTexto ());
        }
    }
}
