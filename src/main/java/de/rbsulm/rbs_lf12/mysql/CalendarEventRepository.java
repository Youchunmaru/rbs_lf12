package de.rbsulm.rbs_lf12.mysql;

import de.rbsulm.rbs_lf12.model.CalendarEvent;
import org.springframework.data.repository.CrudRepository;

public interface CalendarEventRepository extends CrudRepository<CalendarEvent, Integer> {
}
