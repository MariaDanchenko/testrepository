package exercises.eleven;

public class TestResult<T> {

    private final T data;
    private final boolean success;

    public TestResult(T data, boolean success, String description) {
        this.data = data;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }
}
