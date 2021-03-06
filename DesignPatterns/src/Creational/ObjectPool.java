package Creational;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Used to manage the object caching. Basically, an Object pool is a container
 * which contains a specified amount of objects. When an object is taken from
 * the pool, it is not available in the pool until it is put back.
 * https://sourcemaking.com/design_patterns/object_pool/java
 */

abstract class ObjectPoolPattern<T> {

	long deadTime;
	Hashtable<T, Long> lock, unlock;

	ObjectPoolPattern() {

		deadTime = 50000;
		lock = new Hashtable<T, Long>();
		unlock = new Hashtable<T, Long>();
	}

	abstract T create();

	abstract boolean validate(T o);

	abstract void dead(T o);

	synchronized T takeOut() {

		long now = System.currentTimeMillis();
		T t;

		if (unlock.size() > 0) {

			Enumeration<T> e = unlock.keys();

			while (e.hasMoreElements()) {

				t = e.nextElement();

				if ((now - unlock.get(t)) > deadTime) {

					/** object has died */
					unlock.remove(t);
					dead(t);
					t = null;

				} else {

					if (validate(t)) {

						unlock.remove(t);
						lock.put(t, now);
						return (t);

					} else {

						/** object failed validation */
						unlock.remove(t);
						dead(t);
						t = null;
					}
				}
			}
		}

		/** no objects available, create a new one */
		t = create();
		lock.put(t, now);
		return (t);
	}

	synchronized void takeIn(T t) {
		lock.remove(t);
		unlock.put(t, System.currentTimeMillis());
	}
}

/** Three methods are abstract therefore must be implemented by the subclass */
class JDBCConnectionPool extends ObjectPoolPattern<Connection> {

	String dsn, usr, pwd;

	JDBCConnectionPool(String driver, String dsn, String usr, String pwd) {

		super();

		try {
			/** New Instance */
			Class.forName(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.dsn = dsn;
		this.usr = usr;
		this.pwd = pwd;

	}

	Connection create() {

		try {
			return (DriverManager.getConnection(dsn, usr, pwd));

		} catch (SQLException e) {
			e.printStackTrace();
			return (null);
		}
	}

	void dead(Connection o) {

		try {
			((Connection) o).close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	boolean validate(Connection o) {

		try {
			return (!((Connection) o).isClosed());

		} catch (SQLException e) {
			e.printStackTrace();
			return (false);
		}
	}
}

class ObjectPool {

	public static void main(String args[]) {

		/** Create the ConnectionPool */
		JDBCConnectionPool pool = new JDBCConnectionPool("org.hsqldb.jdbcDriver", "jdbc:hsqldb: //localhost/mydb", "sa",
				"password");

		/** Get a connection */
		Connection con = pool.takeOut();
		/** Return the connection: */
		pool.takeIn(con);
	}
}
