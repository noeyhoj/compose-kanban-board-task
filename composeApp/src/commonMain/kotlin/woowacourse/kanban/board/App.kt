package woowacourse.kanban.board

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.planet
import kanbanboard.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import woowacourse.kanban.board.model.BORDER_COLOR
import woowacourse.kanban.board.model.BoardComponent
import woowacourse.kanban.board.model.CONTENT_COLOR
import woowacourse.kanban.board.model.DEFAULT_CONTENT
import woowacourse.kanban.board.model.DEFAULT_NAME
import woowacourse.kanban.board.model.DEFAULT_TITLE
import woowacourse.kanban.board.model.MAX_CONTENT
import woowacourse.kanban.board.model.MAX_NAME
import woowacourse.kanban.board.model.MAX_TITLE
import woowacourse.kanban.board.model.PROFILE_BG_COLOR
import woowacourse.kanban.board.model.PROFILE_COLOR
import woowacourse.kanban.board.model.TAG_COLOR

@Composable
@Preview(showBackground = true)
fun App() {
    BoardScreenView()
}

@Composable
@Preview(showBackground = true)
fun KanbanBoardTemplate(
    title: String = DEFAULT_TITLE,
    content: String = "",
    tags: List<String> = listOf(),
    name: String = DEFAULT_NAME,
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
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
            Box (
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    title,
                    fontSize = 16.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
            }
            // 중간 내용
            if (content.isNotBlank()) {
                Box (
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Text(
                        content,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                        fontSize = 14.sp,
                        color = Color(CONTENT_COLOR),
                    )
                }
            }

            // 태그
            if (tags.isNotEmpty()) {
                FlowRow(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    for (tag in tags) {
                        Box(
                            modifier = Modifier
                                .background(
                                    color = Color(TAG_COLOR),
                                    shape = RoundedCornerShape(45.dp),
                                ),
                        ) {
                            Text(if (tag.length > 5) tag.substring(0, 5) else tag, modifier = Modifier.padding(6.dp), fontSize = 10.sp)
                        }
                    }
                }
            }

            // 구분선
            HorizontalDivider(thickness = 2.dp)
            // 작성자
            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color(PROFILE_COLOR),
                    modifier = Modifier.size(25.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color(PROFILE_BG_COLOR))
                        .background(color = Color(PROFILE_BG_COLOR)),
                )
                Text(
                    name,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BoardScreenView() {
    val boardCases = listOf(
        BoardComponent(
            title = DEFAULT_TITLE,
            content = DEFAULT_CONTENT,
            tags = listOf("컴포넌트", "성능"),
            name = DEFAULT_NAME,
        ),
        BoardComponent(
            title = DEFAULT_TITLE,
            tags = listOf("컴포넌트", "성능"),
            name = DEFAULT_NAME,
        ),
        BoardComponent(
            title = DEFAULT_TITLE,
            content = DEFAULT_CONTENT,
            name = DEFAULT_NAME,
        ),
        BoardComponent(
            title = DEFAULT_TITLE,
            name = DEFAULT_NAME,
        ),
        BoardComponent(
            title = MAX_TITLE,
            content = MAX_CONTENT,
            tags = listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임"),
            name = MAX_NAME,
        ),
    )

    LazyColumn {
        items(items = boardCases) { item ->
            KanbanBoardTemplate(
                title = item.title,
                content = item.content,
                tags = item.tags,
                name = item.name
            )
        }
    }
}
