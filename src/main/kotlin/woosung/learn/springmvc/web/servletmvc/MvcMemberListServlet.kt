package woosung.learn.springmvc.web.servletmvc

import jakarta.servlet.RequestDispatcher
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import woosung.learn.springmvc.domain.member.Member
import woosung.learn.springmvc.domain.member.MemberRepository

@WebServlet(name = "mvcMemberListServlet", urlPatterns = ["/servlet-mvc/members"])
class MvcMemberListServlet : HttpServlet() {
    private val memberRepository = MemberRepository

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val members: List<Member> = memberRepository.findAll()

        request.setAttribute("members", members)

        val viewPath = "/WEB-INF/views/members.jsp"
        val dispatcher: RequestDispatcher = request.getRequestDispatcher(viewPath)
        dispatcher.forward(request, response)
    }
}