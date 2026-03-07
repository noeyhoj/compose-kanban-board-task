package woowacourse.kanban.board.model

class Tags(val tags: List<String> = listOf()) {
    init {
        require(tags.size <= 5) { throw IllegalArgumentException("[ERROR] 테그의 개수는 5개 이하로 작성해야 합니다.") }
    }
}
