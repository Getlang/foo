package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserUpdateController {
private IUserService userService;

public IUserService getUserService() {
	return userService;
}
@Resource
public void setUserService(IUserService userService) {
	this.userService = userService;
}
@RequestMapping("/customer/{userid}/{password}/{username}/{sex}/{birthday}/{address}/{emotion}/{email}/{sign}/userupdate")
public @ResponseBody String userUpdate(@PathVariable String userid,@PathVariable String password,@PathVariable String username,
		@PathVariable String sex,@PathVariable String birthday,@PathVariable String address,@PathVariable String emotion
		,@PathVariable String email,@PathVariable String sign){
	boolean res = userService.updateUser(userid, password, username, sex, birthday, address, emotion, email, sign);
	return "redirect:/customer/1.htm";
}


//跳轉到個人信息修改頁面。根據當前ID 獲取用戶信息
@RequestMapping("/customer/info")
public @ResponseBody String getUserInfo(Model model,HttpServletRequest req){
	User sessionUsr = (User) req.getSession().getAttribute("user");
	User user = userService.getUser(sessionUsr.getUserid());
	model.addAttribute("user",user);
	return "/customer/information";
}

}
