package de.rbsulm.rbs_lf12.mysql;

import de.rbsulm.rbs_lf12.model.CalendarCategory;
import org.springframework.data.repository.CrudRepository;

public interface CalendarCategoryRepository extends CrudRepository<CalendarCategory, Integer> {
}
