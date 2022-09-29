import java.lang.String;
import java.util.ArrayList;;

public class Livro {
	private String sResumo    ;
	private String sTitulo    ;
	private String sAutor  	  ;
	private int    iNumPaginas;
	
	private ArrayList<String> asPalavrasChave = new ArrayList<String>();
	
	public void setResumo(String sResumo) {
		this.sResumo = sResumo;
	}
	
	public String getResumo() {
		return sResumo;
	}
	
	public void setTitulo(String sTitulo) {
		this.sTitulo = sTitulo;
	}
	
	public String getTitulo() {
		return sTitulo;
	}
	
	public void setAutor(String sAutor) {
		this.sAutor = sAutor;
	}
	
	public String getAutor() {
		return sAutor;
	}
	
	public void setNumPaginas(int iNumPaginas) {
		this.iNumPaginas = iNumPaginas;
	}
	
	public int getNumPaginas() {
		return iNumPaginas;
	}
	
	public void setPalavrasChave(ArrayList<String> asPalavrasChave) {
		this.asPalavrasChave = asPalavrasChave;
	}
	
	public ArrayList<String> getPalavrasChave() {
		return asPalavrasChave;
	}

}
