package common_tools.common_controller_service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEntityService<E, I> {
    List<E> findAll();
    Optional<E> findByID(I id);
    E create(E entity);
    void removeById(I id);
    void removeByObject(E entity);

    // import org.springframework.data.domain.Page;
    // import org.springframework.data.domain.Pageable;
    Page<E> findAll(Pageable pageable);

}
