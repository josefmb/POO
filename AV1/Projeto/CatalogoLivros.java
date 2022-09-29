import java.util.ArrayList;

public class CatalogoLivros {
	private ArrayList<Livro> aLivros = new ArrayList<Livro>();
	
	public int getQuantidadeLivros() {
		return aLivros.size();				
	}
	
	
	public boolean adicionar(Livro novoLivro) {
		aLivros.add(novoLivro);
		return true;
	}
	
	public boolean remover(int posicao) {		
		aLivros.remove(posicao);
		return true;
	}
	
	public void imprimirDadosLivro(int i) {
		Livro livro = aLivros.get(i);
		
		System.out.println("\nResumo: "     + livro.getResumo    ());
		System.out.println("Titulo: "       + livro.getTitulo    ());
		System.out.println("Autor : "       + livro.getAutor     ());
		System.out.println("Num. Páginas: " + livro.getNumPaginas());
		
		for (String sPalavraChave : livro.getPalavrasChave()) {
			System.out.println("Palavra Chave: " + sPalavraChave);
		}
		
	}
	
	public void imprimirLivros() {
		for (int idxLivro = 0; idxLivro < getQuantidadeLivros(); ++idxLivro) {
			System.out.print("\nLivro ");
			System.out.print(idxLivro + 1);
			System.out.print(": ");
			imprimirDadosLivro(idxLivro);
			System.out.println();
		}
	}
	
}
