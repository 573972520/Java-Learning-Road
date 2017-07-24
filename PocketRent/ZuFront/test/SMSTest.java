import static org.junit.Assert.*;

import org.junit.Test;

import com.zsz.front.Utils.RuPengSMSAPI;
import com.zsz.front.Utils.RuPengSMSResult;

public class SMSTest {

	@Test
	public void test() {
		RuPengSMSResult r1 = RuPengSMSAPI.send("1212", "18922222222");
		assertNotNull(r1);
		assertEquals(r1.getCode(), 0);
		
		RuPengSMSResult r2 = RuPengSMSAPI.send("1212", "1892222");
		assertEquals(r2.getCode(), 405);
	}

}
