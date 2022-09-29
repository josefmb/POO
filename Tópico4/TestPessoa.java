public class TestPessoa {
    public static void main(String[] args) {
        Estudante.cursoMatriculado = "ADS";

        Estudante estudante = new Estudante();
        estudante.nome = "Josef";
        estudante.rg = 2222222;

        Professor.departamento = "TI";

        Professor professor = new Professor();
        professor.nome = "Romulo";
        professor.rg = 1111111;

        System.out.println("Estudante: ");
        estudante.mostrarDetalhes();

        System.out.println("Professor: ");
        professor.mostrarDetalhes();
    }
}
