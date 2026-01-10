package exercises.eleven;

public class TestResult<T> {

    private final T data;
    private final boolean success;
    private final String description;

    public TestResult(T data, boolean success, String description) {
        this.data = data;
        this.success = success;
        this.description = description;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getDescription() {
        return description;
    }
}
