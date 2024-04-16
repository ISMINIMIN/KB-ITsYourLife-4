package member;

import java.util.List;

public interface MemberDao {
	public void add(MemberDto dto);
	public List<MemberDto> list();
}
