package dao.test;


import dao.AdminMapper;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.IDisplayService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/resources/springmvc-servlet.xml"})
public class SubmissionMapperTest extends TestCase {

	@Resource
	public AdminMapper adminMapper;

	private IDisplayService displayService;

	public IDisplayService getDisplayService() {
		return displayService;
	}

	@Resource
	public void setIDisplayService(IDisplayService displayService) {
		this.displayService = displayService;
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

/*	@Test
	public void testInsert() {
		System.out.println(11);
		Admin admin=new Admin("15605903692","admin");
		adminMapper.insert(admin);
	}
*/
/*	@Test
	public void testSelectByPrimaryKey() {
		adminMapper.deleteByPrimaryKey("15605903692");
	}
*/
	
	@Test
	public void testSelectByPrimaryKey() {
		System.out.println(displayService.PlayDesc());
	}
}
