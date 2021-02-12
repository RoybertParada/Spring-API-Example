package com.dbacess.example.app.domain.repository;

import com.dbacess.example.app.domain.Period;
import com.dbacess.example.app.domain.PeriodId;

import java.util.List;
import java.util.Optional;

public interface PeriodRepository {
    List<Period> getAll();
    List<Period> findAllPeriodByCourseId(Long courseId);
    Period save(Period period);
    Boolean deleteById(PeriodId periodId);
    Optional<Period> getPeriod(PeriodId periodId);
}
