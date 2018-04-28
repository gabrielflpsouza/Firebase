package gabriel.app.firebase.Models;

public class Questao {
    public int idQuestao;
    public String enunciadoQuestao;
    public String altCerta;
    public String alt1;
    public String alt2;
    public String alt3;
    public int ano;
    public String universidade;

    public Questao(int idQuestao, String enunciadoQuestao, String altCerta, String alt1, String alt2, String alt3, int ano, String universidade) {
        this.idQuestao = idQuestao;
        this.enunciadoQuestao = enunciadoQuestao;
        this.altCerta = altCerta;
        this.alt1 = alt1;
        this.alt2 = alt2;
        this.alt3 = alt3;
        this.ano = ano;
        this.universidade = universidade;
    }
}
