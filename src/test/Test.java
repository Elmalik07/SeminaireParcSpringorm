package test;

import com.cours.dao.IProfil;
import com.cours.dao.IRoles;
import com.cours.dao.IUser;
import com.cours.dao.ProfilImpl;
import com.cours.dao.RolesImpl;
import com.cours.dao.UserImpl;
import com.cours.entities.Profil;
import com.cours.entities.Roles;
import com.cours.entities.User;


public class Test {
	
	public static void main(String[] args) {
		IProfil profil_dao = new ProfilImpl();
		
		Profil profil = new Profil();
		profil.setId(2);
		profil.setLibP("RH");
		
		//System.out.println(profil_dao.add(profil));
		
		for(Profil p:profil_dao.getAllProfils()) {
			System.out.println("ID : " + p.getId());
			}
		
		/*profil_dao.getAllProfils().stream().forEach(pr->{
							System.out.println(pr.getId() +" "+ pr.getLibP() +" "+ pr.getUsers.size());
								for(User u:pr.getUsers()){
									System.out.println("Email : " + u.getEmail());
									}
								System.out.println("************************");
		});*/
		
		/*Roles role1 = new Roles();
		role1.setId(1);
		role1.setLibR("ADMIN");
		Roles role2 = new Roles();
		role2.setId(2);
		role2.setLibR("SUPERADMIN");
		Roles role3 = new Roles();
		role3.setId(3);
		role3.setLibR("USER");
		
		IRoles role_dao = new RolesImpl();
		role_dao.add(role1);
		role_dao.add(role2);
		role_dao.add(role3);
		System.out.println("Roles ajoutés");*/
		
		/*User user1 = new User();
		user1.setNomU("FALL");
		user1.setPrenomU("AHMED");
		user1.setEmail("ahmed.fall@test.com");
		user1.setPassword("passer");
		user1.setProfil(new ProfilImpl().get(1));
		
		User user2 = new User();
		user2.setId(1);
		user2.setNomU("FALL");
		user2.setPrenomU("AHMED");
		user2.setEmail("ahmed.fall@test.com");
		user2.setPassword("passer");
		user2.setProfil(new ProfilImpl().get(2));
		
		IUser user_dao = new UserImpl();
		user_dao.add(user1);
		user_dao.add(user2);
		
		System.out.println("User ajouté avec succès");*/
		
		//recuperation d'un user
		IUser user_dao = new UserImpl();
		User user1 = user_dao.get(1);
		User user2 = user_dao.get(2);
		//recuperration d'un role
		IRoles role_dao = new RolesImpl();
		Roles role1 = role_dao.get(3);
		Roles role2 = role_dao.get(1);
		//ajout du role
		user1.getRoles().add(role1);
		user2.getRoles().add(role2);
		//gestion de user_roles
		user_dao.update(user1);
		user_dao.update(user2);
		System.out.println("Role affecté");
		
		
		

	}

}
