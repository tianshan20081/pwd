


import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataBaseTest {

	@Test
	public void test() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		
		Connection conn = dataSource.getConnection();
		System.out.println(conn);

	}
}
