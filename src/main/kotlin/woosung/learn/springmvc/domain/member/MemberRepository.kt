package woosung.learn.springmvc.domain.member

object MemberRepository {
    private val store = HashMap<Long, Member>()
    private var sequence = 0L

    fun save(member: Member): Member {
        member.id = ++sequence
        store[member.id] = member
        return member
    }

    fun findById(id: Long): Member = store[id] ?: throw NoSuchElementException("Member with ID $id does not exist")

    fun findAll(): List<Member> = store.values.toList()

    fun clearStore() {
        store.clear()
    }
}