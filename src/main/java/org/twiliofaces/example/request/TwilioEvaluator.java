package org.twiliofaces.example.request;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;
import org.twiliofaces.annotations.From;
import org.twiliofaces.annotations.TwilioRequestParams;
import org.twiliofaces.example.service.UserTokenService;
import org.twiliofaces.request.TwilioRequestParamsMap;

@Named
@RequestScoped
public class TwilioEvaluator {

	static Logger logger = Logger.getLogger(TwilioEvaluator.class);

	@Inject
	UserTokenService userTokenService;

	@From
	@Inject
	private String from;

	@Inject
	@TwilioRequestParams
	private TwilioRequestParamsMap twilioRequestParamsMap;

	public TwilioEvaluator() {
	}

	@PostConstruct
	public void post() {
		logger.info("*******TWILIO REQUEST PARAMS******");
		logger.info(getTwilioRequestParamsMap());
		logger.info("***************************");
	}

	public void createToken() {
		userTokenService.createToken(getFrom());
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public TwilioRequestParamsMap getTwilioRequestParamsMap() {
		return twilioRequestParamsMap;
	}

	public void setTwilioRequestParamsMap(
			TwilioRequestParamsMap twilioRequestParamsMap) {
		this.twilioRequestParamsMap = twilioRequestParamsMap;
	}
}