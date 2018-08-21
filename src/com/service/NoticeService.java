package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;

import com.dao.NoticeDAO;

import com.dto.NoticeDTO;

public class NoticeService {



	public List<NoticeDTO> select(HashMap<String, String> map) {
		NoticeDAO dao = new NoticeDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		List<NoticeDTO> list = null;
		try {
			list = dao.select(session,map);

			// }catch(Exception e) {
			// e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}// end select

}
