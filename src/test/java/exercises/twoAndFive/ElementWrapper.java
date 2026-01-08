package exercises.twoAndFive;

public class ElementWrapper<T> {

    private T element;

    public ElementWrapper(T element) {

        this.element = element;
    }

    public T getElement() {

        return element;
    }

    public void setElement(T element) {

        this.element = element;
    }
}
