<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<div id="content-categories">QnA</div>
<h1>질문하기</h1>
<form action="QuestionBoardWriteServlet" method="post"> 
<input type="hidden" name="boardCd" value="free" />
<table align="center" width="710" cellspacing="0" cellpadding="0"
				border="0"
 id="write-form" class="bbs-table">

<tr>
	<td>작성자</td><pre></pre>
	<td>글번호</td><pre></pre>
    <td>제목</td>
    <td><input type="text" name="title" style="width: 90%;" /></td><pre></pre>
</tr>
<tr>
    <td align="center" colspan="2">
        <textarea  name="content" rows="17" cols="100"></textarea><pre></pre>
    </td>
</tr>
<tr>
    <td>첨부 파일</td>
    <td><input type="file" name="attachFile" /></td><pre></pre>
</tr>
</table>
<div style="text-align: center;padding-bottom: 15px;">
    <input type="submit" value="전송" />
    <input type="button" value="취소" />
    <input type="button" value="목록" />
</div>
</form><br> 
<a href="QuestionBoardServlet">목록보기</a>
<!-- 본문 끝 -->
</body>
<!-- <form>

제목<input type="text" name="title">
작성자<input type="text" name="author">

 내용<textarea rows="10" cols="10" name="content"></textarea>
  <input type="submit" value="저장" >
</table>
</form>
<a href="QuestionBoardServlet">목록보기</a>
</body> -->
</html>