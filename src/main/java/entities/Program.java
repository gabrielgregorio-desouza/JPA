package entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Program {

	public static void main(String[] args) throws ParseException {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Sala");
	EntityManager em =  emf.createEntityManager();
	
	em.getTransaction().begin();
	DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
	
	Marca ma1 = new Marca(null, "CITROEN");
	
	Modelo mo1 = new Modelo (null,"C4 LOUNGE",187, ma1);
	
	Automovel a1 = new Automovel (null, 2017,2018,"TURBO",24.7f,44000,mo1);
	
	ma1.addModelo(mo1);
	mo1.addAutomovel(a1);
	em.persist(ma1);
	em.persist(mo1);
	em.persist(a1);
	
	
	em.close();
	emf.close();

	em.getTransaction().commit();
	
	Query query1 = em.createQuery("SELECT m FROM Marca m");
	List<Marca> Lmarca = query1.getResultList();
	for(Marca m : Lmarca) {
		System.out.println("\n *** "+ m.getNome()+ " ***");
		for (Modelo ma : m.getModelos()) {
			System.out.println("Automovel: "+ ma.getDescricao());
		}
	}
	}

}