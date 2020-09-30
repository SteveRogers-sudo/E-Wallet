package com.cg.ewallet.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class LDTConverter implements AttributeConverter<LocalDate,Date>{

	@Override
	public Date convertToDatabaseColumn(LocalDate ldt) {
		if(ldt!=null)
			return Date.valueOf(ldt);
		return null;
	}

	@Override
	public LocalDate convertToEntityAttribute(Date date) {
		if(date!=null)
			return date.toLocalDate();
		return null;
	}

}
