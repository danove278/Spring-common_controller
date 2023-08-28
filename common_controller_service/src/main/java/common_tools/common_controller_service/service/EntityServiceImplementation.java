package common_tools.common_controller_service.service;

import common_tools.common_controller_service.repository.IEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class EntityServiceImplementation<E,I, R extends IEntityRepository<E, I>> implements IEntityService<E, I> {
    @Autowired
    protected R repo;

    @Transactional(readOnly = true)
    @Override
    public List<E> findAll() {
        return this.repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findByID(I id) {
        return this.repo.findById(id);
    }

    @Override
    @Transactional
    public E create(E entity) {
        return this.repo.save(entity);
    }

    @Override
    @Transactional
    public void removeById(I id) {
        this.repo.deleteById(id);
    }

    @Override
    @Transactional
    public void removeByObject(E entity) {
        this.repo.delete(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<E> findAll(Pageable pageable) {
        return this.repo.findAll(pageable);
    }


}
