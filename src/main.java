import controllers.EventController;
import models.repository.EventsRepository;
import views.EventView;

public class main {
    public static void main(String[] args) {
        EventView view = new EventView();
        EventsRepository repository = new EventsRepository();
        controllers.EventController controller = new EventController(view, repository);

        controller.start();
    }
}
