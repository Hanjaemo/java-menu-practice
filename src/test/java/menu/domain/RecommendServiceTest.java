package menu.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecommendServiceTest {

    private final RecommendService recommendService = new RecommendService(new RandomNumberGenerator());
    
    @DisplayName("무작위 카테고리를 하나 추천하면, 추천 결과의 카테고리 목록에 있는 카테고리 수는 1이다.")
    @Test
    void recommendCategory_Success() {
        // when
        recommendService.recommendCategory();

        // then
        assertThat(RecommendResult.categories().size()).isEqualTo(1);
    }
}