package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.Video;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IUserLikesService;

import javax.annotation.Resource;
import java.util.List;

@Controller

public class UserLikesController {

	private IUserLikesService userlikesService;

	public IUserLikesService getAdminService() {
		return userlikesService;
	}

	@Resource
	public void setUserLikesService(IUserLikesService userlikesService) {
		this.userlikesService = userlikesService;
	}

	@RequestMapping("/customer/{page}/{userid}/like")
	public String contribute(@PathVariable int page,@PathVariable String userid,
			Model model) {
		    PageHelper.startPage(page, 100);//这个分页pages永远是1？
			List<Video> v = userlikesService.findbyvid(userid);
			PageInfo<Video> pageInfo = new PageInfo<Video>(v);
			int pages = pageInfo.getPages();
			boolean isfirst = pageInfo.isIsFirstPage();
			boolean islast = pageInfo.isIsLastPage();
			model.addAttribute("video", v);
			model.addAttribute("length",v.size());
			model.addAttribute("pages", pages);
			model.addAttribute("pageNum", page);
			model.addAttribute("isfirst", isfirst);
			model.addAttribute("islast", islast);
			model.addAttribute("typeid", 0);
			model.addAttribute("userid", userid);
			return "customer/CollectionIframe";
	}


	@RequestMapping("/customer/{vid}/{uid}/dislike2")
	public String dislike(@PathVariable String vid, @PathVariable String uid,Model model) {
		boolean res = userlikesService.delUserlikes(vid,uid);
		return "redirect:/customer/templ.jsp";
	}
}
