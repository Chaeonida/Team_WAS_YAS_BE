package org.prgrms.yas.domain.routine.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.prgrms.yas.domain.mission.domain.Mission;
import org.prgrms.yas.domain.mission.domain.MissionCompletion;
import org.prgrms.yas.domain.routine.dto.RoutineCompletionCreateResponse;
import org.prgrms.yas.domain.routine.dto.RoutineCompletionRoutineResponse;

@Entity
@Table(name = "routine_completion")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoutineCompletion {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private LocalDateTime startTime;

  private LocalDateTime endTime;

  private String userDurationTime;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "routine_id")
  private Routine routine;

//  @Column(nullable = false)
//  private List<String> missionCompletion;

  public void setRoutine(Routine routine) {
    if (Objects.nonNull(this.routine)) {
      this.routine.getRoutineCompletions().remove(this);
    }
    this.routine = routine;
  }

  public List<String> getMissionCompletion() {
    List<Mission> missions = this.routine.getMissions();
    List<MissionCompletion> missionCompletions = new ArrayList<>();
    List<String> result = new ArrayList<>();
    for (Mission x : missions) {
      x.getMissionCompletions()
      for(missionCompletions y : )
    }

    return result;
  }

  @Builder
  public RoutineCompletion(Routine routine, LocalDate date, LocalDateTime startTime,LocalDateTime endTime) {
    this.routine = routine;
    this.date = date;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public RoutineCompletionRoutineResponse toRoutineCompletionRoutineResponse() {
    return RoutineCompletionRoutineResponse.builder()
                                           .routineId(this.getRoutine()
                                                          .getId())
                                           .durationTime(this.getRoutine()
                                                             .getDurationTime())
                                           .color(this.getRoutine()
                                                      .getColor())
                                           .name(this.getRoutine()
                                                     .getName())
                                           .emoji(this.getRoutine()
                                                      .getEmoji())
                                           .color(this.getRoutine()
                                                      .getColor())
                                           .routineCategory(this.getRoutine()
                                                                .getStringCategory(this.getRoutine()
                                                                                       .getRoutineCategory()))

                                           .build();
  }

  public RoutineCompletionCreateResponse toRoutineCompletionCreateResponse() {
    return RoutineCompletionCreateResponse.builder()
        .id(this.getId())
        .startTime(this.getStartTime())
        .endTime(this.getEndTime())
        .date(this.getDate())
        .missionCompletions(this.getMissionCompletion())
        .userDurationTime(this.userDurationTime)
        .routineCompletionRoutineResponse(this.toRoutineCompletionRoutineResponse())
        .build();
  }
}
