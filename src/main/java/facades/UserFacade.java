package facades;

import com.google.common.base.Strings;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;

import security.errorhandling.AuthenticationException;

import java.util.List;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVerifiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            TypedQuery<User> q = em.createQuery("SELECT u from User u WHERE u.username = :username", User.class);
            q.setParameter("username", username);
            user = q.getSingleResult();

            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    public User create(String username, String password, List<String> roles) {
        EntityManager em = emf.createEntityManager();
        try {
            if ((Strings.isNullOrEmpty(username) || username.length() < 3) || (Strings.isNullOrEmpty(password) || password.length() < 3))
                throw new WebApplicationException("Username and/or password should be more than 3 characters!", 400);

            throw new UnsupportedOperationException();
        } finally {
            em.close();
        }
    }
}