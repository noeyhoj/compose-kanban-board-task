package woowacourse.kanban.board

import androidx.compose.ui.test.ExperimentalTestApi
import org.junit.Assert.assertThrows
import org.junit.Test
import woowacourse.kanban.board.model.Nickname

@OptIn(ExperimentalTestApi::class)
class NicknameTest {

    @Test
    fun `닉네임이 공백이라면 오류가 발생함`() {
        // given
        val nickname = ""
        // when
        // then
        assertThrows(IllegalArgumentException::class.java) {
            Nickname(nickname)
        }
    }

    @Test
    fun `닉네임에 빈 공간이 있다면 오류가 발생함`() {
        // given
        val nickname = " "
        // when
        // then
        assertThrows(IllegalArgumentException::class.java) {
            Nickname(nickname)
        }
    }
}
