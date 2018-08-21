package com.member;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.mail.SendMail;
import com.service.MemberService;

/**
 * Servlet implementation class idFindServlet
 */
@WebServlet("/idFindServlet")
public class idFindServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");		
		MemberDTO dto = new MemberDTO();
		dto.setUsername(username);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
				
		MemberService service = new MemberService();		
		String nextPage = null;
		
		System.out.println("username "+username);
		String userid = service.idFind(dto);
		System.out.println("userid "+userid);

		if(userid==null) {
			request.setAttribute("mesg", "사용자를 찾을 수 없습니다.");
			nextPage="IdFindUIServlet";
		}else {
			nextPage="LoginUIServlet";
			//mail			
			String host = "smtp.naver.com";
		    String subject = "네이버를 이용한 메일발송";
		    String from = "bockey_@naver.com"; //보내는 메일
		    String fromName = "Test";
		    String to = email1+"@"+email2; //받는 메일
		    System.out.println("email "+to);
		    System.out.println("userId "+userid);
		    
		    String content = "귀하의 id는 "+userid+" 입니다.";

		   try{
		     //프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
		     Properties props = new Properties();
		     //네이버 SMTP 사용시
		     props.put("mail.smtp.starttls.enable","true");
		     props.put("mail.transport.protocol","smtp");
		     props.put("mail.smtp.host", host);
		     
		     props.put("mail.smtp.port","465");  // 보내는 메일 포트 설정
		     props.put("mail.smtp.user", from);
		     props.put("mail.smtp.auth","true");
		     props.put("mail.smtp.debug", "true");
		     props.put("mail.smtp.socketFactory.port", "465");
		     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		     props.put("mail.smtp.socketFactory.fallback", "false");

		     Authenticator auth = new SendMail();
		     Session mailSession = Session.getDefaultInstance(props,auth);
		   
		     Message msg = new MimeMessage(mailSession);
		     msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName,"UTF-8","B"))); //보내는 사람 설정
		    InternetAddress[] address = {new InternetAddress(to)};
		    
		     msg.setRecipients(Message.RecipientType.TO, address); //받는 사람설정
		   
		     msg.setSubject(subject); //제목설정
		    msg.setSentDate(new java.util.Date()); //보내는 날짜 설정
		    msg.setContent(content,"text/html; charset=UTF-8"); //내용 설정(MIME 지정-HTML 형식)
		    
		     Transport.send(msg); //메일 보내기

		    System.out.println("메일 발송을 완료하였습니다.");
		     }catch(MessagingException ex){
		      System.out.println("mail send error : "+ex.getMessage());
		       ex.printStackTrace();
		     }catch(Exception e){
		      System.out.println("error : "+e.getMessage());
		       e.printStackTrace();
		     }			
		}		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);		
	}//

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
