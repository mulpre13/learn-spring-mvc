package woosung.learn.springmvc.web.servlet

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import woosung.learn.springmvc.domain.member.Member
import woosung.learn.springmvc.domain.member.MemberRepository

@WebServlet(name = "memberSaveServlet", urlPatterns = ["/servlet/members/save"])
class MemberSaveServlet : HttpServlet() {
    private val memberRepository = MemberRepository

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        val username: String = req.getParameter("username")
        val age: Int = Integer.parseInt(req.getParameter("age"))

        val member = Member(0, username, age)
        memberRepository.save(member)

        resp.contentType = "text/html"
        resp.characterEncoding = "utf-8"

        val writer = resp.writer
        writer.write(
            """
            <html>
            <head>
                <meta charset="UTF-8">
            </head>
            <body>
            성공
            <ul>
                <li>id=${member.id}</li>
                <li>username=${member.username}</li>
                <li>age=${member.age}</li>
            </ul>
            <a href="/index.html">메인</a>
            </body>
            </html>
        """.trimIndent()
        )
    }
}