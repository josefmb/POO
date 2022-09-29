public class Circulo extends FiguraGeometrica {
    
    private float m_fRaio = 0;

    public Circulo(float fRaio) {
        m_fRaio = fRaio;
    }

    public float calcularArea() {
        double dRaio = this.m_fRaio;
        float  fArea = (float)(Math.PI * Math.pow(dRaio, 2));

        return fArea;
    }

    public float calcularPerimetro() {
        float fPerimetro = (float)(2 * Math.PI * this.m_fRaio);
        return fPerimetro;
    }
}
