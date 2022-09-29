package Questao8.src;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vetor vetor1 = new Vetor();
        Vetor vetor1Clone = new Vetor();

        ArrayList<String> aArray = new ArrayList<>();
        ArrayList<String> aArrayClone = new ArrayList<>();

        vetor1.aVetor.add("Joao");
        vetor1Clone = vetor1.clone();
        vetor1.aVetor.add("Marcelo");

        if (vetor1Clone == vetor1)
            System.out.println("Clone sobreescrito é a mesma instância");

        if (vetor1Clone.equals(vetor1))
            System.out.println("Clone tem o mesmo conteúdo");

        aArray.add("Carol");
        aArrayClone = (ArrayList<String>) aArray.clone();
        aArray.add("Jorge");

        if (aArray != aArrayClone)
            System.out.println("São instâncias diferentes");

        if (!aArray.equals(aArrayClone))
            System.out.println("Não tem o mesmo conteudo");
    }
}
