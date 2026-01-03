public class Contato {
    private Integer id;
    private String nome;
    private Telefone numTelefone;


    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getNumTelefone(){
        return numTelefone.getNumTelefone();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumTelefone(Telefone numTelefone) {
        this.numTelefone = numTelefone;
    }

    public static boolean nomeValido(String nome) {
        return nome != null &&
                nome.matches("[a-zA-ZÀ-ÿ ]+") &&
                nome.length() > 3;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                " | Nome: " + nome +
                " | Numero de Telefone: " + getNumTelefone();
    }

}
