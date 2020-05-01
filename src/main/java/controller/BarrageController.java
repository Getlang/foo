package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.Barrage;
import entity.JsonResult;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BarrageController {
private service.IBarrageService barrageService;

public service.IBarrageService getBarrageService() {
	return barrageService;
}
@Resource
public void setBarrageService(service.IBarrageService barrageService) {
	this.barrageService = barrageService;
}
@RequestMapping(value="/customer/restBarrageJson", method = RequestMethod.GET)
public @ResponseBody
JsonResult<Barrage> showBarrage(int pageSize, int pageNum, String sort, String order, HttpServletRequest req) {
	int pn=pageNum/10+1;
	User user=(User) req.getSession().getAttribute("user");
	PageHelper.startPage(pn,pageSize,sort+" "+order);		
	PageInfo<entity.Barrage> page = new PageInfo<entity.Barrage>(barrageService.uniteBarrage(user.getUserid()));
	return new JsonResult<entity.Barrage>(page);
}
@RequestMapping(value = "/customer/{barrageid}/restBarrageJson", method = RequestMethod.DELETE)
public @ResponseBody
entity.JsonResult barrageidDelete(@PathVariable int barrageid) {
	boolean res = barrageService.deleteBarrage(barrageid);
	if (res) {
		return new entity.JsonResult("删除成功");
	} else {
		return new entity.JsonResult(entity.JsonResult.ERROR, "删除失败！");
	}
}
@RequestMapping("/{userid}/getBarragePage")
public @ResponseBody JsonResult<entity.Barrage> getPage(@PathVariable String userid){
	PageHelper.startPage(1,3);
	List<entity.Barrage> barrage = barrageService.findAllBarrage(userid);
	PageInfo<entity.Barrage> page = new PageInfo<entity.Barrage>(barrage);
	return new JsonResult<entity.Barrage>(page);
}
}
