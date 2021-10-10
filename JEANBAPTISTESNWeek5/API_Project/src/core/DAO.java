package core;

import java.util.List;
import java.util.ArrayList;

public class DAO {
	private static DAO dao = new DAO();
	
	private List<Expression> expressions;
	
	private DAO()
	{
		expressions = new ArrayList<Expression>();
	}
	
	public static DAO getInstance() {return dao;}

	public static DAO getDao() {
		return dao;
	}

	public static void setDao(DAO dao) {
		DAO.dao = dao;
	}

	public List<Expression> getExpressions() {
		return expressions;
	}

	public void setExpressions(List<Expression> expressions) {
		this.expressions = expressions;
	}
}