import java.util.ArrayList;

public class Biblioteca {

	private ArrayList<Publicacao> m_aPublicacoes = new ArrayList<Publicacao>();

	public int getQuantidadeLivros(){
		return m_aPublicacoes.size();				
	}

	public void adicionar(Publicacao novaPublicacao){
		m_aPublicacoes.add(novaPublicacao);
	}
	
	public Publicacao getPublicacao(int iItem){
		return m_aPublicacoes.get(iItem);
	}

	public void listarAcervo() {
		for (int idx = 0; idx < getQuantidadeLivros(); ++idx) {
			Publicacao publicacao = m_aPublicacoes.get(idx);

			if (publicacao instanceof Livro)
				System.out.print("Tipo: Livro ");
			else
				System.out.print("Tipo: Artigo ");

			System.out.println("Titulo: " + publicacao.getTitulo());
		}
	}

	public void imprimirItem(Imprimivel publicacao) {
		publicacao.imprimir();	
	}
}
