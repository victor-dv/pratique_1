package views;

import models.Events;
import models.Users;
import models.enums.CategoryEvents;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EventView {
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Users registerUserMenu() {
        System.out.println("--- BEM-VINDO! REGISTRE-SE PRIMEIRO ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        return new Users(email, nome, cidade);
    }

    public int showMenu() {
        System.out.println("\n=== MENU DE EVENTOS ===");
        System.out.println("1. Cadastrar Novo Evento");
        System.out.println("2. Consultar Eventos Disponíveis");
        System.out.println("3. Participar de um Evento");
        System.out.println("4. Meus Eventos (Visualizar/Cancelar)");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opcao: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public Events createEventFormMenu() {
        System.out.println("\n--- CADASTRAR NOVO EVENTO ---");
        System.out.print("Nome do Evento: ");
        String nameEvent = scanner.nextLine();
        System.out.print("Endereco: ");
        String addressEvent = scanner.nextLine();

        System.out.println("Categorias: SHOW, ESPORTE, FESTA, TEATRO, PALESTRA");
        System.out.print("Digite a categoria: ");
        CategoryEvents categoryEvents = CategoryEvents.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Horario (formato dd/MM/yyyy HH:mm): ");
        String timeStr = scanner.nextLine();
        LocalDateTime timeEvents = LocalDateTime.parse(timeStr, formatter);

        System.out.print("Descricao: ");
        String description = scanner.nextLine();

        return new Events(nameEvent, addressEvent, categoryEvents, timeEvents, description);
    }

    public void displayEvents(List<Events> events, boolean showStatus) {
        if (events.isEmpty()) {
            System.out.println("Nenhum evento listado.");
            return;
        }
        for (int i = 0; i < events.size(); i++) {
            Events events1 = events.get(i);
            String status = "";

            if (showStatus) {
                if (events1.isHappeningNow()) status = " [OCORRENDO AGORA!]";
                else if (events1.hasPassed()) status = " [JA OCORREU]";
                else status = " [EM BREVE]";
            }

            System.out.printf("[%d] %s | %s | %s%s\n",
                    i, events1.getTimeEvent().format(formatter), events1.getNameEvent(), events1.getCategoryEvents(), status);
        }
    }

    public int askForEventIndex(String message) {
        System.out.print(message + " (ou -1 para voltar): ");
        return scanner.nextInt();
    }

    public void showMessage(String messge) {
        System.out.println("-> " + messge);
    }
}