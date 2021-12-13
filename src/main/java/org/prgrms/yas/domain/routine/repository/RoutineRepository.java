package org.prgrms.yas.domain.routine.repository;

import java.util.List;
import org.prgrms.yas.domain.routine.domain.Routine;
import org.prgrms.yas.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
	
	List<Routine> getByUser(User user);
}
