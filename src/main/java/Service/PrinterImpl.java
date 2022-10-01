package Service;

import dto.ApiResponseItem;

import java.util.stream.Collectors;

public class PrinterImpl implements Printer{
    @Override
    public void toConsole(ApiResponseItem item) {
        String tags = item.getTags().stream().collect(Collectors.joining(","));
        System.out.println("User name: " + item.getDisplay_name() + "; "
                + "Location: " + item.getLocation() + "; "
                + "Answer count: " + item.getAnswer_count() + "; "
                + "Question count: " + item.getQuestion_count() + "; "
                + "Tags: " + tags + "; "
                + "Link to profile: " + item.getLink() + "; "
                + "Link to avatar: " + item.getProfile_image() + ";");
    }
}
