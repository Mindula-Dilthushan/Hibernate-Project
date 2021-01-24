package bo.custom.Impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.custom.Item;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    private ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getSuperDAO(DAOFactory.DAOType.ITEM);

    @Override
    public boolean addItem(ItemDTO itemDTO) throws Exception {
        return itemDAO.add(
                new Item(
                        itemDTO.getCode(),
                        itemDTO.getDescription(),
                        itemDTO.getPrice(),
                        itemDTO.getQtyOnHand()
                )
        );
    }
    @Override
    public boolean updateItem(ItemDTO itemDTO) throws Exception {
        return itemDAO.update(
                new Item(
                        itemDTO.getCode(),
                        itemDTO.getDescription(),
                        itemDTO.getPrice(),
                        itemDTO.getQtyOnHand()
                )
        );
    }
    @Override
    public boolean deleteItem(String id) throws Exception {
        return itemDAO.delete(id);
    }
    @Override
    public ItemDTO searchItem(String id) throws Exception {
        Item item=itemDAO.search(id);
        return new ItemDTO(
                item.getCode(),
                item.getDescription(),
                item.getPrice(),
                item.getQtyOnHand()
        );
    }

    @Override
    public List<ItemDTO> getAllItem() throws Exception {
        return null;
    }
}
