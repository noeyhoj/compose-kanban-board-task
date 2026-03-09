package woowacourse.kanban.board.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.Tags

@Composable
fun TagsComponent(tags: Tags) {
    FlowRow(
        modifier = Modifier.padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        for (tag in tags.tags) {
            Tag(tag)
        }
    }
}
