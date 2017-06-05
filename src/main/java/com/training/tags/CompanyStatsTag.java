package com.training.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.training.entities.Offer;
import com.training.entities.OfferStatusEnum;
import com.training.services.OfferService;

public class CompanyStatsTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -589577458728805218L;
	
	@Override
	public int doStartTag() throws JspException {
		String stat = "<p>Stat about offers</p>";
		int active = 0;
		int done = 0;
		int canceled = 0;
		List<Offer> totalOffers = OfferService.getAllOffers();
		for (Offer offer : totalOffers) {
			String status = offer.getStatus().toUpperCase();
			if (status.equalsIgnoreCase(OfferStatusEnum.ACTIVE.name())) {
				active++;
			} else if (status.equalsIgnoreCase(OfferStatusEnum.DONE.name())) {
				done++;
			} else if (status.equalsIgnoreCase(OfferStatusEnum.CANCELED.name())) {
				canceled++;
			}
		}
		stat += "<p>Active: " + active + "</p>";
		stat += "<p>Done: " + done + "</p>";
		stat += "<p>Canceled: " + canceled + "</p>";
		try {
			JspWriter out = pageContext.getOut();
			out.write(stat);
		} catch(IOException ex) {
			throw new JspException(ex.getMessage());
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}
