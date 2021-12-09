package org.prgrms.yas.domain.routine.repository;

import org.prgrms.yas.domain.routine.domain.Routine;
import org.prgrms.yas.domain.routine.domain.RoutineCompletion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineCompletionRepository extends JpaRepository<RoutineCompletion, Long> {

}
