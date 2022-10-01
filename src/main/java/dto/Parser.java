package dto;

import model.User;

public class Parser {
    public User itemToModel(ApiResponseItem item) {
        User user = new User();
        user.setUserId(item.getUser_id());
        user.setAnswerCount(item.getAnswer_count());
        user.setLinkAvatar(item.getLink());
        user.setLocation(item.getLocation());
        user.setLinkProfile(item.getLink());
        user.setReputation(item.getReputation());
        user.setQuestionCount(item.getQuestion_count());
        return user;
    }
}
