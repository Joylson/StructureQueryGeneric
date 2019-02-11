package querycreate;

import java.sql.SQLException;

import querycreate.entities.QueryInfo;
import querycreate.querygeneration.QueryCreate;

public class Main {
	
	private static QueryCreate queryCreate1;	
	
	public static void main(String[] args) {
		try {
			queryCreate1 = new QueryCreate();
			
			QueryInfo query_info = queryCreate1.getQueryInfo("select * from user_system");

			System.out.println("");
			System.out.println("TABELAS");
			for(String table : query_info.getTable()) {
				System.out.print(table + " ");
			}

			System.out.println("");
			System.out.println("\nCOLUNAS");
			for(String column : query_info.getColumns()) {
				System.out.print(column.toUpperCase() + " ");
			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("LINHAS - " + query_info.getCount());
			for(Object[] row : query_info.getRows()) {
				for(Object col : row) {
					System.out.print(col + " ");
				}
				System.out.println("\n");
			}
			
			//System.out.println(query_info.toString());
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
