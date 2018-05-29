package com.ducklale.domain.converter;

public interface DucklaleConvertI<D,P> extends ConvertI {
	D toDto(P obj);
	P fromDto(D obj);
}
