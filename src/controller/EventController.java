package controllers;

import models.Events;
import models.Users;
import models.repository.EventsRepository;
import views.EventView;

import java.util.Comparator;
import java.util.List;

public class EventController {
    private EventView view;
    private EventsRepository repository;
    private Users currentUser;
    private List<Events> allEvents;

    public EventController(EventView view, EventsRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void start() {
        this.currentUser = view.registerUserMenu();

        this.allEvents = repository.loadAll();
        view.showMessage("Bem-vindo, " + currentUser.getNome() + "! Eventos carregados com sucesso.");

        int option;
        do {
            option = view.showMenu();
            switch (option) {
                case 1:
                    registerNewEvent();
                    break;
                case 2:
                    listEventsOrdered();
                    break;
                case 3:
                    participateInEvent();
                    break;
                case 4:
                    manageMyEvents();
                    break;
                case 0:
                    view.showMessage("Saindo do sistema. Até logo!");
                    break;
                default:
                    view.showMessage("Opção inválida.");
            }
        } while (option != 0);
    }

    private void registerNewEvent() {
        try {
            Events newEvent = view.createEventFormMenu();
            repository.save(newEvent);
            allEvents.add(newEvent);
            view.showMessage("Evento cadastrado com sucesso!");
        } catch (Exception e) {
            view.showMessage("Erro ao cadastrar evento. Verifique se digitou a data e categoria corretamente.");
        }
    }

    private void listEventsOrdered() {
        allEvents.sort(Comparator.comparing(Events::getTimeEvent));
        System.out.println("\n--- TODOS OS EVENTOS ---");
        view.displayEvents(allEvents, true);
    }

    private void participateInEvent() {
        listEventsOrdered();
        int index = view.askForEventIndex("\nDigite o ID do evento que deseja participar");

        if (index >= 0 && index < allEvents.size()) {
            Events selectedEvent = allEvents.get(index);
            if (currentUser.getEventsConfirmed().contains(selectedEvent)) {
                view.showMessage("Você já confirmou presença neste evento!");
            } else if (selectedEvent.hasPassed()) {
                view.showMessage("Você não pode participar de um evento que já ocorreu.");
            } else {
                currentUser.confirmEvent(selectedEvent);
                view.showMessage("Presença confirmada no evento: " + selectedEvent.getNameEvent());
            }
        }
    }

    private void manageMyEvents() {
        System.out.println("\n--- MEUS EVENTOS CONFIRMADOS ---");
        List<Events> myEvents = currentUser.getEventsConfirmed();
        view.displayEvents(myEvents, false);

        if (!myEvents.isEmpty()) {
            int index = view.askForEventIndex("Digite o ID para CANCELAR participacao");
            if (index >= 0 && index < myEvents.size()) {
                Events eventToCancel = myEvents.get(index);
                currentUser.cancelEvent(eventToCancel);
                view.showMessage("Participação cancelada com sucesso.");
            }
        }
    }
}