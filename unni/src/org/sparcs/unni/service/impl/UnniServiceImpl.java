package org.sparcs.unni.service.impl;

import org.sparcs.unni.dao.UnniDao;
import org.sparcs.unni.entity.Unni;
import org.sparcs.unni.service.UnniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UnniServiceImpl implements UnniService {

	@Autowired
	private UnniDao unniDao;

	@Override
	public Unni createUnni(String id, String real, String nick, String rawPassword) {

		Unni newUnni = new Unni();
		newUnni.setId(id);
		newUnni.setRealName(real);
		newUnni.setNickName(nick);
		newUnni.setPassword(rawPassword);

		return unniDao.saveOrUpdate(newUnni);
	}
}
