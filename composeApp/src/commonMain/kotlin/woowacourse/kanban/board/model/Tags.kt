package woowacourse.kanban.board.model

import woowacourse.kanban.board.constant.ERROR_TAG

class Tags(val tags: List<String> = listOf()) {
    init {
        require(tags.size <= 5) { throw IllegalArgumentException("$ERROR_TAG 테그의 개수는 5개 이하로 작성해야 합니다.") }
    }
}
