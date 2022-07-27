package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bo.Item;

/**
 * Session Bean implementation class SessionItem
 */
@Stateless
@LocalBean
public class SessionItem {
	
	@PersistenceContext
	EntityManager em;
	
    public SessionItem() {
        // TODO Auto-generated constructor stub
    }
    
    
    public List<Item> selectAll(){
    	return em.createQuery("SELECT i FROM Item i").getResultList();
    }
    
    public void add(Item item){
    	em.persist(item);
    }
    
    public Item selectOne(int pk){
    	return em.find(Item.class,pk);
    }
    
    public void delete(int pk) {
    	Item item = selectOne(pk);
    	em.remove(item);
    	//em.flush();
    }
    

}
