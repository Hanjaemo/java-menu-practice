package menu.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachRepositoryTest {

    @DisplayName("n명의 코치를 성공적으로 등록한 경우 등록된 코치의 수는 n이다.")
    @Test
    void size_Success_save() {
        // given
        List<String> inputCoaches = List.of("토미", "제임스", "포코");

        // when
        inputCoaches.forEach(coach -> CoachRepository.save(new Coach(coach)));

        // then
        assertThat(CoachRepository.size()).isEqualTo(3);
    }

    @DisplayName("코치를 등록할 때, 코치 이름의 길이가 지정 범위를 벗어난 경우 예외를 발생시킨다.")
    @Test
    void save_Fail_ByNameLengthIsOutOfBounds() {
        // given
        List<String> inputCoaches = List.of("잼", "토미", "제임스포코");

        // when, then
        assertThatThrownBy(
                () -> inputCoaches.forEach(
                        coach -> CoachRepository.save(new Coach(coach))
                )
        )
                .isInstanceOf(IllegalArgumentException.class);
    }
}