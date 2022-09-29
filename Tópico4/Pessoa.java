public class Pessoa{ 
    protected String nome;
    protected int rg;

    public String getNome(){
        return nome;
    }

    public void mostrarDetalhes(){
        System.out.println("Nome:"+nome); 
        System.out.println("RG:"+rg);
    }
}
