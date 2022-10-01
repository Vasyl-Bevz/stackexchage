package Service;

import dto.ApiResponseItem;

import java.util.List;

public interface TagService {
    List<String> getTagForItem(ApiResponseItem item);
}
