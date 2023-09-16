package menu.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import menu.MenuConfig;

class RecommendServiceTest {

    @BeforeEach
    void init() {
        MenuRepository.init(new MenuConfig());
    }

    @AfterEach
    void clear() {
        CoachRepository.clear();
    }

    private final RecommendService recommendService = new RecommendService(new RandomNumberGenerator());
    
    @DisplayName("무작위 카테고리를 하나 추천하면, 추천 결과의 카테고리 목록에 있는 카테고리 수는 1이다.")
    @Test
    void recommendCategory_Success() {
        // when
        recommendService.recommendCategory();

        // then
        assertThat(RecommendResult.categories().size()).isEqualTo(1);
    }

    @DisplayName("각 코치가 먹을 메뉴를 하나 추천하면, 코치가 먹을 메뉴 목록에 있는 메뉴 수는 1이다.")
    @Test
    void recommendMenu_Success() {
        // given
        CoachRepository.save(new Coach("토미"));

        // when
        recommendService.recommendMenu(Category.ASIAN);
        Coach coach = CoachRepository.coaches().get(0);


        // then
        assertThat(coach.menus().size()).isEqualTo(1);
    }
}