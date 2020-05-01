package service;

import java.util.List;

import entity.Video;


public interface IDisplayService {

	List<Video> PlayDesc();
	
	List<Video> PlayDescLimit();
	
	List<Video> CollDescLimit();
	
	List<Video> TypeRanLimit(String typeid);
	
	List<Video> TopPlayByType();
	
	List<Video> TypeTopLimit(String typeid);
	
	String updateVideoPlay(String videoid);
}
