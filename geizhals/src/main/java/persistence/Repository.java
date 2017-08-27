package persistence;

import java.util.List;

public interface Repository<E extends Entity> {
	public List<E> findAll();

	public E findOne(Integer id);

	public void save(E entity);
}
