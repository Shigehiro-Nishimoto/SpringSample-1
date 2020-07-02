package com.example.demo.login.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org. springframework. security. crypto. password. PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Repository("UserDaoJdbcImpl")
public class UserDaoJdbcImpl implements UserDao {

@Autowired
JdbcTemplate jdbc;

@Autowired
PasswordEncoder passwordEncoder;

//Userテーブルの件数を取得
@Override
public int count() throws DataAccessException {

	int count=jdbc.queryForObject("SELECT COUNT(*) FROM m_user", Integer.class);
	return count;
}

//Userテーブルにデータを1件Insert
@Override
public int insertOne(User user)throws
	DataAccessException {
	int a = 1;
	String password = passwordEncoder.encode(user.getPassword());

	int rowNumber = jdbc.update("INSERT INTO m_user(user_id," + "password, " + "user_name, "
			+ "birthday, " + "age, " + "marriage, " + "role)" + "VALUES(?, ?, ?, ?, ?, ?, ?)", user.getUserId(), password,
			 user.getUserName(), user.getBirthday(), user.getAge(), user.isMarriage(), user.getRole());

			return rowNumber;
}

//Userテーブルのデータを1件取得
@Override
public User selectOne(String userId)throws
	DataAccessException {

	Map<String, Object> map = jdbc.queryForMap("SELECT * FROM m_user " + "WHERE user_id = ?", userId);
	User user = new User();
	//取得したデータを結果返却用の変数にセットしていく
	user.setUserId((String)map.get("user_id"));
	user.setPassword((String)map.get("password"));
	user.setUserName((String)map.get("user_name"));
	user.setBirthday((Date)map.get("birthday"));
	user.setAge((Integer)map.get("age"));
	user.setMarriage((Boolean)map.get("marriage"));
	user.setRole((String)map.get("role"));

	return user;

}

//Userテーブルの全データを取得
@Override
public List<User> selectMany() throws
DataAccessException {
List<Map<String, Object>> getList=jdbc.queryForList("Select * FROM m_user");
List<User> userList = new ArrayList<>();
for(Map<String, Object> map:getList) {
	User user = new User();
	user.setUserId((String)map.get("user_id"));
	user.setPassword((String)map.get("password"));
	user.setUserName((String)map.get("user_name"));
	user.setBirthday((Date)map.get("birthday"));
	user.setAge((Integer)map.get("age"));
	user.setMarriage((Boolean)map.get("marriage"));
	user.setRole((String)map.get("role"));

	userList.add(user);
}
return userList;
}

//Userテーブルを１件更新
@Override
public int updateOne(User user) throws
	DataAccessException {

String password = passwordEncoder.encode(user.getPassword());

int rowNumber = jdbc.update("UPDATE M_USER" + " SET" + " password = ?," + " user_name = ?," + " birthday = ?," +
" age = ?," + " marriage = ?" + " WHERE user_id = ?"
, password
, user.getUserName()
, user.getBirthday()
, user.getAge()
, user.isMarriage()
, user.getUserId());

if(rowNumber>0){
	throw new DataAccessException("トランザクションテスト") {};
}
return rowNumber;
}

//Userテーブルを１件削除
@Override
public int deleteOne(String userId) throws
	DataAccessException {
	int rowNumber = jdbc.update("DELETE FROM m_user WHERE user_id = ?", userId);
	return rowNumber;
}

//Userテーブルの全データをCSVに出力
@Override
public void userCsvOut() throws
	DataAccessException {

	String sql = "SELECT * FROM m_user";
	UserRowCallbackHandler handler = new
	UserRowCallbackHandler();
	jdbc.query(sql, handler);
	}
}