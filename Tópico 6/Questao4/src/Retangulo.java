public class Retangulo extends FiguraGeometrica {
    
    private float m_fLado   = 0;
    private float m_fAltura = 0;

    public Retangulo(float fLado, float fAltura) {
        this.m_fLado   = fLado  ;
        this.m_fAltura = fAltura;
    }

    public float calcularArea() {
        return this.m_fAltura * this.m_fLado;
    }

    public float calcularPerimetro() {
        return 2 * this.m_fAltura + 2 * this.m_fLado;
    }
}
