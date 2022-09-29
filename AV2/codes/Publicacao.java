public abstract class Publicacao implements Imprimivel {

	private String m_sTitulo;
	private String m_sAutor ;
	private int    m_iAno   ;
	
	public Publicacao(String sTitulo, String sAutor, int iAno) {
		this.m_sTitulo = sTitulo;
		this.m_sAutor  = sAutor ;
		this.m_iAno    = iAno   ;
	}

	public void setTitulo(String sTitulo) {
		this.m_sTitulo = sTitulo;
	}

	public String getTitulo() {
		return this.m_sTitulo;
	}

	public void setAutor(String sAutor) {
		this.m_sAutor = sAutor;
	}

	public String getAutor() {
		return this.m_sAutor;
	}

	public void setAno(int iAno) {
		this.m_iAno = iAno;
	}

	public int getAno() {
		return this.m_iAno;
	}
}
