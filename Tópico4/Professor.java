public class Professor extends Pessoa{
    static String departamento;

    public String getDepartamento(){
        return departamento;
    }

    public void mostrarDetalhes(){ 
        super.mostrarDetalhes();
        System.out.println("Departamento: "+departamento);
    }
}