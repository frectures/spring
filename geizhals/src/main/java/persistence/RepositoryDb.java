package persistence;

import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryDb<E extends Entity> implements Repository<E> {
	private final List<E> db = new ArrayList<>();

	@Override
	public synchronized List<E> findAll() {
		return new ArrayList<E>(db);
	}

	@Override
	public synchronized E findOne(Integer id) {
		return db.get(id);
	}

	@Override
	public synchronized void save(E entity) {
		if (entity.id == null) {
			db.add(entity);
			entity.id = db.size();
		} else {
			db.set(entity.id, entity);
		}
	}
}
