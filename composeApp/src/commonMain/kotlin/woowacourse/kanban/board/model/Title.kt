package woowacourse.kanban.board.model

@JvmInline
value class Title(val content: String) {
    init {
        require(content.isNotBlank()) { throw IllegalArgumentException("[ERROR] 제목의 내용이 존재해야 합니다.") }
    }
}
