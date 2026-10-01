public class Magazine extends AbstractItem{
    private int issueNumber;

    public Magazine(String id, String title, int issueNumber){
        super(id, title);
        this.issueNumber = issueNumber;
    }

    public void setIssueNumber(int issueNumber){
        this.issueNumber = issueNumber;
    }
}
