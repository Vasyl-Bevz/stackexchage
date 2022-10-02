package Service;

import dto.ApiResponseName;
import dto.ApiResponseTag;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class TagServiceImpl implements TagService{
    public static int START_PAGE = 1;

    @Override
    public List<String> getTagForItem(User user) throws InterruptedException {
        HttpClient httpClient = new HttpClient();
        int currentPage = START_PAGE;
        boolean isNext = true;
        List<String> tags = new ArrayList<>();
        while (isNext) {
            ApiResponseTag apiResponseTag = httpClient.get("https://api.stackexchange.com/2.3/users/" +
                            user.getUser_id() +
                            "/tags?page=" +
                            currentPage++ +
                            "&pagesize=100&order=desc&sort=popular&site=stackoverflow&filter=!T.BkwD0bG1jQ4r6cgv" +
                            "&key=1S3)kMQUelHL6HUlrjvM6w((",
                    ApiResponseTag.class);
            for (ApiResponseName tag : apiResponseTag.getItems()) {
                tags.add(tag.getName());
            }
            Thread.sleep(3000);
            isNext = apiResponseTag.isHas_more();
        }
        return tags;
    }
}
