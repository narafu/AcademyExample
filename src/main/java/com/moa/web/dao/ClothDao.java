package com.moa.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.moa.web.entity.Cloth;
import com.moa.web.entity.CntCloth;

@Mapper
public interface ClothDao {

	@Select("SELECT * FROM ${category} WHERE memberUid = #{uid} ORDER BY regdate ASC LIMIT ${offset}, ${size}")
	public List<Cloth> getClothList(@Param("uid") String uid, @Param("category") String category,
			@Param("offset") int offset, @Param("size") int size);

	@Delete("DELETE FROM ${category} WHERE id = #{id}")
	public void delCloth(@Param("id") String id, @Param("category") String category);

	@Insert("INSERT INTO ${category}(memberUid, img) VALUES(#{uid}, #{img})")
	public void regCloth(@Param("uid") String uid, @Param("category") String category, @Param("img") String img);

	@Select("select A.memberUid, A.cntOuters, B.cntTops, C.cntBottoms, D.cntShoes, E.cntEtc from (select memberUid, count(*) cntOuters from Outers WHERE memberUid = #{uid}) A\r\n" + 
			"	join (select memberUid, count(*) cntTops from Tops WHERE memberUid = #{uid}) B on A.memberUid=B.memberUid\r\n" + 
			"		join (select memberUid, count(*) cntBottoms from Bottoms WHERE memberUid = #{uid}) C on A.memberUid=C.memberUid\r\n" + 
			"			join (select memberUid, count(*) cntShoes from Shoes WHERE memberUid = #{uid}) D on A.memberUid=D.memberUid\r\n" + 
			"				join (select memberUid, count(*) cntEtc from Etc WHERE memberUid = #{uid}) E on A.memberUid=E.memberUid;")
	public CntCloth getCount(@Param("uid") String uid);

}
