import Service.HttpClient;
import Service.Printer;
import Service.PrinterImpl;
import Service.TagService;
import Service.TagServiceImpl;
import Service.UserService;
import Service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import dto.ApiResponseDto;
import dto.Parser;
import model.User;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static int START_PAGE = 1;
    public static final int ANSWER_COUNT = 1;
    public static String[] TAGS = { "java", ".net", "docker", "C#"};
    public static String[] LOCATIONS = {"romania", "moldova"};
    private static final TagService tagService = new TagServiceImpl();
    private static final Parser parser = new Parser();
    private static final UserService userService = new UserServiceImpl();
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
            List<User> users = Arrays.stream(apiResponseDto.getItems()).map(parser::itemToModel).collect(Collectors.toList());
            for (User user : users) {
                if (!userService.isUserAnswerCountMoreThen(user, ANSWER_COUNT)) {
                    continue;
                }
                if (!userService.isUserInLocation(user, LOCATIONS)) {
                    continue;
                }
                Thread.sleep(5000);
                tags = tagService.getTagForItem(user);
                for (String tag : TAGS) {
                    if (tags.contains(tag)) {
                        userService.addTags(user, tags);
                        printer.toConsole(user);
                        break;
                    }
                }
            }
            isNext = apiResponseDto.isHas_more();
            Thread.sleep(5000);
        }
    }
}
