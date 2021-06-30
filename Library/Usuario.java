public class Usuario {

    private int idUsuario;
    private String nome;
    private char sexo;
    private String email;
    private int idade;
    private String preferencia;
    private String senha;

    //Gets e Sets

    //ID
    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int novoIdUsuario) {
        this.idUsuario = novoIdUsuario;
    }

    //Nome
    public String getnome() {
        return this.nome;
    }

    public void setnome(String novoNome) {
        this.nome = novoNome;
    }

    //Sexo
    public char getsexo(){
        return this.sexo;
    }

    public void setsexo(char novoSexo){
        this.sexo = novoSexo;
    }
    //E-mail
    public String getemail(){
        return this.email;
    }

    public void setemail(String novoEmail){
        this.email = novoEmail;
    }

    //Idade
    public int getidade(){
        return this.idade;
    }

    public void setidade(int novaIdade){
        this.idade = novaIdade;
    }

    //Preferência
    public String getPreferencia(){
        return this.preferencia;
    }

    public void setPreferencia(String novaPreferencia){
        this.preferencia = novaPreferencia;
    }

    //Senha
    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String novaSenha) {
        this.senha = novaSenha;
    }

}

