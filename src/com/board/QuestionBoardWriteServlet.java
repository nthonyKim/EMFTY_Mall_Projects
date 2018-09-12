package com.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.dto.QuestionBoardDTO;
import com.service.QuestionBoardService;


@WebServlet("/QuestionBoardWriteServlet")
public class QuestionBoardWriteServlet extends HttpServlet {
/////
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//시간과 글번호는 자동부여로 매퍼에서 넣자 
		/*String userid = request.getParameter("userid");
		String title = request.getParameter("title"); 
		String question_content = request.getParameter("content");
		String image_name = request.getParameter("image_name"); 
		
		QuestionBoardDTO dto = new QuestionBoardDTO() ;
		dto.setImage_name(image_name);
		dto.setTitle(title);
		dto.setUserid(userid);
		dto.setQuestion_contents(question_content); 
		
		QuestionBoardService service = new QuestionBoardService();
		int n = service.write(dto); */
		
		/////////////////////////////////////////////////////////////////////////////
	
		// Check that we have a file upload request
				boolean isMultipart = ServletFileUpload.isMultipartContent(request); //false면 multipart가 아니다. 
		if(isMultipart
				) {
				// Create a factory for disk-based file items
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// Configure a repository (to ensure a secure temp location is used)
				ServletContext servletContext = this.getServletConfig().getServletContext();
				File repository 
					= (File) servletContext.getAttribute("javax.servlet.context.tempdir"); //upload폴더에 업로드 하기전에 임시저장소 ...계속 쌓임(=비워줘야함) = resource cleanup
				factory.setRepository(repository);

				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				
				
				//Create a progress listener 프로세스 업로드 상황 보고 
						ProgressListener progressListener = new ProgressListener(){ //익명, 인터페이스 
						   private long megaBytes = -1;
						   public void update(long pBytesRead, long pContentLength, int pItems) {
						       long mBytes = pBytesRead / 1000000;
						       if (megaBytes == mBytes) {
						           return;
						       }
						       megaBytes = mBytes;
						       System.out.println("We are currently reading item " + pItems);
						       if (pContentLength == -1) {
						           System.out.println("So far, " + pBytesRead + " bytes have been read.");
						       } else {
						           System.out.println("So far, " + pBytesRead + " of " + pContentLength
						                              + " bytes have been read.");
						       }
						   }
						};
						upload.setProgressListener(progressListener); //등록 
						/////////////////////////////////////////////////////////////////////////////////
				////////////////파일 크기 제한 , 디폴트 무한대 
				//upload.setFileSizeMax(1024*1024*5);
				// 1024 = 1kb ====> 5메가 ====> 파일크기 넘어갈 때 대비해서 예외처리 필요(TRY CATCH) 
				//pload.setFileSizeMax(1024*1024*10); // 10M
			


				// Parse the request
				List<FileItem> items = null ; //밖으로 빼야함 (로컬변수라서) 
				try { //파일 여러개 업로드 할 수 있으므로 List 
					 items =  upload.parseRequest(request); //parseRequest는 surround필요 (import 후에도 에러남) 
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				// Process the uploaded items
				String name = "";
				String fileName = ""; 
				String value = ""; 
				List<String> list = new ArrayList<String>(); 
				long sizeInBytes = 0;
				HashMap<String, String> sendDTO = new HashMap<>();	
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
				    FileItem item = iter.next();

				    if (item.isFormField()) { // if조건에 맞으면(=문자열 input 이라면) formfield,  아니면 else 구문으로 
				    	// type = "file" 아닌 것 (즉 FileItem class 안에는 파일인 것 아닌 것 둘 다 있다.)
				    	 name = item.getFieldName();
				         value = item.getString("UTF-8");
				        System.out.println(name+"\t"+value); //theText <<<<<<<<<<<<<<<<<<
				        	
				        	System.out.println("★★=="+value+"==============");
				        	sendDTO.put(name, value); 
				    
				        	////각각 name(userid,title, content  얻어옴) 
				    } else {
				        //type="file"인 것 
				    	String fieldName = item.getFieldName();
				
				         fileName = item.getName(); //+System.currentTimeMillis(); // current = 파일 덮어쓰기 방지위해 붙일 것 원리는 업로드시간 이용한것 
				         
				         fileName = FilenameUtils.getName(fileName); //★ 익스플로러 경로 제거 
				         System.out.println("else문에서 filename"+"\t"+fileName); 
				         String contentType = item.getContentType();
				        boolean isInMemory = item.isInMemory();
				         sizeInBytes = item.getSize();
				        File uploadedFile = new File("c:\\upload", fileName); // (디렉토리명, 파일이름) = 업로드 폴더에 "파일 네임"을 저장하겠다. 
				        try {
							item.write(uploadedFile); // = while의 fileitem 
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 

				    }
				    list.add(fileName);
				
				   
				}
				System.out.println(fileName+"라라라라라"); 
				String userid = sendDTO.get("userid");
				String title = sendDTO.get("title"); 
				String question_content = sendDTO.get("content"); 
				String image_name = fileName; 
				
				   QuestionBoardDTO dto
				   = new QuestionBoardDTO();
				   
				   dto.setUserid(userid); 
				  dto.setTitle(title); 
				  dto.setQuestion_contents(question_content); 
				  dto.setImage_name(image_name); 
				  
			System.out.println(dto); 
			QuestionBoardService service = new QuestionBoardService(); 
			int n = service.write(dto); 
		
		 
		
		
	}//
		
	response.sendRedirect("QuestionBoardServlet"); 
	} 
	
/*	question_num
	title
	author 
	content 
	wirteday 
	regdcnt */


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
