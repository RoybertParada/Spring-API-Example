package com.dbacess.example.app.persistence.crud;

import com.dbacess.example.app.domain.Period;
import com.dbacess.example.app.persistence.entity.Periodo;
import com.dbacess.example.app.persistence.entity.PeriodoPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PeriodoCrudRepository extends CrudRepository<Periodo, PeriodoPK> {
     List<Periodo> findAllPeriodoByCursoCursoId(Long cursoId);
}
