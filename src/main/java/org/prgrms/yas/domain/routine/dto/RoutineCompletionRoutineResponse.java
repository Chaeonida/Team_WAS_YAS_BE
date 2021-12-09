package org.prgrms.yas.domain.routine.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoutineCompletionRoutineResponse {
  private Long routineId;
  private String name;
  private List<String> routineCategory;
  private LocalDate startTime;
  private LocalDate durationTime;
  private String color;
  private String emoji;

}
