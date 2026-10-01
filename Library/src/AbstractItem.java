public abstract class AbstractItem implements Item {
    protected String id;
    protected String title;
    protected boolean available = true;

    public AbstractItem(String id, String title){
        this.id = id;
        this.title = title;
    }

    @Override
    public String getId(){
        return id;
    }

    @Override
    public String getTitle(){
        return title;
    }

    public boolean isAvailable(){
        return available;
    }

    @Override
    public void borrow(){
        if(!available){
            throw new ItemNotAvailableException("Item is already borrowed");
        }
        available = false;
    }

    @Override
    public void returnItem(){
        available = true;
    }
}
