package com.counsellor.datasource.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import com.counsellor.common.util.DscPropertyReader;

public class MySqlConnectionPool {//implements Runnable {

	// Number of initial connections to make.
	private int initialConnectionCount = 25;

	// A list of available connections for use.
	private Vector<Connection> availableConnections = new Vector<Connection>();

	// A list of connections being used currently.
	private Vector<Connection> usedConnections = new Vector<Connection>();

	public static MySqlConnectionPool getInstance() {
		return Holder.s_instance;
	}

	private static class Holder {
		private Holder() {}
		private static final MySqlConnectionPool s_instance = new MySqlConnectionPool();
		static {
		}
	}

	private MySqlConnectionPool() {
		try{ 
            Class.forName("com.mysql.jdbc.Driver").newInstance();                          
			for (int cnt = 0; cnt < initialConnectionCount; cnt++) {
				// Add a new connection to the available list.
				availableConnections.addElement(getConnection());
			}

			// Create the cleanup thread
			//cleanupThread = new Thread(this);
			//cleanupThread.start();
		}catch (Throwable E){ 
            System.err.println("Exception while loading driver"); 
            E.printStackTrace(); 
        } 
	}

	private Connection getConnection() throws SQLException {
		String mysqlHost = DscPropertyReader.getInstance().getPropertyValue("mysql.host");
		String mysqlUname = DscPropertyReader.getInstance().getPropertyValue("mysql.username");
		String mysqlPword = DscPropertyReader.getInstance().getPropertyValue("mysql.password");
		Connection connection = DriverManager.getConnection(mysqlHost, mysqlUname, mysqlPword);
		connection.setAutoCommit(true);
		
		return connection;
	}

	public synchronized Connection checkout() throws SQLException {
		Connection newConnxn = null;
		if (availableConnections.size() == 0) {
			// Im out of connections. Create one more.
			newConnxn = getConnection();
			// Add this connection to the "Used" list.
			usedConnections.addElement(newConnxn);
			// We dont have to do anything else since this is
			// a new connection.
		} else {
			// Connections exist !
			// Get a connection object
			newConnxn = (Connection) availableConnections.lastElement();
			// Remove it from the available list.
			availableConnections.removeElement(newConnxn);
			// Add it to the used list.
			usedConnections.addElement(newConnxn);
		}

		// Either way, we should have a connection object now.
		return newConnxn;
	}

	public synchronized void closeAll() throws SQLException {
		Connection connection = null;
		if (availableConnections.size()>0) {
		    Iterator<Connection> itr = availableConnections.iterator();
		    while(itr.hasNext()){
		    	connection = itr.next();
		    	itr.remove();
				if(!connection.isClosed()){
					connection.close();
				}
		    }
		}
		
		if (usedConnections.size()>0) {
		    Iterator<Connection> itr = usedConnections.iterator();
		    while(itr.hasNext()){
		    	connection = itr.next();
		    	itr.remove();
				if(!connection.isClosed()){
					connection.close();
				}
		    }
		}
	}
	
	public synchronized void checkin(Connection c) {
		if (c != null) {
			// Remove from used list.
			usedConnections.removeElement(c);
			// Add to the available list
			availableConnections.addElement(c);
		}
	}

	private int availableCount() {
		return availableConnections.size();
	}

	public void run() {
		try {
			while (true) {
				synchronized (this) {
					while (availableConnections.size() > initialConnectionCount) {
						// Clean up extra available connections.
						Connection c = (Connection) availableConnections.lastElement();
						availableConnections.removeElement(c);
						// Close the connection to the database.
						c.close();
					}
					// Clean up is done
				}

				System.out.println("cleanup available connections : "+ availableCount());

				// Now sleep for 1 minute
				Thread.sleep(60000 * 1);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}