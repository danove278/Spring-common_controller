package common_tools.common_controller_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IEntityRepository<E, I> extends JpaRepository<E, I> {
}
