package woowacourse.kanban.board

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import woowacourse.kanban.board.component.KanbanBoardTemplate
import woowacourse.kanban.board.constant.DEFAULT_CONTENT
import woowacourse.kanban.board.constant.DEFAULT_NAME
import woowacourse.kanban.board.constant.DEFAULT_TITLE
import woowacourse.kanban.board.constant.MAX_CONTENT
import woowacourse.kanban.board.constant.MAX_NAME
import woowacourse.kanban.board.constant.MAX_TITLE
import woowacourse.kanban.board.model.BoardData
import woowacourse.kanban.board.model.Nickname
import woowacourse.kanban.board.model.Tags
import woowacourse.kanban.board.model.Title

@Composable
fun App() {
}

class BoardPreviewParameterProvider : PreviewParameterProvider<BoardData> {
    override val values = sequenceOf(
        BoardData(
            title = Title(DEFAULT_TITLE),
            content = DEFAULT_CONTENT,
            tags = Tags(listOf("컴포넌트", "성능")),
            nickname = Nickname(DEFAULT_NAME),
        ),
        BoardData(
            title = Title(DEFAULT_TITLE),
            tags = Tags(listOf("컴포넌트", "성능")),
            nickname = Nickname(DEFAULT_NAME),
        ),
        BoardData(
            title = Title(DEFAULT_TITLE),
            content = DEFAULT_CONTENT,
            tags = Tags(),
            nickname = Nickname(DEFAULT_NAME),
        ),
        BoardData(
            title = Title(DEFAULT_TITLE),
            tags = Tags(),
            nickname = Nickname(DEFAULT_NAME),
        ),
        BoardData(
            title = Title(MAX_TITLE),
            content = MAX_CONTENT,
            tags = Tags(listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임")),
            nickname = Nickname(MAX_NAME),
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun BoardScreenView(@PreviewParameter(BoardPreviewParameterProvider::class) board: BoardData) {
    KanbanBoardTemplate(
        title = board.title,
        content = board.content,
        tags = board.tags,
        nickname = board.nickname,
    )
}
