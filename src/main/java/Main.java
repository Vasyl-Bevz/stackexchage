import Service.HttpClient;
import Service.Printer;
import Service.PrinterImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import dto.ApiResponseDto;
import dto.ApiResponseItem;
import dto.ApiResponseName;
import dto.ApiResponseTag;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int START_PAGE = 1;
    public static String[] TAGS = { "java", ".net", "docker", "C#"};
    public static void main(String[] args) throws JsonProcessingException, InterruptedException {
        Printer printer = new PrinterImpl();
        HttpClient httpClient = new HttpClient();
        int currentPage = START_PAGE;
        boolean isNext = true;
        List<String> tags;
        while (isNext) {
            ApiResponseDto apiResponseDto = httpClient.get("https://api.stackexchange.com/2.3/users?page=" +
                            currentPage++ +
                            "&pagesize=100&order=asc&min=223&sort=reputation" +
                            "&site=stackoverflow&filter=!0Z-LvgkSiw7B6BDe5tw88nNHR&key=1S3)kMQUelHL6HUlrjvM6w((",
                    ApiResponseDto.class);
            //System.out.println(apiResponseDto);
            for (ApiResponseItem item : apiResponseDto.getItems()) {
                if (item.getQuestion_count() == null || item.getQuestion_count() < 1) {
                    continue;
                }
                if (item.getLocation() == null) {
                    continue;
                }
                if (item.getLocation().toLowerCase().contains("romania") || item.getLocation().toLowerCase().contains("moldova")) {
                    tags = getTagForItem(item);
                    //System.out.println(tags);
                    for (String tag : TAGS) {
                        if (tags.contains(tag)) {
                            item.setTags(tags);
                            printer.toConsole(item);
                            break;
                        }
                    }
                }

            }
            isNext = apiResponseDto.isHas_more();
            Thread.sleep(2000);
        }
    }

    private static List<String> getTagForItem(ApiResponseItem item) {
        HttpClient httpClient = new HttpClient();
        int currentPage = START_PAGE;
        boolean isNext = true;
        List<String> tags = new ArrayList<>();
        while (isNext) {
            ApiResponseTag apiResponseTag = httpClient.get("https://api.stackexchange.com/2.3/users/" +
                            item.getUser_id() +
                            "/tags?page=" +
                            currentPage++ +
                            "&pagesize=100&order=desc&sort=popular&site=stackoverflow&filter=!T.BkwD0bG1jQ4r6cgv" +
                            "&key=1S3)kMQUelHL6HUlrjvM6w((",
                    ApiResponseTag.class);
            for (ApiResponseName tag : apiResponseTag.getItems()) {
                tags.add(tag.getName());
            }
            isNext = apiResponseTag.isHas_more();
        }
        return tags;
    }
}
