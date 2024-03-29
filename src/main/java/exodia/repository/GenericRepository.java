package exodia.repository;

import java.util.List;

public interface GenericRepository<E, ID> {

    E save(E entity);

    boolean delete(E entity);

    List<E> findAll();

    E findById(ID id);
}
