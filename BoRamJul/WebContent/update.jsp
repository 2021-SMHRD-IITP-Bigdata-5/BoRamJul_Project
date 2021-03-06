<%@page import="com.DTO.ExBoardDTO"%>
<%@page import="com.DAO.ExboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	request.setCharacterEncoding("utf-8");
%>
<%-- board 객체에 form에서 넘어온 데이터 설정 --%>
<jsp:useBean id="board" class="com.DTO.ExBoardDTO" />
<jsp:setProperty property="*" name="board" />
<%
	ExboardDAO manager = ExboardDAO.getInstance();
	ExBoardDTO oldBoard = manager.getBoard(board.getNo());
	// form에서 전달된 패스워드와 데이터베이스에 저장된 데이터가 같다면
	if (board.getPasswd().equals(oldBoard.getPasswd())) {
		manager.updateDB(board); // 업데이트 수행
%>
	<script>
		alert("수정 완료");
		location.href = "list.jsp";
	</script>
<%
	} else { // 비밀번호가 다르다면
%>
	<script>
		alert("비밀번호가 다릅니다.");
		history.go(-1);
	</script>
<%
	}
%>