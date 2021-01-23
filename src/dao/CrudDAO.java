package dao;

import java.util.List;

public interface CrudDAO <T,ID> extends SuperDAO{
    boolean add(T entity) throws Exception;
    boolean update(T entity)throws Exception;
    boolean delete(ID id)throws Exception;
    T search(String s)throws Exception;
    List<T>getAll()throws Exception;
}
