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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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

@Composable
@Preview(showBackground = true)
fun App() {
    CheckerScreen()
}

@Composable
fun CheckerScreen() {
    var checked by remember { mutableStateOf(true) }

    CheckerView(checked = checked) {
        checked = !checked
    }
}

@Composable
fun CheckerView(checked: Boolean, check: () -> Unit) {
    Column {
        Checkbox(
            checked = checked,
            onCheckedChange = { check() },
        )
        if (checked) Text(text = "체크됨!!!")
    }
}

// 1. comp
// 2. 함수에서 option + enter
// 3. 직접 작성
// option + command + l -> 코드 깔끔하게

// 텍스트 예제
@Composable
@Preview(showBackground = true)
fun TextExample() {
    Text(text = "Jetpack Compose Text 실습", fontSize = 22.sp, color = Color.Blue, fontWeight = FontWeight.Bold)
}

@Composable
@Preview(showBackground = true)
fun ImageExample() {
    Image(painter = painterResource(Res.drawable.planet), contentDescription = "행성이 사진")
}

@Composable
@Preview(showBackground = true)
fun IconExample() {
    Icon(imageVector = Icons.Default.Favorite, contentDescription = "기본 하트")
}

@Composable
@Preview(showBackground = true)
fun ButtonExample1() {
    Button(
        onClick = {
            println("버튼 클릭")
        },
    ) {
        Text("버튼")
    }
}

@Composable
@Preview(showBackground = true)
fun ButtonExample2() {
    Button(
        onClick = {
            println("버튼 클릭")
        },
    ) {
        Icon(imageVector = Icons.Default.Favorite, contentDescription = "아이콘 버튼의 하트 아이콘")
    }
}

@Composable
@Preview(showBackground = true)
fun ButtonExample3() {
    Button(
        onClick = {
            println("버튼 클릭")
        },
    ) {
        Row {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "아이콘 버튼의 하트 아이콘")
            Text("좋아요")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BoxExample() {
    Box(
        modifier = Modifier.size(200.dp),
    ) {
        Box(
            modifier = Modifier.size(50.dp).background(color = Color.Red).align(Alignment.TopStart),
        )
        Box(
            modifier = Modifier.size(50.dp).background(color = Color.Yellow).align(Alignment.Center),
        )
        Box(
            modifier = Modifier.size(50.dp).background(color = Color.Green).align(Alignment.BottomEnd),
        )
    }
}

@Composable
@Preview(showBackground = true)
fun KanbanBoardMax() {
    Box(
        modifier = Modifier
            .height(235.dp)
            .border(width = 1.dp, color = Color(0xffE5E7EB), shape = RoundedCornerShape(15.dp))
            .width(270.dp)
            .padding(12.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            // 제목
            Box {
                Text("너무너무 긴 제목은 한 줄까지만 노출합니다.", fontSize = 16.sp, overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
            // 중간 내용
            Box {
                Text(
                    "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출합니다.",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    fontSize = 14.sp,
                    color = Color(0xff4A5565),
                )
            }
            // 태그
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Box(
                    modifier = Modifier.background(color = Color(0xffF3F4F6), shape = RoundedCornerShape(45.dp)),
                ) {
                    Text("너무너무", modifier = Modifier.padding(6.dp), fontSize = 10.sp)
                }
                Box(
                    modifier = Modifier.background(color = Color(0xffF3F4F6), shape = RoundedCornerShape(45.dp)),
                ) {
                    Text("긴 태그", modifier = Modifier.padding(6.dp), fontSize = 10.sp)
                }
                Box(
                    modifier = Modifier.background(color = Color(0xffF3F4F6), shape = RoundedCornerShape(45.dp)),
                ) {
                    Text("최대로", modifier = Modifier.padding(6.dp), fontSize = 10.sp)
                }
                Box(
                    modifier = Modifier.background(color = Color(0xffF3F4F6), shape = RoundedCornerShape(45.dp)),
                ) {
                    Text("5자까지", modifier = Modifier.padding(6.dp), fontSize = 10.sp)
                }
                Box(
                    modifier = Modifier.background(color = Color(0xffF3F4F6), shape = RoundedCornerShape(45.dp)),
                ) {
                    Text("5개제한임", modifier = Modifier.padding(6.dp), fontSize = 10.sp)
                }
            }
            // 구분선
            HorizontalDivider(thickness = 2.dp)
            // 작성자
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp, 25.dp).clip(CircleShape)
                        .border(width = 2.dp, color = Color.Gray)
                        .background(color = Color.Gray),
                )
                Text("너무너무너무 긴 담당자도 한 줄까지만 노출합니다.", overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun KanbanBoardCase1() {
    Box(
        modifier = Modifier
            .height(215.dp)
            .border(width = 1.dp, color = Color(0xffE5E7EB), shape = RoundedCornerShape(15.dp))
            .width(270.dp)
            .padding(12.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            // 제목
            Box {
                Text("LazyColumn 컴포넌트 구현", fontSize = 16.sp, overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
            // 중간 내용
            Box {
                Text(
                    "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    fontSize = 14.sp,
                    color = Color(0xff4A5565),
                )
            }
            // 태그
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Box(
                    modifier = Modifier.background(color = Color(0xffF3F4F6), shape = RoundedCornerShape(45.dp)),
                ) {
                    Text("컴포넌트", modifier = Modifier.padding(6.dp), fontSize = 10.sp)
                }
                Box(
                    modifier = Modifier.background(color = Color(0xffF3F4F6), shape = RoundedCornerShape(45.dp)),
                ) {
                    Text("성능", modifier = Modifier.padding(6.dp), fontSize = 10.sp)
                }
            }
            // 구분선
            HorizontalDivider(thickness = 2.dp)
            // 작성자
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp).clip(CircleShape)
                        .border(width = 2.dp, color = Color.Gray)
                        .background(color = Color.Gray),
                )
                Text("다이노", overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun KanbanBoardCase2() {
    Box(
        modifier = Modifier
            .height(150.dp)
            .border(width = 1.dp, color = Color(0xffE5E7EB), shape = RoundedCornerShape(15.dp))
            .width(270.dp)
            .padding(12.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            // 제목
            Box {
                Text("LazyColumn 컴포넌트 구현", fontSize = 16.sp, overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
            // 태그
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Box(
                    modifier = Modifier.background(color = Color(0xffF3F4F6), shape = RoundedCornerShape(45.dp)),
                ) {
                    Text("컴포넌트", modifier = Modifier.padding(6.dp), fontSize = 10.sp)
                }
                Box(
                    modifier = Modifier.background(color = Color(0xffF3F4F6), shape = RoundedCornerShape(45.dp)),
                ) {
                    Text("성능", modifier = Modifier.padding(6.dp), fontSize = 10.sp)
                }
            }
            // 구분선
            HorizontalDivider(thickness = 2.dp)
            // 작성자
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp).clip(CircleShape)
                        .border(width = 2.dp, color = Color.Gray)
                        .background(color = Color.Gray),
                )
                Text("다이노", overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun KanbanBoardCase3() {
    Box(
        modifier = Modifier
            .height(170.dp)
            .border(width = 1.dp, color = Color(0xffE5E7EB), shape = RoundedCornerShape(15.dp))
            .width(270.dp)
            .padding(12.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            // 제목
            Box {
                Text("LazyColumn 컴포넌트 구현", fontSize = 16.sp, overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
            // 중간 내용
            Box {
                Text(
                    "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    fontSize = 14.sp,
                    color = Color(0xff4A5565),
                )
            }
            // 구분선
            HorizontalDivider(thickness = 2.dp)
            // 작성자
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp).clip(CircleShape)
                        .border(width = 2.dp, color = Color.Gray)
                        .background(color = Color.Gray),
                )
                Text("다이노", overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun KanbanBoardCase4() {
    Box(
        modifier = Modifier
            .height(120.dp)
            .border(width = 1.dp, color = Color(0xffE5E7EB), shape = RoundedCornerShape(15.dp))
            .width(270.dp)
            .padding(12.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            // 제목
            Box {
                Text("LazyColumn 컴포넌트 구현", fontSize = 16.sp, overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
            // 구분선
            HorizontalDivider(thickness = 2.dp)
            // 작성자
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp).clip(CircleShape)
                        .border(width = 2.dp, color = Color.Gray)
                        .background(color = Color.Gray),
                )
                Text("다이노", overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
        }
    }
}
