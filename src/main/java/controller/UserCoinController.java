package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.Video;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IUserCoinService;

import javax.annotation.Resource;
import java.util.List;

@Controller

public class UserCoinController {

	private IUserCoinService usercoinService;

	public IUserCoinService getAdminService() {
		return usercoinService;
	}

	@Resource
	public void setUserCoinService(IUserCoinService usercoinService) {
		this.usercoinService = usercoinService;
	}

	@RequestMapping("/customer/{page}/{userid}/coin")
	public String contribute(@PathVariable int page,@PathVariable String userid,
			Model model) {
		    PageHelper.startPage(page, 100);//这个分页pages永远是1？
			List<Video> v = usercoinService.findbyvid(userid);
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
	@RequestMapping("/customer/{vid}/{uid}/dislike3")
	public String dislike(@PathVariable String vid, @PathVariable String uid,Model model) {
		boolean res = usercoinService.delUsercoin(vid,uid);
		return "redirect:/customer/templ.jsp";
	}
}
