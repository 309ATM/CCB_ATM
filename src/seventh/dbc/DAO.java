package seventh.dbc;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mysql.jdbc.Connection;

public class DAO<T> {

	private Class<T> tClass;
	private QueryRunner queryRunner = new QueryRunner();

	/**
	 * 构造器，利用反射，用以获取泛型类型。
	 */
	public DAO() {
		Type superClass = getClass().getGenericSuperclass();
		if (superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) superClass;

			Type[] typeAgrs = parameterizedType.getActualTypeArguments();
			if (typeAgrs != null && typeAgrs.length > 0) {
				if (typeAgrs[0] instanceof Class) {
					tClass = (Class<T>) typeAgrs[0];
				}
			}
		}

	}

	/**
	 * 增删改操作
	 * 
	 * @param sql
	 *            传入 SQL 语句
	 * @param objects
	 *            传入参数
	 */
	public void update(String sql, Object... objects) {
		try (Connection connection = JDBCTools.getConnection()) {
			queryRunner.update(connection, sql, objects);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	/**
	 * 获取单条记录，并将记录转换为一个对象进行返回
	 * 
	 * @param sql
	 * @param objects
	 * @return
	 */
	public T get(String sql, Object... objects) {
		try (Connection connection = JDBCTools.getConnection()) {
			return queryRunner.query(connection, sql, new BeanHandler<>(tClass), objects);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	/** 获取多条记录，并将记录转换为一个对象的集合进行返回
	 * @param sql
	 * @param objects
	 * @return
	 */
	public List<T> getForList(String sql, Object... objects) {
		try(Connection connection = JDBCTools.getConnection()) {
			return queryRunner.query(connection, sql, new BeanListHandler<>(tClass), objects);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	
	/** 将某条记录的某个值返回，或者是某个统计数量进行返回
	 * @param sql
	 * @param objects
	 * @return
	 */
	public <E> E getForValue(String sql, Object... objects) {
		try (Connection connection = JDBCTools.getConnection()) {
			return (E) queryRunner.query(sql, new ScalarHandler(),objects);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
}
