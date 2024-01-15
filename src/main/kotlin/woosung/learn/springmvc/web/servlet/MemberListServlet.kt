package woosung.learn.springmvc.web.servlet

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import woosung.learn.springmvc.domain.member.MemberRepository

@WebServlet(name = "memberListServlet", urlPatterns = ["/servlet/members"])
class MemberListServlet : HttpServlet() {
    private val memberRepository = MemberRepository

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.contentType = "text/html"
        resp.characterEncoding = "utf-8"

        val members = memberRepository.findAll()

        val writer = resp.writer
        writer.write(
            """
                <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>
                    <a href="/index.html">메인</a>
                    <table>
                        <thead>
                            <th>id</th>
                            <th>username</th>
                            <th>age</th>
                        </thead>
                        <tbody>
            """.trimIndent()
        )
        for (member in members) {
            writer.write(
                """
                     <tr>
                         <td>${member.id}</td>
                         <td>${member.username}</td>
                         <td>${member.age}</td>
                     </tr>
                """.trimIndent()
            )
        }
        writer.write(
            """
                 </tbody>
                 </table>
                 </body>
                 </html>
            """.trimIndent()
        )

    }
}