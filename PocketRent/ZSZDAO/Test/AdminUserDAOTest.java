import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import com.zsz.dao.utils.AdminUserDAO;
import com.zsz.dto.AdminUserDTO;
import com.zsz.tools.CommonUtils;

public class AdminUserDAOTest {

	@Test
	public void testAddAdminUser() {
		AdminUserDAO dao = new AdminUserDAO();
		long u1Id = dao.addAdminUser("abc", "15578546655", "123", "1847@163.com", 1L); //int只能装箱成 Integer 不能转成Long
		long u2Id = dao.addAdminUser("bds", "155785462332", "123", "1847@163.com", null); 
		AdminUserDTO u1 = dao.getByPhoneNum("15578546655");
		assertNotNull(u1);
		
		AdminUserDTO u2 = dao.getByPhoneNum("155785462332");
		assertNotNull(u2);
		
		AdminUserDTO u3 = dao.getById(u1Id);
		assertNotNull(u3);
		AdminUserDTO u4 = dao.getById(u2Id);
		assertNotNull(u4);
	}
	
	@Test
	public void testUpdateAdminUser() {
		AdminUserDAO dao = new AdminUserDAO();
		dao.updateAdminUser(1, "haha","123", "123@163.com", 3L);
		AdminUserDTO u1 = dao.getById(1);
		
		assertEquals((long)u1.getCityId(), 3);
		assertEquals(u1.getCityName(), "深圳");
		assertEquals(u1.getEmail(), "123@163.com");
		assertEquals(u1.getName(), "haha");
		assertEquals(u1.getPasswordHash().toLowerCase(), CommonUtils.calcMD5("123").toLowerCase());
	}
	
	@Test
	public void testCheckLogin()
	{
		AdminUserDAO dao = new AdminUserDAO();
		assertTrue(dao.checkLogin("18911111111", "123456"));
		assertFalse(dao.checkLogin("18911111111", "aaaa"));
		assertFalse(dao.checkLogin("18911111111", "123"));
		
	}
	
	
	@Test
	public void testHasPermission()
	{
		AdminUserDAO dao = new AdminUserDAO();
		assertFalse(dao.hasPermission(1, "House.Haha"));
		assertTrue(dao.hasPermission(1, "AdminUser.Query"));
	}
	
	@AfterClass
	public static void tearClassAfter()
	{
		
	}
	

}
