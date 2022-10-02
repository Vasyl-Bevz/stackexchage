package Service;

import model.User;
import java.util.stream.Collectors;

public class PrinterImpl implements Printer{
    @Override
    public void toConsole(User user) {
        String tags = user.getTags().stream().collect(Collectors.joining(","));
        System.out.println("User name: " + user.getDisplay_name() + "; "
                + "Location: " + user.getLocation() + "; "
                + "Answer count: " + user.getAnswer_count() + "; "
                + "Question count: " + user.getQuestion_count() + "; "
                + "Tags: " + tags + "; "
                + "Link to profile: " + user.getLink() + "; "
                + "Link to avatar: " + user.getProfile_image() + ";");
    }
}
