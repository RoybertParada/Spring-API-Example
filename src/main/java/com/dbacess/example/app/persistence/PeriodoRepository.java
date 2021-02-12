package com.dbacess.example.app.persistence;

import com.dbacess.example.app.domain.Period;
import com.dbacess.example.app.domain.PeriodId;
import com.dbacess.example.app.domain.repository.PeriodRepository;
import com.dbacess.example.app.persistence.crud.PeriodoCrudRepository;
import com.dbacess.example.app.persistence.entity.Instructor;
import com.dbacess.example.app.persistence.entity.Periodo;
import com.dbacess.example.app.persistence.mapper.PeriodoIdMapper;
import com.dbacess.example.app.persistence.mapper.PeriodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class PeriodoRepository implements PeriodRepository {
    @Autowired
    private PeriodoCrudRepository periodoCrudRepository;

    @Autowired
    private PeriodoMapper mapper;

    @Autowired
    private PeriodoIdMapper periodoIdMapper;

    @Override
    public List<Period> getAll() {
        return mapper.toPeriods((List<Periodo>) periodoCrudRepository.findAll());
    }

    @Override
    public Optional<Period> getPeriod(PeriodId periodId) {
        return periodoCrudRepository.findById(periodoIdMapper.toPeriodoPK(periodId)).map(periodo-> mapper.toPeriod(periodo));
    }

    @Override
    public List<Period> findAllPeriodByCourseId(Long courseId) {
        return mapper.toPeriods(periodoCrudRepository.findAllPeriodoByCursoCursoId(courseId));
    }

    @Override
    public Period save(Period period) {
        Periodo periodo = mapper.toPeriodo(period);
        return mapper.toPeriod(periodoCrudRepository.save(periodo));
    }

    @Override
    public Boolean deleteById(PeriodId periodId) {
        try{
            periodoCrudRepository.deleteById(periodoIdMapper.toPeriodoPK(periodId));
            return true;
        }catch(Exception exception){
            return false;
        }
    }
}
