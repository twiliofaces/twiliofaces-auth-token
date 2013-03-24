package org.twiliofaces.example.service;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.twiliofaces.example.model.UserAuth;
import org.twiliofaces.example.model.UserToken;
import org.twiliofaces.example.repository.UserAuthRepository;
import org.twiliofaces.example.repository.UserTokenRepository;

@Stateless
@LocalBean
public class UserTokenService {
	@Inject
	UserTokenRepository userTokenRepository;

	@Inject
	UserAuthRepository userAuthRepository;

	Logger logger = Logger.getLogger(getClass());

	public void createToken(String phoneNumber) {
		// verify if exist a user with this phoneNumber
		UserAuth user = userAuthRepository.findByPhoneNumber(phoneNumber);
		if (user != null) {
			logger.info("phone number owner: " + user.getUsername());
			Calendar cal = Calendar.getInstance();
			Date dateMin = cal.getTime();
			cal.add(Calendar.MINUTE, +15);
			Date dateMax = cal.getTime();
			// create new UserToken to enable login for limited session
			userTokenRepository.persist(new UserToken(phoneNumber, dateMin,
					dateMax));
		} else {
			logger.info("unknown phone number: " + phoneNumber);
		}
		// remove all expired tokens
		userTokenRepository.removeExpiredTokens();
	}
}
