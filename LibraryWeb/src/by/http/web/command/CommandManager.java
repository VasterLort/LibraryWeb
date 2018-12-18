package by.http.web.command;

import by.http.web.command.impl.AddAuthor;
import by.http.web.command.impl.DefaultActionImpl;
import by.http.web.command.impl.DeleteBook;
import by.http.web.command.impl.SearchBooksOfAuthor;
import by.http.web.command.impl.UpdateBook;
import by.http.web.command.impl.ViewCatalogAuthor;
import by.http.web.command.impl.ViewCatalogBook;
import by.http.web.command.impl.ViewSingleBook;

import static by.http.web.util.WebConstantStorage.*;

public class CommandManager {
	public static BasicAction defineAction(String action) {

		switch (action) {
		case REQ_PARAM_ACTION_VIEW_AUTHOR_CATALOG:
			return new ViewCatalogAuthor();
		case REQ_PARAM_ACTION_VIEW_BOOK_CATALOG:
			return new ViewCatalogBook();
		case REQ_PARAM_ACTION_SINGLE_BOOK:
			return new ViewSingleBook();
		case REQ_PARAM_ACTION_SEARCH_BOOKS_OF_AUTHOR:
			return new SearchBooksOfAuthor();
		case REQ_PARAM_ACTION_ADD_AUTHOR:
			return new AddAuthor();
		case REQ_PARAM_ACTION_DELETE_BOOK:
			return new DeleteBook();
		case REQ_PARAM_ACTION_UPDATE_BOOK:
			return new UpdateBook();
		default:
			return new DefaultActionImpl();
		}
	}
}
