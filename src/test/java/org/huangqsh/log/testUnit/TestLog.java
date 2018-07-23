package org.huangqsh.log.testUnit;

import org.huangqsh.log.service.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-config/spring-*.xml"})
public class TestLog {
	
	@Autowired
	private LogService logService;

	@Test
	public void test() {
		logService.add();
	}

}
