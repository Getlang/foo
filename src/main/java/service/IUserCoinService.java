package service;

import entity.Usercoin;
import entity.Video;

import java.util.List;

public interface IUserCoinService {
	List<Integer> videoidlist(String userid);
	List<Video> findbyvid(String userid);
	Video findvbyi(String vid);
	List<Usercoin> findAllUsercoin(String userid);
	boolean deleteUsercoin(String userid, String coin);
	boolean addUsercoin(Usercoin ucoin);
	boolean delUsercoin(String userid, String videoid);
}
