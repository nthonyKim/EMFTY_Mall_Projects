package com.admin;

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

import com.dto.GoodsDTO;
import com.service.GoodsService;

/**
 * Servlet implementation class AdminGoodsUpdateServlet
 */
@WebServlet("/AdminGoodsUpdateServlet")
public class AdminGoodsUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}//

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart) {		
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Configure a repository (to ensure a secure temp location is used)
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository 
			= (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
	      //upload.setFileSizeMax(1024*1024*5); //5M
	      //upload.setSizeMax(1024*1024*10); //10M
			
			//Create a progress listener
		       ///////////////////////////////////////////////
				ProgressListener progressListener =
						new ProgressListener(){
				   private long megaBytes = -1;
				   public void update(long pBytesRead, long pContentLength, int pItems) {
				       long mBytes = pBytesRead / 1000;
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
				
				upload.setProgressListener(progressListener);
				///////////////////////////////////////////////	
			
			
			
			
			
			
			
			
			
			
			
			
			// Parse the request
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String value = "";
			String fileName = "";
			List<String> list = new ArrayList<String>();
			long sizeInBytes = 0;
			HashMap<String, String> dto_info = new HashMap<>();	
			//List<String> dto_info = new ArrayList<>();
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (item.isFormField()) {
					// type="file" 아닌것.
					String name = item.getFieldName();
					 value = item.getString("UTF-8");
					System.out.println(name + "\t" + value);
					dto_info.put(name, value);
					//dto_info.add(value);
			
				} else {
					// type="file" 것.
					String fieldName = item.getFieldName();
					System.out.println(item.getFieldName());
					 fileName = item.getName();//+System.currentTimeMillis();
					String contentType = item.getContentType();
					boolean isInMemory = item.isInMemory();
					 sizeInBytes = item.getSize();
					File uploadedFile = new File("c:\\upload\\",fileName);
					
				    try {
						item.write(uploadedFile);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				list.add(fileName);
				
			}//반복
			String goods_Code = dto_info.get("goods_Code");
			GoodsDTO dto = new GoodsDTO(); 
			dto.setGoods_Image1(dto_info.get("goods_Image1"));
			dto.setGoods_Image2(dto_info.get("goods_Image2"));
			dto.setGoods_Code(goods_Code);
			dto.setGoods_Category(dto_info.get("goods_Category"));
			dto.setGoods_Brand(dto_info.get("goods_Brand"));
			dto.setGoods_Name(dto_info.get("goods_Name"));
			dto.setGoods_Content(dto_info.get("goods_Content"));
			dto.setGoods_Color(dto_info.get("goods_Color"));
			dto.setGoods_Price(dto_info.get("goods_Price"));
			System.out.println(dto);		
			GoodsService service = new GoodsService();
			int n = service.adminGoodsUpdate(dto);
			response.sendRedirect("AdminPageServlet");
			}
	}

}
