package woowacourse.kanban.board.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.constant.BORDER_COLOR
import woowacourse.kanban.board.model.Nickname
import woowacourse.kanban.board.model.Tags
import woowacourse.kanban.board.model.Title

@Composable
fun KanbanBoardTemplate(title: Title, content: String = "", tags: Tags, nickname: Nickname) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(BORDER_COLOR),
                shape = RoundedCornerShape(15.dp),
            )
            .width(270.dp)
            .padding(12.dp),
    ) {
        Column {
            // 제목
            Title(title)

            // 중간 내용
            if (content.isNotBlank()) {
                Content(content)
            }

            // 태그
            if (tags.tags.isNotEmpty()) {
                TagsComponent(tags)
            }

            // 구분선
            HorizontalDivider(thickness = 2.dp)

            // 작성자
            Profile(nickname)
        }
    }
}
