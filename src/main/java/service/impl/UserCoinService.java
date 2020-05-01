package service.impl;

import dao.UserMapper;
import dao.UsercoinMapper;
import dao.VideoMapper;
import entity.Usercoin;
import entity.UsercoinExample;
import entity.Video;
import entity.VideoExample;
import org.springframework.stereotype.Service;
import service.IUserCoinService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserCoinService implements IUserCoinService {

	private UserMapper userMapper;
	private VideoMapper videoMapper;
	private UsercoinMapper usercoinMapper;

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

	public UsercoinMapper getCoinMapper() {
		return usercoinMapper;
	}

	@Resource
	public void setCoinMapper(UsercoinMapper coinMapper) {
		this.usercoinMapper = coinMapper;
	}

	@Override
	public List<Integer> videoidlist(String userid) {//将用户收藏的videoid封装成一个list
		UsercoinExample se1 = new UsercoinExample();
		UsercoinExample.Criteria sec1 = se1.createCriteria();
		sec1.andUseridEqualTo(userid);
		List<Usercoin> list = usercoinMapper.selectByExample(se1);
		List<Integer> kkk = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			kkk.add(Integer.parseInt(list.get(i).getCoin()));
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
	public List<Usercoin> findAllUsercoin(String userid) {
		return usercoinMapper.selectById(userid);
	}

	@Override
	public boolean deleteUsercoin(String userid, String coin) {
		return usercoinMapper.deleteByidcoll(userid, coin) > 0;
	}

	@Override
	public boolean addUsercoin(Usercoin ucoin) {
		return usercoinMapper.insertSelective(ucoin) > 0;
	}

	@Override
	public boolean delUsercoin(String userid, String videoid) {
		// TODO 自动生成的方法存根
		return usercoinMapper.deleteByidcoll(videoid, userid)>0;
	}

}
