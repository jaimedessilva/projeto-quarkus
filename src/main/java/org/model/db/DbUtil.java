/**
 * 
 */
package org.model.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author jaime
 *
 */
public class DbUtil {
	
	public EntityManager getConn () {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_app");
		EntityManager em = factory.createEntityManager();
		return em;
	}
	
}
