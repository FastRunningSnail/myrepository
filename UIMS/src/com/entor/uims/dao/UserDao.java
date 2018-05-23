package com.entor.uims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entor.uims.domain.User;
import com.entor.uims.util.DBUtil;

/**
 * 处理User相关的数据库操作（增、删、改、查）
 * 
 * @author Administrator
 *
 */
public class UserDao {
	// ctrl+s
	// ctrl+x
	// ctrl+c
	// ctrl+v
	// ctrl+z
	// ctrl+y
	// ctrl+/:补全代码
	// ctrl+shift+f:英文格式下的快捷键，格式化代码（对齐）
	// ctrl+d:删除光标所在行/删除选中行
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * 根据登录名和密码查找用户信息
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 */
	public User getByLoginNameAndPassword(String loginName, String password) {
		User user = null;
		try {
			// 1.创建连接
			conn = DBUtil.getConn();
			// 2.编写sql句
			String sql = "select * from user_inf where loginname = ? and password = ?";
			// 3.预编译sql句
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginName);
			ps.setString(2, password);
			// 4.执行sql句
			rs = ps.executeQuery();
			// 5.遍历结果集
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setLoginName(rs.getString("loginname"));
				user.setPassword(rs.getString("password"));
				user.setRealName(rs.getString("realname"));
				user.setAuthority(rs.getInt("authority"));
				user.setCreateDate(rs.getTimestamp("createdate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, null);
		}
		return user;
	}

	/**
	 * 保存一个用户信息
	 * 
	 * @param user
	 */
	public void save(User user) {
		try {
			// 1.创建连接
			conn = DBUtil.getConn();
			// 2.编写sql句
			String sql = "insert into user_inf(loginname,`password`,realname,authority,createdate) "
					+ "values(?,?,?,?,SYSDATE());";
			// 3.预编译sql句
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getLoginName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRealName());
			ps.setInt(4, user.getAuthority());
			// 4.执行sql句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ps, conn);
		}
	}

	/**
	 * 根据登录名查询用户记录
	 * 
	 * @param loginName
	 * @return
	 */
	public User getUserByLoginName(String loginName) {
		User user = null;
		try {
			// 1.创建连接
			conn = DBUtil.getConn();
			// 2.编写sql句
			String sql = "select * from user_inf where loginname = ?";
			// 3.预编译sql句
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginName);
			// 4.执行sql句
			rs = ps.executeQuery();
			// 5.遍历结果集
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setLoginName(rs.getString("loginname"));
				user.setPassword(rs.getString("password"));
				user.setRealName(rs.getString("realname"));
				user.setAuthority(rs.getInt("authority"));
				user.setCreateDate(rs.getTimestamp("createdate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, null);
		}
		return user;
	}

	/**
	 * 根据id查询用户记录
	 * 
	 * @param userid
	 * @return
	 */
	public User getUserById(String userid) {
		User user = null;
		try {
			// 1.创建连接
			conn = DBUtil.getConn();
			// 2.编写sql句
			String sql = "select * from user_inf where id = ?";
			// 3.预编译sql句
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(userid));
			// 4.执行sql句
			rs = ps.executeQuery();
			// 5.遍历结果集
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setLoginName(rs.getString("loginname"));
				user.setPassword(rs.getString("password"));
				user.setRealName(rs.getString("realname"));
				user.setAuthority(rs.getInt("authority"));
				user.setCreateDate(rs.getTimestamp("createdate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, null);
		}
		return user;
	}

	/**
	 * 取出所有用户记录
	 * 
	 * @param userid
	 * @return
	 */
	public List<User> getAll() {
		List<User> list = new ArrayList<>();
		try {
			// 1.创建连接
			conn = DBUtil.getConn();
			// 2.编写sql句
			String sql = "select * from user_inf";
			// 3.预编译sql句
			ps = conn.prepareStatement(sql);
			// 4.执行sql句
			rs = ps.executeQuery();
			// 5.遍历结果集
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLoginName(rs.getString("loginname"));
				user.setPassword(rs.getString("password"));
				user.setRealName(rs.getString("realname"));
				user.setAuthority(rs.getInt("authority"));
				user.setCreateDate(rs.getTimestamp("createdate"));

				list.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, null);
		}
		return list;
	}

	/**
	 * 根据id和姓名查找用户信息
	 * 
	 * @param userid
	 * @param name
	 * @return
	 */
	public User getByIdAndName(String userid, String name) {
		User user = null;
		try {
			// 1.创建连接
			conn = DBUtil.getConn();
			// 2.编写sql句
			String sql = "select * from user_inf where id = ? and realname = ?";
			// 3.预编译sql句
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(userid));
			ps.setString(2, name);
			// 4.执行sql句
			rs = ps.executeQuery();
			// 5.遍历结果集
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setLoginName(rs.getString("loginname"));
				user.setPassword(rs.getString("password"));
				user.setRealName(rs.getString("realname"));
				user.setAuthority(rs.getInt("authority"));
				user.setCreateDate(rs.getTimestamp("createdate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, null);
		}
		return user;
	}

	/**
	 * 根据用户id更新姓名
	 * 
	 * @param userid
	 * @param realname
	 */
	public void updateNameById(String userid, String realname) {
		try {
			// 1.创建连接
			conn = DBUtil.getConn();
			// 2.编写sql句
			String sql = "update user_inf set realname = ? where id = ?";
			// 3.预编译sql句
			ps = conn.prepareStatement(sql);
			ps.setString(1, realname);
			ps.setInt(2, Integer.parseInt(userid));
			// 4.执行sql句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ps, conn);
		}
	}

	/**
	 * 根据id更新密码
	 * 
	 * @param userid
	 * @param password
	 */
	public void updatePassById(String userid, String password) {
		try {
			// 1.创建连接
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);// 关闭自动提交事务
			// 2.编写sql句
			String sql = "update user_inf set password = ? where id = ?";
			// 3.预编译sql句
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, Integer.parseInt(userid));
			// 4.执行sql句
			ps.executeUpdate();
			conn.commit();// 手动提交事务
			conn.setAutoCommit(true);// 打开自动提交事务
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtil.close(null, ps, conn);
		}
	}

	/*
	 * public static void main(String[] args) { List<User> list = new
	 * UserDao().getAll(); System.out.println("全部记录数：" + list.size());
	 * System.out.println("第三条记录登录名：" + list.get(2).getLoginName()); }
	 */

	/**
	 * 更新用户
	 * @param user
	 */
	public void updateUser(User user) {
		try {
			// 1.创建连接
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);// 关闭自动提交事务
			// 2.编写sql句
			String sql = "update user_inf set loginname = ?, password = ?, realname = ?, authority = ? where id = ?";
			// 3.预编译sql句
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getLoginName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRealName());
			ps.setInt(4, user.getAuthority());
			ps.setInt(5, user.getId());
			// 4.执行sql句
			ps.executeUpdate();
			conn.commit();// 手动提交事务
			conn.setAutoCommit(true);// 打开自动提交事务
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtil.close(null, ps, conn);
		}
	}
	
	/**
	 * 根据id删除用户
	 * @param userid
	 */
	public void deleteById(String userid) {
		try {
			// 1.创建连接
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);// 关闭自动提交事务
			// 2.编写sql句
			String sql = "delete from user_inf where id = ?";
			// 3.预编译sql句
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(userid));
			// 4.执行sql句
			ps.executeUpdate();
			conn.commit();// 手动提交事务
			conn.setAutoCommit(true);// 打开自动提交事务
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtil.close(null, ps, conn);
		}
	}
	/**
	 * 根据id批量删除用户
	 * @param userids
	 */
	public void batchDelete(String[] userids) {
		try {
			// 1.创建连接
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);// 关闭自动提交事务

			for (String userid : userids) {
				// 2.编写sql句
				String sql = "delete from user_inf where id = ?";
				// 3.预编译sql句
				ps = conn.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(userid));
				ps.addBatch();// 添加当前待执行sql到batch
			}

			// 4.执行batch
			ps.executeBatch();
			conn.commit();// 手动提交事务
			conn.setAutoCommit(true);// 打开自动提交事务
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtil.close(null, ps, conn);
		}
	}

}
