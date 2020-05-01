package service;

import entity.Userlikes;
import entity.Video;

import java.util.List;

public interface IUserLikesService {
	List<Integer> videoidlist(String userid);
	List<Video> findbyvid(String userid);
	Video findvbyi(String vid);
	List<Userlikes> findAllUserlikes(String userid);
	boolean deleteUserlikes(String userid, String likes);
	boolean addUserlikes(Userlikes ulikes);
	boolean delUserlikes(String userid, String videoid);
}
