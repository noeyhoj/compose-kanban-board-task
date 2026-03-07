package woowacourse.kanban.board

import androidx.compose.ui.test.ExperimentalTestApi
import kotlin.test.Test
import org.junit.Assert.assertThrows
import woowacourse.kanban.board.model.Tags

@OptIn(ExperimentalTestApi::class)
class TagsTest {

    @Test
    fun `태그의 개수가 5개 초과면 오류가 발생한다`() {
        // given
        val tags = listOf("일", "이", "삼", "사", "오", "육")
        // when
        // then
        assertThrows(IllegalArgumentException::class.java) {
            Tags(tags)
        }
    }
}
