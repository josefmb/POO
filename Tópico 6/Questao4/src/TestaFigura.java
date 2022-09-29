import java.util.ArrayList;

public class TestaFigura {
    public static void main(String[] args) throws Exception {
        ArrayList<FiguraGeometrica> aFigurasGeometricas = new ArrayList<FiguraGeometrica>();

        Retangulo retangulo = new Retangulo(10, 5);
        aFigurasGeometricas.add(retangulo);

        Circulo circulo = new Circulo(5);
        aFigurasGeometricas.add(circulo);

        Quadrado quadrado = new Quadrado(7);
        aFigurasGeometricas.add((Retangulo)quadrado);

        for (FiguraGeometrica figuraGeometrica : aFigurasGeometricas) {
            System.out.println("Area: " + figuraGeometrica.calcularArea     () + "\nPerimetro: "
                                        + figuraGeometrica.calcularPerimetro() + "\n");
        }
    }
}
