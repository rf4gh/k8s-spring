package com.dxc.appl.demo.model;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WebObject implements Serializable {

	private static final long serialVersionUID = 8436535356593283495L;

	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(WebObject.class);

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		return true;
	}
}
