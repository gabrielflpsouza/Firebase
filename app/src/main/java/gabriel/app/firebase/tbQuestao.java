package gabriel.app.firebase;

public class tbQuestao {
    private String enunciado;
    private String altCerta;
    private String alt1;
    private String alt2;
    private String alt3;
    private int ano;
    private String universidade;
    private String area;
    private String subarea;
    private String imagem;
    private String comentario;

    public tbQuestao(){}

    public tbQuestao(String enunciado, String altCerta, String alt1, String alt2, String alt3, int ano, String universidade, String area, String subarea, String imagem, String comentario) {
        this.enunciado = enunciado;
        this.altCerta = altCerta;
        this.alt1 = alt1;
        this.alt2 = alt2;
        this.alt3 = alt3;
        this.ano = ano;
        this.universidade = universidade;
        this.area = area;
        this.subarea = subarea;
        this.imagem = imagem;
        this.comentario = comentario;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getAltCerta() {
        return altCerta;
    }

    public void setAltCerta(String altCerta) {
        this.altCerta = altCerta;
    }

    public String getAlt1() {
        return alt1;
    }

    public void setAlt1(String alt1) {
        this.alt1 = alt1;
    }

    public String getAlt2() {
        return alt2;
    }

    public void setAlt2(String alt2) {
        this.alt2 = alt2;
    }

    public String getAlt3() {
        return alt3;
    }

    public void setAlt3(String alt3) {
        this.alt3 = alt3;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSubarea() {
        return subarea;
    }

    public void setSubarea(String subarea) {
        this.subarea = subarea;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
