package menu.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import menu.MenuConfig;
import menu.domain.coach.Coach;
import menu.domain.coach.CoachRepository;
import menu.domain.menu.MenuRepository;

class CoachTest {

    @BeforeEach
    void init() {
        MenuRepository.init(new MenuConfig());
    }

    @AfterEach
    void clear() {
        CoachRepository.clear();
    }

    @DisplayName("못 먹는 메뉴를 성공적으로 등록하는 경우 못 먹는 메뉴 목록에 해당 메뉴가 포함되어 있다.")
    @Test
    void addUnwanted_Success() {
        // given
        Coach coach = new Coach("토미");

        // when
        coach.addUnwanted(Set.of("불고기"));

        // then
        assertThat(coach.unwanted()).contains("불고기");
    }

    @DisplayName("존재하지 않는 메뉴를 코치가 못 먹는 메뉴로 등록하는 경우 실패한다.")
    @Test
    void addUnwanted_Fail_ByNotContains() {
        // given
        Coach coach = new Coach("토미");

        // when, then
        assertThatThrownBy(() -> coach.addUnwanted(Set.of("오이무침")))
                .isInstanceOf(IllegalArgumentException.class);

    }
}