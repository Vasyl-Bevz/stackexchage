package Service;

import java.util.List;
import model.User;

public interface UserService {
    boolean isUserAnswerCountMoreThen(User user, int count);
    boolean isUserInLocation(User user, String[] locations);
    User addTags(User user, List<String> tags);

}
