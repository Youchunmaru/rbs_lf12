package de.rbsulm.rbs_lf12.mysql;

import de.rbsulm.rbs_lf12.model.Settings;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SettingsRepository extends CrudRepository<Settings, Integer> {
    List<Settings> findAllByUser_Id(Long userId);
}
