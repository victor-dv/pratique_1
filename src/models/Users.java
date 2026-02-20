package models;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private String email;
    private String nome;
    private String cityResidence;
    private List<Events> eventsConfirmed;

    public Users(String email, String nome, String cityResidence) {
        this.email = email;
        this.nome = nome;
        this.cityResidence = cityResidence;
        this.eventsConfirmed = new ArrayList<>();
    }

    public boolean confirmEvent(Events events) {
        return this.eventsConfirmed.add(events);
    }

    public boolean cancelEvent(Events events) {
        return this.eventsConfirmed.remove(events);
    }


    public String getNome() {
        return nome;
    }

    public List<Events> getEventsConfirmed() {
        return eventsConfirmed;
    }
}
