/**
 * 
 */
package org.kappa.springjpa.corrupcion.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author arturo
 *
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class CorrupcionRepositoryTest {

	@Autowired
	private CorrupcionRepository corrupcionRepository;
	
	@Test
	public void index() {
		List<Object[]> l = corrupcionRepository.getAllListCorruptosActividades();
		assert(l.size()>0);
	}
}
