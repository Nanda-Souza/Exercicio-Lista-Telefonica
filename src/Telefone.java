public class Telefone {
    private String numTelefone;

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }

    public static boolean numTelValido(String numTelefone) {
        return numTelefone != null &&
                numTelefone.matches("\\d+") &&
                numTelefone.length() >= 9 &&
                numTelefone.length() <= 14;
    }

}