import java.util.ArrayList;

public class Artigo extends Publicacao {
    
    private ArrayList<Secao> m_aSecoes = new ArrayList<Secao>();

    public Artigo(String sTitulo, String sAutor, int iAno, ArrayList<Secao> aSecoes) {
        super(sTitulo, sAutor, iAno);
        this.m_aSecoes = aSecoes;
    }

    public void setSecoes(ArrayList<Secao> aSecoes) {
        this.m_aSecoes = aSecoes;
    }

    public ArrayList<Secao> getSecoes() {
        return m_aSecoes;
    }

    public void imprimir() {
        System.out.println("\nTitulo: " + this.getTitulo());
        System.out.println("Autor: "    + this.getAutor ());
        System.out.println("Ano: "      + this.getAno   ());

        if (this.getSecoes().size() == 0)
            return;

        System.out.println("Seções: ");

        for (Secao secao : this.getSecoes()) {
            System.out.println("Titulo da seção: " + secao.getTitulo());
            System.out.println("Texto da seção: "  + secao.getTexto ());
        }
    }
}
