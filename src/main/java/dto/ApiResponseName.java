package dto;

public class ApiResponseName {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ApiResponseTag{" +
                "name='" + name + '\'' +
                '}';
    }
}
