public class Natal extends CartaoWeb {
    
    public Natal(String sDestinatario) {
        super(sDestinatario);
    }

    public void showMessage() {
        System.out.println("Querida(o) " + getDestinatario() + "\nFeliz Natal!\n");
    }
}
