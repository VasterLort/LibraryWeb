package by.http.dao.util;

public class DaoConstantStorage {
	private DaoConstantStorage() {
	}

	public static final String FIELD_URL = "jdbc:mysql://localhost/library?serverTimezone=Europe/Moscow&useSSL=false&allowPublicKeyRetrieval=true";
	public static final String FIELD_USER_NAME = "root";
	public static final String FIELD_PASSWORD = "1234";
	public static final String FIELD_DYNAMIC_DRIVER_LOADING = "com.mysql.cj.jdbc.Driver";

	public static final String REQUEST_ALL_INFORMATION = "SELECT * FROM all_information";
	public static final String REQUEST_INFO_AUTHOR = "SELECT * FROM author";
	public static final String REQUEST_INFO_BOOK = "SELECT * FROM book";
	public static final String REQUEST_INSERT_AUTHOR = "INSERT INTO author (name, surname, age) values (?, ?, ?)";
	public static final String REQUEST_DELETE_BOOK = "DELETE book WHERE id = ? ";
	public static final String REQUEST_UPDATE_BOOK = "UPDATE book SET title = ? WHERE id = ? ";

	public static final String COMMAND_ID_GENERAL = "id";
	public static final String COMMAND_EMPTY_VALUE_AUTHOR = "Library have not author with so id";
	public static final String COMMAND_EMPTY_VALUE_BOOK = "Library have not book with so id";

	public static final String COMMAND_ID_AUTHOR = "id_author";
	public static final String COMMAND_NAME_AUTHOR = "name";
	public static final String COMMAND_SURNAME_AUTHOR = "surname";
	public static final String COMMAND_AGE_AUTHOR = "age";

	public static final String COMMAND_ID_BOOK = "id_book";
	public static final String COMMAND_NAME_BOOK = "title";
	
}
