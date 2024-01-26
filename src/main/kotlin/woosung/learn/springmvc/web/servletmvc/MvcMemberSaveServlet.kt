package woosung.learn.springmvc.web.servletmvc

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import woosung.learn.springmvc.domain.member.Member
import woosung.learn.springmvc.domain.member.MemberRepository

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = ["/servlet-mvc/members/save"])
class MvcMemberSaveServlet : HttpServlet() {
    private val memberRepository = MemberRepository

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val username = request.getParameter("username")
        val age = request.getParameter("age").toInt()

        val member = Member(0, username, age)
        memberRepository.save(member)

        request.setAttribute("member", member)

        val viewPath = "/WEB-INF/views/save-result.jsp"
        val dispatcher = request.getRequestDispatcher(viewPath)
        dispatcher.forward(request, response)
    }
}