

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	public int idCheck(SqlSession session, String userid) {
		int n = session.selectOne("com.dto.idCheck", userid);
		return n;
	}
	
	public int memberAdd(SqlSession session, MemberDTO dto) {
		int count = session.insert("com.dto.memberAdd", dto);
		return count;
	}
	
}
