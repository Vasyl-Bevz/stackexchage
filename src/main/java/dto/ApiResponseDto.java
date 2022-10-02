package dto;

import java.util.Arrays;

public class ApiResponseDto {
    private ApiResponseItem[] items;
    private boolean has_more;

    public ApiResponseItem[] getItems() {
        return items;
    }

    public void setItems(ApiResponseItem[] items) {
        this.items = items;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    @Override
    public String toString() {
        return "ApiResponseDto{"
                + "items=" + Arrays.toString(items)
                + ", has_more=" + has_more
                + '}';
    }
}
