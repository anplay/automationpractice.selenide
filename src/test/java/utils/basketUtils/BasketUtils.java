package utils.basketUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.basketUtils.pojo.Basket;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasketUtils {

    public static List<Basket> getBaskets() {
        ObjectMapper mapper = new ObjectMapper();
        List<Basket> basketList = new ArrayList<>();

        try {
            Basket[] baskets = mapper.readValue(new File("resources/baskets.json"), Basket[].class);
            basketList = Arrays.asList(baskets);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return basketList;
    }
}
