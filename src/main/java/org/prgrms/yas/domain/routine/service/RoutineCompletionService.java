package org.prgrms.yas.domain.routine.service;

import java.time.LocalDate;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prgrms.yas.domain.routine.domain.Routine;
import org.prgrms.yas.domain.routine.domain.RoutineCompletion;
import org.prgrms.yas.domain.routine.dto.RoutineCompletionCreateRequest;
import org.prgrms.yas.domain.routine.dto.RoutineCompletionCreateResponse;
import org.prgrms.yas.domain.routine.dto.RoutineCreateRequest;
import org.prgrms.yas.domain.routine.dto.RoutineCreateResponse;
import org.prgrms.yas.domain.routine.repository.RoutineCompletionRepository;
import org.prgrms.yas.domain.routine.repository.RoutineRepository;
import org.prgrms.yas.domain.user.domain.User;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoutineCompletionService {

  private final RoutineCompletionRepository routineCompletionRepository;
  private final RoutineRepository routineRepository;

  @Transactional
  public RoutineCompletionCreateResponse saveRoutineCompletion(
      RoutineCompletionCreateRequest routineCompletionCreateRequest) throws NotFoundException {
    Routine routine = routineRepository.findById(routineCompletionCreateRequest.getRoutineId())
                                       .orElseThrow(NotFoundException::new);

    RoutineCompletion routineCompletion = RoutineCompletion.builder()
                                                           .routine(routine)
                                                           .date(
                                                               routineCompletionCreateRequest.getDate())
                                                           .endTime(
                                                               routineCompletionCreateRequest.getEndTime())
                                                           .startTime(
                                                               routineCompletionCreateRequest.getStartTime())
                                                           .build();
    routineCompletionRepository.save(routineCompletion);

    return routineCompletion.toRoutineCompletionCreateResponse();
  }


}
