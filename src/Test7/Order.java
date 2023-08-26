package Test7;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private int price;
    private int id;
    private String name;
    private String describe;
    private LocalDateTime time;

    public Order(){}
    public Order(int price, int id, String name, String describe, LocalDateTime time) {
        this.price = price;
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setTime(LocalDateTime time){this.time = time;}

    public LocalDateTime getTime(){return this.time;};

    @Override
    public String toString() {
        return "Order{" +
                "price=" + price +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static List<Order> readXml(){
        List<Order> rs = new ArrayList<>();
        SAXReader sax_reader = new SAXReader();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        File xml_file = null;
        SAXReader reader = new SAXReader();
        Document docu = null;
        try{
            docu = reader.read(Test7.class.getResourceAsStream("/orders.xml"));
            Element root = docu.getRootElement();
            List<Element> order_elements = root.elements();
            for(Element o : order_elements){
               Order order = new Order();
               order.setId(Integer.parseInt(o.attributeValue("id")));
               order.setName(o.attributeValue("name"));
               order.setDescribe(o.attributeValue("describe"));
               order.setPrice(Integer.parseInt(o.attributeValue("price")));
               order.setTime(LocalDateTime.parse(o.attributeValue("time"), df));
               rs.add(order);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        rs.stream().filter(o -> o.getTime().isBefore(LocalDateTime.now())).forEach(System.out::println);
        if(rs.size() > 1) return rs;
        else return null;
    }
}
