package org.twiliofaces.example.repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;
import org.twiliofaces.example.model.UserAuth;

@Stateless
@LocalBean
public class UserAuthRepository {

	@PersistenceContext
	EntityManager em;

	Logger logger = Logger.getLogger(getClass());

	@SuppressWarnings("unchecked")
	public UserAuth findByPhoneNumber(String phoneNumber) {
		try {
			List<UserAuth> list = em
					.createQuery(
							"select t from UserAuth t where t.phoneNumber = :PHONENUMBER")
					.setParameter("PHONENUMBER", phoneNumber).getResultList();
			if (list != null && list.size() > 0)
				return list.get(0);
			return null;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
