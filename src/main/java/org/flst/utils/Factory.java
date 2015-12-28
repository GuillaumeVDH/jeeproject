package org.flst.utils;

import org.flst.dao.*;

public class Factory {

	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOImpl();
	}

	public static ShelfDAO getShelfDAO() {
		return new ShelfDAOImpl();
	}
}
