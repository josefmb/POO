public class Aniversario extends CartaoWeb {

    public Aniversario(String sDestinatario) {
        super(sDestinatario);
    }

    public void showMessage() {
        System.out.println("Querida(o) " + getDestinatario() + "\nFeliz Aniversario!\n");
    }
}
