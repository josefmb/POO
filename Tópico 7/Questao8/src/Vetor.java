package Questao8.src;

import java.util.ArrayList;

public class Vetor extends Object implements Cloneable {
    public ArrayList<String> aVetor = new ArrayList<String>();

    @Override
    public Vetor clone() throws CloneNotSupportedException {
        return this;
    }

    public boolean equals(Vetor vetor) {
        return aVetor.equals(vetor.aVetor);
    }
}
