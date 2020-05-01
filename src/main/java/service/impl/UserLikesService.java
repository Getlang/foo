package service.impl;

import dao.UserMapper;
import dao.UserlikesMapper;
import dao.VideoMapper;
import entity.Userlikes;
import entity.UserlikesExample;
import entity.Video;
import entity.VideoExample;
import org.springframework.stereotype.Service;
import service.IUserLikesService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserLikesService implements IUserLikesService {

	private UserMapper userMapper;
	private VideoMapper videoMapper;
	private UserlikesMapper userlikesMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Resource
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public VideoMapper getVideoMapper() {
		return videoMapper;
	}

	@Resource
	public void setVideoMapper(VideoMapper videoMapper) {
		this.videoMapper = videoMapper;
	}

	public UserlikesMapper getLikesMapper() {
		return userlikesMapper;
	}

	@Resource
	public void setLikesMapper(UserlikesMapper likesMapper) {
		this.userlikesMapper = likesMapper;
	}

	@Override
	public List<Integer> videoidlist(String userid) {//将用户收藏的videoid封装成一个list
		UserlikesExample se1 = new UserlikesExample();
		UserlikesExample.Criteria sec1 = se1.createCriteria();
		sec1.andUseridEqualTo(userid);
		List<Userlikes> list = userlikesMapper.selectByExample(se1);
		List<Integer> kkk = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			kkk.add(Integer.parseInt(list.get(i).getlikes()));
		}
		return kkk;
	}

	@Override
	public List<Video> findbyvid(String userid) { //根据videoid的list去查video对象集合
		List<Integer> list = videoidlist(userid);
		List<Video> vlist = new ArrayList<Video>();
		for(int i=0;i<list.size();i++){
			VideoExample se = new VideoExample();
			VideoExample.Criteria sec = se.createCriteria();
			sec.andVideoidEqualTo(list.get(i));
			vlist.addAll(videoMapper.selectByExample(se));
		}
		return vlist;
	}

	@Override
	public Video findvbyi(String vid) {
		// TODO 自动生成的方法存根
		return videoMapper.selectByPrimaryKey(Integer.parseInt(vid));
	}

	@Override
	public List<Userlikes> findAllUserlikes(String userid) {
		return userlikesMapper.selectById(userid);
	}

	@Override
	public boolean deleteUserlikes(String userid, String likes) {
		return userlikesMapper.deleteByidcoll(userid, likes) > 0;
	}

	@Override
	public boolean addUserlikes(Userlikes ulikes) {
		return userlikesMapper.insertSelective(ulikes) > 0;
	}

	@Override
	public boolean delUserlikes(String userid, String videoid) {
		// TODO 自动生成的方法存根
		return userlikesMapper.deleteByidcoll(videoid, userid)>0;
	}

}
