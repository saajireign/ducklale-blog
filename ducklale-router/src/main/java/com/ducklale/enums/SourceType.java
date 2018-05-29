package com.ducklale.enums;

import javax.xml.transform.Source;

public enum SourceType {
    READ(1),WRITE(0);

    public Integer getValue() {
        return value;
    }

    Integer value;
    SourceType(Integer v){
        this.value =v;
    }
}
