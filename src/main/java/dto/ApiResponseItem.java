package dto;

import java.util.List;

public class ApiResponseItem {
    private Long user_id;
    private Long answer_count;
    private Long question_count;
    private Long reputation;
    private String location;
    private String display_name;
    private String link;
    private String profile_image;
    private List<String> tags;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getAnswer_count() {
        return answer_count;
    }

    public void setAnswer_count(Long answer_count) {
        this.answer_count = answer_count;
    }

    public Long getQuestion_count() {
        return question_count;
    }

    public void setQuestion_count(Long question_count) {
        this.question_count = question_count;
    }

    public Long getReputation() {
        return reputation;
    }

    public void setReputation(Long reputation) {
        this.reputation = reputation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    @Override
    public String toString() {
        return "ApiResponseItem{"
                + "user_id=" + user_id
                + ", answer_count=" + answer_count
                + ", question_count=" + question_count
                + ", reputation=" + reputation
                + ", location='" + location + '\''
                + ", display_name='" + display_name + '\''
                + ", link='" + link + '\''
                + ", profile_image='" + profile_image + '\''
                + ", tags=" + tags
                + '}';
    }
}
