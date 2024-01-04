package woosung.learn.springmvc.domain.member

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class MemberRepositoryTest : FunSpec({
    afterEach {
        MemberRepository.clearStore()
    }

    test("save") {
        val member = Member(0, "hello", 20)

        val savedMember = MemberRepository.save(member)

        val foundMember = MemberRepository.findById(savedMember.id)
        foundMember shouldBe savedMember
    }

    test("findAll") {
        val member1 = Member(0, "member1", 20)
        val member2 = Member(0, "member2", 30)

        MemberRepository.save(member1)
        MemberRepository.save(member2)

        val result: List<Member> = MemberRepository.findAll()

        result.size shouldBe 2
        result shouldContainExactly listOf(member1, member2)
    }
})
