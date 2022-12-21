package Model;

public class Order {
    private String orderdate;
    private String ordernumber;
    private String userId;
    private String article;


    public Order(String orderdate, String ordernumber, String userId, String article) {
        this.orderdate = orderdate;
        this.ordernumber = ordernumber;
        this.userId = userId;
        this.article = article;
    }
}
