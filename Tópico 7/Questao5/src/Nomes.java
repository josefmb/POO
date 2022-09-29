package Questao5.src;

import java.util.LinkedList;

public class Nomes {
    private LinkedList<String> m_aNomes = new LinkedList<String>();

    public void setNomes(String ... sNomes) {
        for (String sNomeAtual : sNomes) {
            if (verificaNomeNaLista(sNomeAtual))
                continue;

            m_aNomes.add(sNomeAtual);
        }
    }

    private boolean verificaNomeNaLista(String sNomeParaVerificar) {
        for (String sNome : m_aNomes) {
            if (sNome.equals(sNomeParaVerificar))
                return true;
        }

        return false;
    }

    public String localizaNome(String sNome) {
        String sRetorno = "Nome nao encontrado!";

        for (int idx = 0; idx < m_aNomes.size(); ++idx) {
            if (m_aNomes.get(idx).equals(sNome))
                sRetorno = "Posicao: " + (idx + 1) + ", Nome: " + sNome;
        } 

        return sRetorno;
    }
}
