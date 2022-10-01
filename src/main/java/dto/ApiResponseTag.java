package dto;

public class ApiResponseTag {
    private ApiResponseName[] items;
    private boolean has_more;

    public ApiResponseName[] getItems() {
        return items;
    }

    public void setItems(ApiResponseName[] items) {
        this.items = items;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }
}
