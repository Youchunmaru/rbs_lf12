package de.rbsulm.rbs_lf12.mysql;

import de.rbsulm.rbs_lf12.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
