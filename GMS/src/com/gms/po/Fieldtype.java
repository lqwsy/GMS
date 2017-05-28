package com.gms.po;

import java.util.HashSet;
import java.util.Set;

public class Fieldtype {
	private long lFieldTypeId;
	private String vFieldTypeName;
	private Set<Fieldinfo> fieldinfos = new HashSet();

	public long getlFieldTypeId() {
		return lFieldTypeId;
	}

	public void setlFieldTypeId(long lFieldTypeId) {
		this.lFieldTypeId = lFieldTypeId;
	}

	public String getvFieldTypeName() {
		return vFieldTypeName;
	}

	public void setvFieldTypeName(String vFieldTypeName) {
		this.vFieldTypeName = vFieldTypeName;
	}

	public Set<Fieldinfo> getFieldinfos() {
		return fieldinfos;
	}

	public void setFieldinfos(Set<Fieldinfo> fieldinfos) {
		this.fieldinfos = fieldinfos;
	}

	@Override
	public String toString() {
		return "Fieldtype [lFieldTypeId=" + lFieldTypeId + ", vFieldTypeName=" + vFieldTypeName + ", fieldinfos="
				+ fieldinfos + "]";
	}

}
