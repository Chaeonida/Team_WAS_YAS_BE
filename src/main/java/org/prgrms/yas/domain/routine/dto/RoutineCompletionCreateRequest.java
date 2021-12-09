package org.prgrms.yas.domain.routine.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.prgrms.yas.domain.routine.domain.RoutineCompletion;

@Getter
public class RoutineCompletionCreateRequest {
  Long routineId;
  LocalDate date;
  LocalDateTime startTime;  // 수행 시작한 시간
  LocalDateTime endTime; // 수행 완료한 시간

  @Builder
  public RoutineCompletionCreateRequest(Long routineId, LocalDate date, LocalDateTime startTime,LocalDateTime endTime) {
    this.routineId = routineId;
    this.date = date;
    this.startTime = startTime;
    this.endTime = endTime;
  }

//  public RoutineCompletion toEntity() {
//    return RoutineCompletion
//  }
}
