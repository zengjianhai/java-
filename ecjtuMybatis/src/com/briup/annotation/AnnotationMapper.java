package com.briup.annotation;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.briup.pojo.Address;

public interface AnnotationMapper {
	@Insert("insert into person(id,name,age) values(#{id},#{name},#{age})")
	// @SelectKey注解来为任意SQL语句来指定主键值,自增
	@SelectKey(statement = "select my_seq.nextval from dual", keyProperty = "id", resultType = int.class, before = true)
	int insertPerson(Person person);

	@Update("update person set name=#{name}, age=#{age} where id=#{id}")
	int updatePerson(Person person);

	@Delete("delete from person where id=#{id}")
	int deleteStudent(int studId);

//	 @Select("select id, name, age from person where id=#{id}")
//	 Person findPersonById(Integer studId);

	@Select("select * from person where id=#{id}")
	@ResultMap("com.briup.annotation.AnnotationMapper.PersonResult")
	Person findPersonById(int studId);

	@Select("select * from person")
	@ResultMap("com.briup.annotation.AnnotationMapper.PersonResult")
	List<Person> findAllPersons();

	@Select("select * from address where addr_id=#{id}")
	@ResultMap("com.briup.annotation.AnnotationMapper.AddressResult")
	Address findAddressById(int id);

//	@Select("select * from person where id=#{id} ")
//	@Results(
//		{ 
//			@Result(id = true, column = "id", property = "id"), 
//			@Result(column = "name", property = "name"),
//			@Result(column = "age", property = "age"),
//			@Result(property = "address", column = "addr_id", 
//			one = @One(select = "com.briup.annotation.AnnotationMapper.findAddressById")) 
//		})
//	Person selectPersonWithAddress(int studId);
	
	//在xml中配置
	@Select("select id, name, age, a.addr_id, city, state, zip, country" + " FROM person s left outer join address a on s.addr_id=a.addr_id" + " where id=#{id} ") 
	@ResultMap("com.briup.annotation.AnnotationMapper.PersonResult") 
	Person selectPersonWithAddress(int id); 
	
}
