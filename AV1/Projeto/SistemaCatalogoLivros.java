import java.util.Scanner;
import java.util.ArrayList;

public class SistemaCatalogoLivros {

	private CatalogoLivros catalogoLivros;

	private Scanner teclado;

	public SistemaCatalogoLivros() {
		catalogoLivros = new CatalogoLivros();
		teclado = new Scanner(System.in);
	}

	public void iniciarSistema() {
		int op = -1;
		while(op != 0){
			op = menuPrincipal();
			switch(op){
			case 1:
				adicionarLivro();
				break;
			case 2:
				catalogoLivros.imprimirLivros();
				break;
			case 3:
				removerLivro();
				break;
			case 0:
				System.out.println("Finalizando o sistema");
				break;
			default:
				System.out.println("Opcao invalida");
				break;
			}
		}
	}

	private void removerLivro() {
		catalogoLivros.imprimirLivros();
		
		System.out.print("Informe o livro que deseja excluir: ");
		int posicao = Integer.parseInt(teclado.nextLine());
		
		catalogoLivros.remover(posicao - 1);
	}

	private void adicionarLivro() {
		Livro novoLivro = new Livro();
		
		System.out.print("Informe o resumo do Livro: ");
		novoLivro.setResumo(teclado.nextLine());
		System.out.println();
		
		System.out.print("Informe o titulo do Livro: ");
		novoLivro.setTitulo(teclado.nextLine());
		System.out.println();
		
		System.out.print("Informe o Autor do Livro: ");
		novoLivro.setAutor(teclado.nextLine());
		System.out.println();
		
		System.out.print("Informe o Numero de Paginas do Livro: ");
		novoLivro.setNumPaginas(Integer.parseInt(teclado.nextLine()));
		System.out.println();
		
		ArrayList<String> asPalavras = new ArrayList<String>();
		String sPalavraChave;
		
		int iAcao = 1;
		while (iAcao == 1) {
			System.out.print("\nInforme a Palavra Chave do Livro: ");
			sPalavraChave = teclado.nextLine();
			
			if (sPalavraChave == "0")
				break;
			
			asPalavras.add(sPalavraChave);
			System.out.println();
			
			System.out.print("Deseja continuar inserindo Palavras-chave? (1 - Sim | 0 - Nao) ");
			iAcao = Integer.parseInt(teclado.nextLine());
		}
		
		novoLivro.setPalavrasChave(asPalavras);
		catalogoLivros.adicionar(novoLivro);
	}

	public int menuPrincipal() {
		System.out.println("---------------MENU-----------------");
		System.out.println("  1 - Adicionar Livro");
		System.out.println("  2 - Imprimir Livros");
		System.out.println("  3 - Remover livro (por posicao)");
		System.out.println("  0 - Sair");
		System.out.println("------------------------------------");
		System.out.println("Digite opcao:");
		int op = Integer.parseInt(teclado.nextLine());
		return op;
	}
}
