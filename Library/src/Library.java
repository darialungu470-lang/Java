import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Item> items = new HashMap<>();

    public void addItem(Item item){
        String id = "";
        items.put(id, item);
    }
}
