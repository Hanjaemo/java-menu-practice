package menu.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {

    @DisplayName("못 먹는 메뉴를 성공적으로 등록하는 경우 못 먹는 메뉴 목록에 해당 메뉴가 포함되어 있다.")
    @Test
    void addUnwanted_Success() {
        // given
        Coach coach = new Coach("토미");

        // when
        coach.addUnwanted("불고기");

        // then
        assertThat(coach.unwanted()).contains("불고기");
    }

    @DisplayName("존재하지 않는 메뉴를 코치가 못 먹는 메뉴로 등록하는 경우 실패한다.")
    @Test
    void addUnwanted_Fail_ByNotContains() {
        // given
        Coach coach = new Coach("토미");

        // when, then
        assertThatThrownBy(() -> coach.addUnwanted("오이무침"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("못 먹는 메뉴가 이미 2개 등록되어 있을 때 3번째 등록하는 경우 실패한다.")
    @Test
    void addUnwanted_Fail_ByOutOfBounds() {
        // given
        Coach coach = new Coach("토미");
        coach.addUnwanted("불고기");
        coach.addUnwanted("분짜");

        // when, then
        assertThatThrownBy(() -> coach.addUnwanted("짜장면"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 메뉴를 등록하는 경우 실패한다.")
    @Test
    void addUnwanted_Fail_ByDuplicated() {
        // given
        Coach coach = new Coach("토미");
        coach.addUnwanted("불고기");

        // when, then
        assertThatThrownBy(() -> coach.addUnwanted("불고기"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}