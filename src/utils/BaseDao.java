package utils;

import java.util.List;

public interface BaseDao<T, K> {
  // add data
  void save(T data);

  // get all data
  List<T> findAll();

  // get data by id
  T findById(K id);

  // update data
  void update(K id, T data);

  // delete data
  void delete(K id);

  // get data size
  Integer size();
}
