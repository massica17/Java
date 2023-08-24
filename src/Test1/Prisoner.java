package Test1;

public class Prisoner {
    private int order;

    public Prisoner() {
    }

    public Prisoner(int order) {
        this.order = order;
    }
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Prisoner{" +
                "order=" + order +
                '}';
    }
}
