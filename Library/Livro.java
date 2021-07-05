public class Livro {

    private int idLivro;
    private String genero;
    private int anoLancamento;
    private String titulo;
    private String sinopse;
    private String autor;
    private String imagem;

    //Gets e Sets

    //ID


    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int novoIdLivro) {
        this.idLivro = novoIdLivro;
    }

    //Titulo
    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    // Gênero
    public String getGenero() {
        return genero;
    }

    public void setGenero(String novoGenero) {
        this.genero = novoGenero;
    }

    // Ano de lançamento
    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int novoAnoLancamento) {
        this.anoLancamento = novoAnoLancamento;
    }

    // Sínopse
    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String novaSinopse) {
        this.sinopse = novaSinopse;
    }

    // Autor
    public String getAutor() {
        return autor;
    }

    public void setAutor(String novoAutor) {
        this.autor = novoAutor;
    }

    // Imagem
    public String getImagem(){
        return this.imagem;
    }

    public void setImagem(String imagem){
        this.imagem = imagem;
    }
}
