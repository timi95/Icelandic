package Iceland.Tech.Test.iceland.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import Iceland.Tech.Test.iceland.models.StoreItem;

/**
 * StoreItemDAOService
 */
@Component
public class StoreItemDAOService {
    private static List<StoreItem> items = new ArrayList<>();

    // static block of seed values
    static {
        items.add( new StoreItem() );
    }

    public List<StoreItem> findAll(){
        return items;
    }

    public StoreItem save(StoreItem item){
        items.add(item);
        return item;
    }

    public StoreItem findById(int id) {
        for( StoreItem item: items ) {
            if(item.getId()==id){
                return item;
            }
        }
        return null;
    }
}