package com.ducklale.domain.converter.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.ducklale.domain.Pagination;
import com.ducklale.domain.converter.DucklaleConvertI;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this class implements the transform of list objects, and the single object would be implemented by the 
 * subclasses.
 * @author Reign.Gao
 *
 * @param <D>
 * @param <P>
 */
public abstract class Converter<D,P> implements DucklaleConvertI<D, P> {
	protected static final Logger logger = LoggerFactory.getLogger(Converter.class);
	 static {
	        ConvertUtils.register(new LongConverter(null), Long.class);
	        ConvertUtils.register(new ShortConverter(null), Short.class);
	        ConvertUtils.register(new IntegerConverter(null), Integer.class);
	        ConvertUtils.register(new DoubleConverter(null), Double.class);
	        ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
	        ConvertUtils.register(new DateConverter(null), Date.class);
	    }

	public List<D> toDtoList(List<P> oList){
		if(oList==null){
			return new ArrayList<D>();
		}
		List<D> rtn = new ArrayList<D>();
		Iterator<P> iter = oList.iterator();
		while(iter.hasNext()){
			D d = toDto(iter.next());
			if(d!=null){
				rtn.add(d);
			}
		}
		return rtn;
	}
	public List<P> fromDtoList(List<D> iList){
		if( iList==null ){
			return new ArrayList<P>();
		}
		List<P> rtn = new ArrayList<P>();
		Iterator<D> iter = iList.iterator();
		while(iter.hasNext()){
			P o = fromDto(iter.next());
			if(o!=null){
				rtn.add(o);
			}
		}
		return rtn;
	}
	public Pagination<D> fromPage(Pagination<P> page){
		Pagination<D> pageD = new Pagination<>(page);
		pageD.setRecords(this.toDtoList(page.getRecords()));
		return pageD;
	}
	public String formatDate(String date,String origPartern,String formatPattern){
		try{
			DateTimeFormatter fomatterOrig = DateTimeFormatter.ofPattern(origPartern);
			 DateTimeFormatter DATEFORMATTER = new DateTimeFormatterBuilder().append(fomatterOrig)
					    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
					    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
					    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
					    .toFormatter();
			LocalDateTime origDateTime = LocalDateTime.parse(date, DATEFORMATTER);
			DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(formatPattern);
			return fomatter.format(origDateTime);
		}catch(Throwable ex){
			logger.error("date parse failed, will return a null date"+ex.getMessage(),ex);
			return null;
		}
	}
}
