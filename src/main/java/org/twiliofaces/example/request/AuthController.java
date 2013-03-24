package org.twiliofaces.example.request;

import java.security.Principal;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;

@Named
@RequestScoped
public class AuthController {
	private String username;

	static Logger logger = Logger.getLogger(TwilioEvaluator.class);

	public AuthController() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest req = (HttpServletRequest) context
					.getExternalContext().getRequest();
			Principal pr = req.getUserPrincipal();
			if (pr == null) {
				return null;
			}
			return pr.getName();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
}
