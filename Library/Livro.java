import java.awt.image.BufferedImage;

public class Livro {

    private int idLivro;
    private String genero;
    private int anoLancamento;
    private long isbn;
    private String sinopse;
    private String autor;
    private BufferedImage imagem;

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
    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long novoIsbn) {
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

    // Imagem
    public BufferedImage getImagem(){
        return this.imagem;
    }

    public void setImagem(BufferedImage imagem){
        this.imagem = imagem;
    }
}
