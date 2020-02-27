package utils.basketUtils.pojo;

import java.util.List;

public class Basket {
    public Integer id;
    public List<Product> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

}
