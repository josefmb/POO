import java.io.File;

public class ListDir {
    public static void main(String[] agrs){

        File diretorio = new File(".");
        String[] aArquivos = diretorio.list(); 
    
        for (String sArquivo : aArquivos) {
            System.out.println(sArquivo);
        }
    }
}
