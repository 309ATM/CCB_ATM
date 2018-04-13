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
	 * �����������÷��䣬���Ի�ȡ�������͡�
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
	 * ��ɾ�Ĳ���
	 * 
	 * @param sql
	 *            ���� SQL ���
	 * @param objects
	 *            �������
	 */
	public void update(String sql, Object... objects) {
		try (Connection connection = JDBCTools.getConnection()) {
			queryRunner.update(connection, sql, objects);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	/**
	 * ��ȡ������¼��������¼ת��Ϊһ��������з���
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

	/** ��ȡ������¼��������¼ת��Ϊһ������ļ��Ͻ��з���
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
	
	/** ��ĳ����¼��ĳ��ֵ���أ�������ĳ��ͳ���������з���
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
