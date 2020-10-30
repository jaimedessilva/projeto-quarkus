/**
 * 
 */
package org.model;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

import org.model.db.DbUtil;

/**
 * @author jaime
 *
 */
@ApplicationScoped
public class DaoProduto {
	
	DbUtil conn = new DbUtil();
	
	public void add (ProdutoDto p) {
	
		EntityManager em = conn.getConn();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
	}
	
	
	
	
	
	
	
	

}
