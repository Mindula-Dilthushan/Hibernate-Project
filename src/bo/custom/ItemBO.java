package bo.custom;

import bo.SuperBO;
import dto.ItemDTO;
import java.util.List;

public interface ItemBO extends SuperBO {
    boolean addItem(ItemDTO itemDTO)throws Exception;
    boolean updateItem(ItemDTO itemDTO)throws Exception;
    boolean deleteItem(String id)throws Exception;
    ItemDTO searchItem(String id)throws Exception;
    List<ItemDTO> getAllItem()throws Exception;
}
