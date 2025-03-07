package de.rbsulm.rbs_lf12.mysql;

import de.rbsulm.rbs_lf12.model.CalendarEvent;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface CalendarEventRepository extends CrudRepository<CalendarEvent, Integer> {

    List<CalendarEvent> getCalendarEventsByStartDateAfterAndStartDateBefore(long l, long l1);
}
