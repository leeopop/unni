package org.sparcs.unni.dao;

import org.sparcs.unni.entity.Unni;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UnniDao {

	public Unni saveOrUpdate(Unni unni);

	public Unni searchDB(String id) throws UsernameNotFoundException;
}
