package com.seeyon.apps.xd.menu;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.seeyon.ctp.menu.check.AbstractMenuCheck;

public class MenuCheck4XdGroupAdmin extends AbstractMenuCheck {
	private static final Log LOG = LogFactory.getLog(MenuCheck4XdGroupAdmin.class);

	@Override
	public boolean check(long memberId, long loginAccountId) {
		
		return true;
	}

}