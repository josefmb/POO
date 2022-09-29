public class Estudante extends Pessoa{
    static String cursoMatriculado;

    public String getCursoMatriculado(){
        return cursoMatriculado;
    }

    public void mostrarDetalhes(){ 
        super.mostrarDetalhes();
        System.out.println("CursoMatriculado:"+cursoMatriculado);
    }
}