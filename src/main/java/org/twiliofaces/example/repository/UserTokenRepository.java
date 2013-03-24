package org.twiliofaces.example.repository;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;
import org.twiliofaces.example.model.UserToken;

@Stateless
@LocalBean
public class UserTokenRepository {

	@PersistenceContext
	EntityManager em;

	Logger logger = Logger.getLogger(getClass());

	public UserToken persist(UserToken userToken) {
		try {
			getEm().persist(userToken);
			return userToken;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void removeExpiredTokens() {
		try {
			Date now = new Date();
			getEm().createQuery(
					"DELETE FROM UserToken T WHERE T.dateMax < :NOW")
					.setParameter("NOW", now).executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
