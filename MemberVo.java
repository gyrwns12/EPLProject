
public class MemberVo {
	private String id;
	private String password;
	private String club;

	public MemberVo() {

	}

	public MemberVo(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public MemberVo(String id, String password, String club) {
		this.id = id;
		this.password = password;
		this.club = club;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getClub() {
		return club;
	}
}
