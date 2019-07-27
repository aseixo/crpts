/**
 * 
 */
package org.kappa.springjpa.corrupcion.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author arturo
 *
 */

@SpringBootTest
public class CorrupcionRepositoryTest {

	@Autowired
	CorrupcionRepository corrupcionRepository;
	
	@Test
	public void index() {
		//List<Object[]> l = corrupcionRepository.getAllListCorruptosActividades();
		assertNotNull(corrupcionRepository);
//		Optional<List<Corrupto>> l = corrupcionRepository.getByNome();
//		assert(l.get().size()>0);
	}
}
