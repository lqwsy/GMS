package com.gms.po;

import java.util.HashSet;
import java.util.Set;

public class Fieldtype {
	private long fieldtypeId;
	private String fieldtypeName;
	private Set<Fieldinfo> fieldinfos = new HashSet();

	public long getFieldtypeId() {
		return fieldtypeId;
	}

	public void setFieldtypeId(long fieldtypeId) {
		this.fieldtypeId = fieldtypeId;
	}

	public String getFieldtypeName() {
		return fieldtypeName;
	}

	public void setFieldtypeName(String fieldtypeName) {
		this.fieldtypeName = fieldtypeName;
	}

	public Set<Fieldinfo> getFieldinfos() {
		return fieldinfos;
	}

	public void setFieldinfos(Set<Fieldinfo> fieldinfos) {
		this.fieldinfos = fieldinfos;
	}

	@Override
	public String toString() {
		return "Fieldtype [fieldtypeId=" + fieldtypeId + ", fieldtypeName=" + fieldtypeName + ", fieldinfos="
				+ fieldinfos + "]";
	}

}
