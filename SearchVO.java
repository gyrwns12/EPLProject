
public class SearchVO {
	private String player_name, birth, club, nationality, posit, height, weight, backnumber;

	public SearchVO(String player_name, String birth, String club, String nationality, String posit, String height,
			String weight) {
		this.player_name = player_name;
		this.birth = birth;
		this.club = club;
		this.nationality = nationality;
		this.posit = posit;
		this.height = height;
		this.weight = weight;
	}

	public SearchVO(String backnumber, String player_name, String posit, String nationality) {
		this.backnumber = backnumber;
		this.player_name = player_name;
		this.posit = posit;
		this.nationality = nationality;
	}

	public String getPlayer_name() {
		return player_name;
	}

	public String getBirth() {
		return birth;
	}

	public String getClub() {
		return club;
	}

	public String getNationality() {
		return nationality;
	}

	public String getPosit() {
		return posit;
	}

	public String getHeight() {
		return height;
	}

	public String getWeight() {
		return weight;
	}

	public String getBacknumber() {
		return backnumber;
	}

}
