package com.hbdl.common.editor;

import com.hbdl.common.utils.DateUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.util.Date;

public class DateEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			setValue(DateUtils.parseDate(text));
		}
	}

	@Override
	public String getAsText() {
		String date= DateUtils.formatDate((Date) getValue());
		return date;
	}
}
