/**
 * 
 */
package org.kappa.springjpa.corrupcion.repository;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.kappa.springjpa.corrupcion.model.Corrupto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



/**
 * @author arturo
 *
 */

@SpringBootTest
//@RunWith(Spring)

public class CorrupcionRepositoryTest {

//	@Autowired
//	CorrupcionRepository corrupcionRepository;
	
//	@Test
//	public void index() {
//		//List<Object[]> l = corrupcionRepository.getAllListCorruptosActividades();
//		assertNotNull(corrupcionRepository);
//		Optional<List<Corrupto>> l = corrupcionRepository.getByNome();
//		assert(l.get().size()>0);
//	}
	
	@Test
	//@Ignore
	public void connectionPoolTest() {
		
		String url = "jdbc:mysql://localhost:3306/corrupciondb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		String user = "arturo";
		String pwd = "";
		String sqlQuery = "select * from corruptos";
		List<Corrupto> corruptos = new ArrayList<>();
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(pwd);
		assertNotNull(ds);
		try {
			Connection con = ds.getConnection();
			PreparedStatement pst = con.prepareStatement(sqlQuery);
			ResultSet rs = pst.executeQuery();
			Corrupto c;
			while (rs.next()) {
				System.out.println(rs.getString("nome") + " " + rs.getString("partido"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
