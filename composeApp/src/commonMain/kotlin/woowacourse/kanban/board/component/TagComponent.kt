package woowacourse.kanban.board.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.constant.TAG_COLOR

@Composable
fun Tag(content: String) {
    val maxLength = 5

    Box(
        modifier = Modifier
            .background(
                color = Color(TAG_COLOR),
                shape = RoundedCornerShape(45.dp),
            ),
    ) {
        Text(content.take(maxLength), modifier = Modifier.padding(6.dp), fontSize = 10.sp)
    }
}
