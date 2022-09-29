import java.util.ArrayList;
import java.util.Scanner;

public class SistemaBiblioteca {

	private Biblioteca biblioteca;
	private Scanner    teclado   ;

	public SistemaBiblioteca() {
		biblioteca = new Biblioteca();
		teclado    = new Scanner(System.in);
	}

	public void iniciarSistema(){
		int op = -1;
		while(op != 0) {
			op = menuPrincipal();

			switch(op) {
				case 1:
					adicionarPublicacao();
					break;

				case 2:
					biblioteca.listarAcervo();
					break;

				case 3:
					imprimirPublicacao();
					break;

				case 0:
					System.out.println("Finalizando o sistema");
					break;

				default:
					System.out.println("Opção inválida");
					break;
			}
		}
	}

	private void imprimirPublicacao() {
		if (biblioteca.getQuantidadeLivros() > 0) {
			System.out.println("Digite a posição: ");
			int pos = Integer.parseInt(teclado.nextLine());

			biblioteca.imprimirItem(biblioteca.getPublicacao(pos - 1));
		} else {
			System.out.println("\nNão há publicações cadastradas!\n");
		}
	}

	private void adicionarPublicacao() {
		int op = -1;

		do {
			op = menuPublicacao();

			switch(op) {
				case 1:
					adicionarLivro();
					break;

				case 2:
					adicionarArtigo();
					break;

				default:
					System.out.println("Opção inválida");
					break;
			}

		} while(!(op == 1 || op ==2 ));
	}

	private void adicionarArtigo() {
		System.out.println("Informe o Titulo do Artigo ");
		String sTitulo = teclado.nextLine();

		System.out.println("Informe o autor do Artigo ");
		String sAutor = teclado.nextLine();

		System.out.println("Informe o ano do Artigo: ");
		int iAno = Integer.parseInt(teclado.nextLine());

		ArrayList<Secao> aSecoes = new ArrayList<Secao>(adicionarSecoes());

		Artigo artigo = new Artigo(sTitulo, sAutor, iAno, aSecoes);
		biblioteca.adicionar(artigo);		
	}

	private ArrayList<Secao> adicionarSecoes() {
		ArrayList<DivisaoTextual> aDivisao = new ArrayList<DivisaoTextual>();
		adicionarDivisaoTextual(aDivisao, false);

		ArrayList<Secao> aSecoes = new ArrayList<Secao>();
		for (DivisaoTextual divisaoTextual : aDivisao) {
			Secao secao = new Secao(divisaoTextual.getTitulo(), divisaoTextual.getTexto());
			aSecoes.add(secao);
		}

		return aSecoes;
	}

	private void adicionarLivro() {
		System.out.println("Informe o Titulo do Livro ");
		String sTitulo = teclado.nextLine();

		System.out.println("Informe o autor do Livro ");
		String sAutor = teclado.nextLine();

		System.out.println("Informe o ano do Livro: ");
		int iAno = Integer.parseInt(teclado.nextLine());

		ArrayList<Capitulo> aCapitulos = new ArrayList<Capitulo>(adicionarCapitulos());

		Livro livro = new Livro(sTitulo, sAutor, iAno, aCapitulos);
		biblioteca.adicionar(livro);
	}

	private ArrayList<Capitulo> adicionarCapitulos() {

		ArrayList<DivisaoTextual> aDivisao = new ArrayList<DivisaoTextual>();
		adicionarDivisaoTextual(aDivisao, true);

		ArrayList<Capitulo> aCapitulos = new ArrayList<Capitulo>();
		for (DivisaoTextual divisaoTextual : aDivisao) {
			Capitulo capitulo = new Capitulo(divisaoTextual.getTitulo(), divisaoTextual.getTexto());
			aCapitulos.add(capitulo);
		}

		return aCapitulos;
	}

	private void adicionarDivisaoTextual(ArrayList<DivisaoTextual> aDivisaoTextual, boolean bEhCapitulo) {
		int iAcao = 1;

		String sTitulo;
		String sTexto ;

		while (iAcao == 1) {
			System.out.print("Informe o titulo do ");
			System.out.println((bEhCapitulo == true) ? "capítulo: " : "seção: ");
			sTitulo = teclado.nextLine();

			System.out.print("Informe o texto do ");
			System.out.println((bEhCapitulo == true) ? "capítulo: " : "seção: ");
			sTexto = teclado.nextLine();

			if (bEhCapitulo == true) {
				Capitulo capitulo = new Capitulo(sTitulo, sTexto);
				aDivisaoTextual.add(capitulo);
			} else {
				Secao secao = new Secao(sTitulo, sTexto);
				aDivisaoTextual.add(secao);
			}

			System.out.print("Deseja continuar? (1 - Sim | 0 - Nao) ");
			iAcao = Integer.parseInt(teclado.nextLine());
		}
	}
		
	public int menuPrincipal() {
		System.out.println("---------------MENU-----------------");
		System.out.println("  1 - Adicionar Publicação"          );
		System.out.println("  2 - Listar Acervo"                 );
		System.out.println("  3 - Imprimir Publicação"           );
		System.out.println("  0 - Sair"                          );
		System.out.println("------------------------------------");
		System.out.println("Digite opção:"                       );

		int op = Integer.parseInt(teclado.nextLine());

		return op;
	}

	public int menuPublicacao() {
		System.out.println("---------------MENU-----------------");
		System.out.println("  1 - Adicionar Livro"               );
		System.out.println("  2 - Adicionar Artigo"              );
		System.out.println("------------------------------------");
		System.out.println("Digite opção:"                       );

		int op = Integer.parseInt(teclado.nextLine());

		return op;
	}
}
