package org.prgrms.yas.domain.mission.domain;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import org.prgrms.yas.domain.routine.domain.Routine;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Entity
@Table(name = "mission")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Mission {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, length = 50)
  private String name;

  private LocalDateTime startTime;

  private LocalDateTime endTime;

  @Column(nullable = false)
  private Long durationGoalTime;

  @Column(nullable = false)
  private int orders;

  @Column(nullable = false)
  private String emoji;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "routine_id")
  private Routine routine;

  @OneToMany(mappedBy = "mission")
  private List<MissionStatus> missionStatuses = new ArrayList<>();

  @Column(nullable = false, columnDefinition = "TINYINT default false")
  private boolean isDeleted;

  public void addMissionStatus(MissionStatus missionStatus) {
    this.missionStatuses.add(missionStatus);
    missionStatus.setMission(this);
  }

  public Mission addMissionStatuses(List<MissionStatus> missionStatuses) {
    missionStatuses.forEach(this::addMissionStatus);
    return this;
  }

  public void setRoutine(Routine routine) {
    if (Objects.nonNull(this.routine)) {
      this.routine.getMissions()
                  .remove(this);
    }
    this.routine = routine;
  }
}
