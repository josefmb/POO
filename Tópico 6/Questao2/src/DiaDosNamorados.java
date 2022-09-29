public class DiaDosNamorados extends CartaoWeb {
    
    public DiaDosNamorados(String sDestinatario) {
        super(sDestinatario);
    }

    public void showMessage() {
        System.out.println("Querida(o) " + getDestinatario() + "\nFeliz Dia dos Namorados!\n");
    }
}
