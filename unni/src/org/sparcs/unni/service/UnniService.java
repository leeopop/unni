package org.sparcs.unni.service;

import org.sparcs.unni.entity.Unni;

public interface UnniService {

	public Unni findUnni(String id);

	public Unni createUnni(String id, String real, String nick, String rawPassword);

}
