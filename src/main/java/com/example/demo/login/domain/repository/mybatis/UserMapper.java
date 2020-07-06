package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.login.domain.model.User;

@Mapper
public interface UserMapper {

@Insert("INSERT INTO m_user("
+ " user_id,"
+ " password,"
+ " user_name,"
+ " birthday,"
+ " age,"
+ " marriage,"
+ " role)"
+ " VALUE("
+ " #{userId},"
+  "#{password},"
+  "#{userName},"
+  "#{birthday},"
+  "#{age},"
+  "#{marriage},"
+  "#{role})")

public boolean insert(User user);

@Select("SELECT user_id AS userId,"
+"password,"
+"user_name AS userName,"
+"birthday,"
+"age,"
+"marriage,"
+"role,"
+"FROM m_user,"
+"WHERE user_id = #{userId}")
public User selectOne(String userId);

@Select("SELECT usre_id AS userId,"
+"password,"
+"user_name  AS userName,"
+"birthday,"
+"age,"
+"marriage,"
+"role,"
+"FROM m_user,")
public List<User> selectmany();

@Update("UPDATE m_user SET"
+ "password = #{password},"
+ "user_name = #{userName},"
+ "password = #{birthday},"
+ "user_name = #{age},"
+ "password = #{marriage},"
+ "user_name = #{userId}")
public boolean updateOne(User user);

@Delete("DELETE FROM m_user WHERE user_id = #{userId}")
public boolean deleteOne(String userId);
}