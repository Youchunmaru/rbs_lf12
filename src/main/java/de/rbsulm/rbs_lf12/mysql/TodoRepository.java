package de.rbsulm.rbs_lf12.mysql;

import de.rbsulm.rbs_lf12.model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Integer> {

    List<Todo> getTodosByDueDateIsNull();

    List<Todo> getTodosByDueDateBetween(Date dueDateAfter, Date dueDateBefore);

    Object findAllByUser_Id(Long userId);
}
