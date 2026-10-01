public interface Item {

    String getID();
    String getTitle();
    boolean isAvailable();
    void borrow();
    void returnItem();
}
