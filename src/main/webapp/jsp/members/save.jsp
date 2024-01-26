<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/26/24
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="woosung.learn.springmvc.domain.member.MemberRepository" %>
<%@ page import="woosung.learn.springmvc.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.INSTANCE;

    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(0, username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%>></li>
    <li>username=<%=member.getUsername()%>></li>
    <li>age=<%=member.getAge()%>></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
