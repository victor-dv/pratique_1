package models.repository;

import models.Events;
import models.enums.CategoryEvents;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventsRepository {
    private final String FILE_NAME = "events.data";

    public void save(Events events) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println(events.toFileString());

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar no arquivo: " + e.getMessage(), e);
        }
    }

    public List<Events> loadAll() {
        List<Events> events = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return events;

        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                Events event = new Events(
                        data[0],
                        data[1],
                        CategoryEvents.valueOf(data[2]),
                        LocalDateTime.parse(data[3]),
                        data[4]
                );
                events.add(event);
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar eventos: O arquivo pode estar corrompido.");
        }
        return events;
    }

}
