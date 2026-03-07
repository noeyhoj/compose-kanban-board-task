package woowacourse.kanban.board.model

@JvmInline
value class Nickname(val nickname: String) {
    init {
        require(nickname.isNotBlank()) { throw IllegalArgumentException("[ERROR] 닉네임이 비어있으면 안됩니다.") }
    }
}
