package com.dbacess.example.app.domain.service;

import com.dbacess.example.app.domain.Course;
import com.dbacess.example.app.domain.Period;
import com.dbacess.example.app.domain.PeriodId;
import com.dbacess.example.app.domain.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodService {
    @Autowired
    private PeriodRepository periodRepository;

    public List<Period> getAll() {
        return periodRepository.getAll();
    }

    public Optional<Period> getPeriod(PeriodId periodId) {
        return periodRepository.getPeriod(periodId);
    }

    public  List<Period> findAllPeriodByCourseId(Long courseId){
        return periodRepository.findAllPeriodByCourseId(courseId);
    }

    public Period save(Period period) {
        return periodRepository.save(period);
    }

    public boolean deleteById(PeriodId periodId) {
        return periodRepository.deleteById(periodId);
    }
}
