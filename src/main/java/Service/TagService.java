package Service;

import java.util.List;
import model.User;

public interface TagService {
    List<String> getTagForItem(User user) throws InterruptedException;
}
