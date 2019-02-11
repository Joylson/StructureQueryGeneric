package querycreate.entities;

import java.util.Arrays;

public class QueryInfo {

	private String[] table;
	private String[] columns;
	private Object[][] rows;
	private int count;

	public String[] getTable() {
		return table;
	}

	public void setTable(String[] table) {
		this.table = table;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public Object[][] getRows() {
		return rows;
	}

	public void setRows(Object[][] rows) {
		this.rows = rows;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Query [table=").append(Arrays.toString(table)).append(", columns=")
				.append(Arrays.toString(columns)).append(", rows=").append(Arrays.toString(rows)).append(", count=")
				.append(count).append("]");
		return builder.toString();
	}

}
