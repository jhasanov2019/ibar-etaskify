package az.ibar.etaskify.etaskify.repository;

import az.ibar.etaskify.etaskify.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
}
