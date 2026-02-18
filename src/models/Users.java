package models;


public class Users {
    private String email;
    private String nome;
    private String cityResidence;

    public Users(String email, String nome, String cityResidence){
        this.email = email;
        this.nome = nome;
        this.cityResidence = cityResidence;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCityResidence() {
        return cityResidence;
    }

    public void setCityResidence(String cityResidence) {
        this.cityResidence = cityResidence;
    }
}
