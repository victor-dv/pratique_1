package models;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private String email;
    private String nome;
    private String cityResidence;
    private List<Events> eventsConfirmed;

    public Users(String email, String nome, String cityResidence){
        this.email = email;
        this.nome = nome;
        this.cityResidence = cityResidence;
        this.eventsConfirmed = new ArrayList<>();
    }
    public boolean confirmEvent(Events events){
        return this.eventsConfirmed.add(events);
    }
    public boolean cancelEvent(Events events){
        return this.eventsConfirmed.remove(events);
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

    public List<Events> getEventsConfirmed() {
        return eventsConfirmed;
    }

    public void setEventsConfirmed(List<Events> eventsConfirmed) {
        this.eventsConfirmed = eventsConfirmed;
    }
}
