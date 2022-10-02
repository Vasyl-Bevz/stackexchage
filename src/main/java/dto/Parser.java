package dto;

import model.User;

public class Parser {
    public User itemToModel(ApiResponseItem item) {
        User user = new User();
        user.setUser_id(item.getUser_id());
        user.setAnswer_count(item.getAnswer_count());
        user.setLink(item.getLink());
        user.setLocation(item.getLocation());
        user.setProfile_image(item.getProfile_image());
        user.setReputation(item.getReputation());
        user.setQuestion_count(item.getQuestion_count());
        user.setDisplay_name(item.getDisplay_name());
        return user;
    }
}
