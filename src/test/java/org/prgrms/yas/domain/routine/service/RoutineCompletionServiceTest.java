package org.prgrms.yas.domain.routine.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.prgrms.yas.domain.routine.dto.RoutineCompletionCreateRequest;
import org.prgrms.yas.domain.routine.dto.RoutineCompletionCreateResponse;
import org.prgrms.yas.domain.routine.dto.RoutineCreateRequest;
import org.prgrms.yas.domain.routine.dto.RoutineCreateResponse;
import org.prgrms.yas.domain.routine.repository.RoutineRepository;
import org.prgrms.yas.domain.user.domain.User;
import org.prgrms.yas.domain.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(value = false)
class RoutineCompletionServiceTest {
  @Autowired
  private RoutineService routineService;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoutineCompletionService routineCompletionService;

  Long userId;
  Long routineId;

  @BeforeEach
  void setting() {

    //User 저장
    User user = User.builder().name("oni").nickname("oni").email("kcs@naver.com").password("1234")
                    .build();

    userId = userRepository.save(user).getId();

    //Routine 저장
    List<String> findWeek = new ArrayList<>();
    findWeek.add("MON");
    findWeek.add("TUE");

    List<String> findCategory = new ArrayList<>();
    findCategory.add("EXERCISE");

    RoutineCreateRequest routineCreateRequest = RoutineCreateRequest.builder().name("윤동하기")
                                                                    .startTime(LocalDate.now())
                                                                    .durationTime(LocalDate.now())
                                                                    .weeks(findWeek)
                                                                    .routineCategory(findCategory)
                                                                    .color("black").emoji(">_<")
                                                                    .build();

    RoutineCreateResponse routineCreateResponse = routineService.saveRoutine(userId,routineCreateRequest);
    routineId = routineCreateResponse.getRoutineId();
  }

  @Test
  @DisplayName("사용자는 루틴완료를 저장할 수 있다.")
  void routineCompletionSaveTest() throws NotFoundException {
    //given
    RoutineCompletionCreateRequest routineCompletionCreateRequest = RoutineCompletionCreateRequest.builder()
                                                                                                  .date(
                                                                                                      LocalDate.now())
                                                                                                  .startTime(
                                                                                                      LocalDateTime.now())
                                                                                                  .endTime(
                                                                                                      LocalDateTime.now())
                                                                                                  .routineId(
                                                                                                      routineId)
                                                                                                  .build();

    //when
    RoutineCompletionCreateResponse routineCompletionCreateResponse = routineCompletionService.saveRoutineCompletion(
        routineCompletionCreateRequest);

    //then
    Assertions.assertThat(routineCompletionCreateResponse.getRoutineCompletionRoutineResponse()
                                                         .getRoutineId())
              .isEqualTo(routineId);

  }
}