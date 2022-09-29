import java.util.ArrayList;

public class Teste2 {
    public static void main(String[] args) throws Exception {
        ArrayList<CartaoWeb> aCartoes = new ArrayList<CartaoWeb>();

        DiaDosNamorados diaDosNamorados = new DiaDosNamorados("Maria");
        aCartoes.add(diaDosNamorados);

        Natal natal = new Natal("Natalina");
        aCartoes.add(natal);
        
        Aniversario aniversario = new Aniversario("Julia");
        aCartoes.add(aniversario);

        for (CartaoWeb cartaoWeb : aCartoes) {
            cartaoWeb.showMessage();
        }
    }
}
