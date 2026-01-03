public class Contato {
    private Integer id;
    private String nome;
    private Telefone telCelular;
    private Telefone telCasa;

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getTelCelular(){
        return telCelular.getNumTelefone();
    }

    public String getTelCasa(){
        return telCasa.getNumTelefone();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelCelular(Telefone telCelular) {
        this.telCelular = telCelular;
    }

    public void setTelCasa(Telefone telCasa) {
        this.telCasa = telCasa;
    }
}
