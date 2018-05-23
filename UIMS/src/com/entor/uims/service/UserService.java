package com.entor.uims.service;

import java.util.List;

import com.entor.uims.dao.UserDao;
import com.entor.uims.domain.User;

/**
 * 处理用户数据的业务逻辑层
 * 
 * @author Administrator
 *
 */
public class UserService {

	private UserDao userDao = new UserDao();// service的逻辑需要依赖dao的数据

	/**
	 * 验证登录名和密码
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 */
	public boolean validate(String loginName, String password) {

		// 1.获得根据登录名和密码取出的表记录对应的User对象
		User user = userDao.getByLoginNameAndPassword(loginName, password);
		// 2.判断user
		if (user == null) {
			return false;
		}
		return true;
	}

	/**
	 * 根据登录名查找用户信息
	 * 
	 * @param loginName
	 * @return
	 */
	public User getUserByLoginName(String loginName) {
		return userDao.getUserByLoginName(loginName);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<User> getAllUsers() {
		return userDao.getAll();
	}
	
	/**
	 * 根据登录名判断用户是否存在
	 * @param loginName
	 * @return
	 */
	public boolean isLoginNameExist(String loginName) {
		User user = getUserByLoginName(loginName);
		if (user == null) {
			return false;
		}
		return true;
	}

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public void saveUser(User user) {
		userDao.save(user);
	}
	/**
	 * 根据id查找用户信息
	 * @param userid
	 * @return
	 */
	public User getUserById(String userid) {
		return userDao.getUserById(userid);
	}
	/**
	 * 根据id和姓名判断用户是否存在
	 * @param userid
	 * @param oldname
	 * @return
	 */
	public boolean isNameExist(String userid, String name) {
		User user =userDao.getByIdAndName(userid,name);
		if (user == null)
			return false;
		return true;
	}
	
	public void updateNameById(String userid,String realname){
		userDao.updateNameById(userid,realname);
	}
	/**
	 * 判断用户输入的旧密码是否匹配
	 * 
	 * @param userid
	 * @param oldpass
	 * @return
	 */
	public boolean isPassExist(String userid, String oldpass) {
		User user = userDao.getUserById(userid);
		if (user != null && oldpass.equals(user.getPassword())) {
			return true;
		}
		return false;
	}

	/**
	 * 根据id修改密码
	 * 
	 * @param userid
	 * @param password
	 */
	public void updatePassById(String userid, String password) {
		userDao.updatePassById(userid, password);
	}
	
	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		userDao.save(user);
	}
	
	/**
	 * 更新用户信息
	 * 
	 * @param user
	 */
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	/**
	 * 根据用户id删除用户信息
	 * 
	 * @param userid
	 */
	public void deleteUser(String userid) {
		userDao.deleteById(userid);
	}
	
	/**
	 * 根据用户id批量删除用户信息
	 * 
	 * @param userids
	 */
	public void batchDel(String[] userids) {
		userDao.batchDelete(userids);
	}

}

