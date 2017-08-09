package wissen.test.ws;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller 
{
    //http://localhost:8080/ws/resr/get_item
    @RequestMapping("/rest/get_item")
    public Item getRandomItem()
    {
        Item it = new Item("Dump Name", 999.99);
        return it;
    }
    
    //http://localhost:8080/ws/resr/get_items
    @RequestMapping("/rest/get_item")
    public ArrayList<Item> getAllItems()
    {
        ArrayList<Item> al = new ArrayList<>();
        al.add(new Item("Laptop", 1999.99));
        al.add(new Item("IPhone 7", 4299.99));
        al.add(new Item("LG LA-620S", 3799.55));
        
        return al;
    }
}
