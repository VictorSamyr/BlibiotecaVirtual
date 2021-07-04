public class Usuario {

    private int idUsuario;
    private String nome;
    private String login;
    private String sexo;
    private String email;
    private int idade;
    private String[] preferencia;
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
    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    // Login
    public String getLogin(){
        return this.login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    //Sexo
    public String getSexo(){
        return this.sexo;
    }

    public void setSexo(String novoSexo){
        this.sexo = novoSexo;
    }
    //E-mail
    public String getEmail(){
        return this.email;
    }

    public void setEmail(String novoEmail){
        this.email = novoEmail;
    }

    //Idade
    public int getIdade(){
        return this.idade;
    }

    public void setIdade(int novaIdade){
        this.idade = novaIdade;
    }

    //Preferência
    public String[] getPreferencia(){
        return this.preferencia;
    }

    public void setPreferencia(String[] novaPreferencia){
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

