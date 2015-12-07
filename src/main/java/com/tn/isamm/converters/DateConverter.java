package com.tn.isamm.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert( String strDate) {
		Date temp = null;
		try {
			temp=new SimpleDateFormat("yyyymmdd").parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	

}
