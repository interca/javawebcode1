package atguigu.pojo;

import java.math.BigDecimal;

public class CartItem {
    private  Integer id;
    private  String name;
    private  Integer count;
    private BigDecimal price;
    private  BigDecimal total;

    public CartItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal total) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.total = total;
    }

    public CartItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
