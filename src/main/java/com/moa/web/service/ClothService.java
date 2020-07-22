package com.moa.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moa.web.dao.ClothDao;
import com.moa.web.entity.Cloth;

@Service
public class ClothService {

	@Autowired
	ClothDao clothDao;

	public List<Cloth> getClothList(String category, String uid, int page) {

		int size = 6;
		int offset = (page - 1) * size;

		return clothDao.getClothList(category, uid, offset, size);

	}

	public void delCloth(String category, String uid, String id) {

		clothDao.delCloth(category, uid, id);
	}

}
