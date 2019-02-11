package querycreate.querygeneration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import querycreate.config.QueryConnection;
import querycreate.entities.QueryInfo;

public class QueryCreate {

	private Connection _conn;

	public QueryCreate() throws ClassNotFoundException, SQLException {

		_conn = QueryConnection.getConnection();

	}

	public QueryInfo getQueryInfo(String sql) throws SQLException {
		Statement smtp = _conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = smtp.executeQuery(sql);
		QueryInfo query_info = new QueryInfo();
		query_info.setTable(getTables(rs));
		query_info.setColumns(getColumns(rs));
		query_info.setRows(getRows(rs));
		query_info.setCount(getCountRows(rs));
		return query_info;
	}

	private String[] getTables(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		String[] tables = new String[count];
		int count_result = 0;
		for (int i = 1; i <= count; i++) {
			boolean valid_table = true;
			for (String table : tables) {
				if (table != null && table.equals(rsmd.getTableName(i))) {
					valid_table = false;
				}
			}
			if (valid_table) {
				tables[i - 1] = rsmd.getTableName(i);
				count_result++;
			}
		}
		String[] tables_result = new String[count_result];
		count_result = 0;
		for (String table : tables) {
			if (table != null) {
				tables_result[count_result] = table;
				count_result++;
			}
		}
		return tables_result;
	}

	private String[] getColumns(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		String[] columns = new String[count];
		for (int i = 1; i <= count; i++) {
			columns[i - 1] = rsmd.getColumnName(i);
		}
		return columns;
	}

	private Object[][] getRows(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int count_col = rsmd.getColumnCount();
		rs.last();
		int count_row = rs.getRow();
		rs.beforeFirst();
		Object[][] rows = new Object[count_row][count_col];

		int count_row_seq = 0;
		while (rs.next()) {
			for (int i = 1; i <= count_col; i++) {
				rows[count_row_seq][i - 1] = rs.getObject(i);
			}
			count_row_seq++;
		}

		return rows;
	}

	private int getCountRows(ResultSet rs) throws SQLException {
		rs.last();
		int count = rs.getRow();
		rs.beforeFirst();
		return count;
	}

}
