package entity;

public class Userlikes {
    private String userid;

    private String likes;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getlikes() {
        return likes;
    }

    public void setlikes(String likes) {
        this.likes = likes == null ? null : likes.trim();
    }

	@Override
	public String toString() {
		return "Userlikes [userid=" + userid + ", likes="
				+ likes + "]";
	}

	public Userlikes() {
		super();
	}

	public Userlikes(String userid, String likes) {
		super();
		this.userid = userid;
		this.likes = likes;
	}
    
    
}