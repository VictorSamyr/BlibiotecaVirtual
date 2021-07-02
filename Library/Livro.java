public class Livro {

    private int idLivro;
    private String genero;
    private int anoLancamento;
    private int isbn;
    private String sinopse;
    private String autor;

    //Gets e Sets

    //ID


    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int novoIdLivro) {
        this.idLivro = novoIdLivro;
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

    // ISBN
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int novoIsbn) {
        this.isbn = novoIsbn;
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
}
