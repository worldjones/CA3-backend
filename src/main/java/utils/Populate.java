package utils;


import com.google.common.base.Strings;
import entities.Role;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Populate {

    public void populate() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
    }

    private void populateUsers(EntityManager em) throws IllegalArgumentException {
        // NOTICE: Always set your password as environment variables.
        String password_admin = "password_admin";
        String password_user = "password_user";

        boolean isDeployed = System.getenv("DEPLOYED") != null;
        if(isDeployed) {
            password_user = System.getenv("PASSWORD_DEFAULT_USER");
            password_admin = System.getenv("PASSWORD_DEFAULT_ADMIN");

            // Do not allow "empty" passwords.
            if(Strings.isNullOrEmpty(password_admin.trim()) || Strings.isNullOrEmpty(password_user.trim()))
                throw new IllegalArgumentException("Passwords were empty? Are environment variables: [PASSWORD_DEFAULT_USER, PASSWORD_DEFAULT_ADMIN] set?");
        }

        User admin = new User("admin", password_admin);
        User user = new User("user", password_user);

        Role adminRole = new Role(Role.Roles.ADMIN);
        Role userRole = new Role(Role.DEFAULT_ROLE);

        em.getTransaction().begin();

        admin.addRole(userRole);
        admin.addRole(adminRole);

        user.addRole(userRole);

        em.persist(user);
        em.persist(admin);

        em.getTransaction().commit();


    }

}
