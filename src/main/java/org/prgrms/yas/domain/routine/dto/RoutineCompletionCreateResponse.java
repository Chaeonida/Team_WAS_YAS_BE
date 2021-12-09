package org.prgrms.yas.domain.routine.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.prgrms.yas.domain.routine.domain.RoutineCompletion;
import org.w3c.dom.stylesheets.LinkStyle;

@Getter
@Builder
public class RoutineCompletionCreateResponse {

  Long id;
  RoutineCompletionRoutineResponse routineCompletionRoutineResponse;
  LocalDate date;
  LocalDateTime startTime;
  LocalDateTime endTime;
  String userDurationTime;
  List<String> missionCompletions;


}
