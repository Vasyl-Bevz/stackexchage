package Service;

import java.util.List;
import model.User;

public class UserServiceImpl implements UserService {
    @Override
    public boolean isUserAnswerCountMoreThen(User user, int count) {
        if (user.getAnswer_count() == null || user.getAnswer_count() >= 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isUserInLocation(User user, String[] locations) {
        if (user.getLocation() == null) {
            return false;
        }
        for (String location : locations) {
            if (user.getLocation().toLowerCase().contains(location)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User addTags(User user, List<String> tags) {
        user.setTags(tags);
        return user;
    }
}
