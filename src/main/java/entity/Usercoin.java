package entity;

public class Usercoin {
    private String userid;

    private String coin;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin == null ? null : coin.trim();
    }

	@Override
	public String toString() {
		return "Usercoin [userid=" + userid + ", coin="
				+ coin + "]";
	}

	public Usercoin() {
		super();
	}

	public Usercoin(String userid, String coin) {
		super();
		this.userid = userid;
		this.coin = coin;
	}
    
    
}