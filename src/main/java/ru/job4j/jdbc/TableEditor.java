package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

/**
 * Класс TableEditor предоставляет методы для управления таблицами базы данных.
 * Он позволяет создавать, удалять таблицы, а также изменять их структуру:
 * добавлять и удалять столбцы, изменять их имена.
 * Подключение к базе данных осуществляется с использованием JDBC.
 * <p>
 * Класс реализует интерфейс AutoCloseable для автоматического закрытия соединения.
 */
public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    /**
     * Конструктор класса TableEditor.
     * Инициализирует свойства подключения и устанавливает соединение с базой данных.
     *
     * @param properties свойства подключения к базе данных (URL, логин, пароль, драйвер).
     */
    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    /**
     * Создает новую таблицу с заданным именем и первичным ключом.
     *
     * @param tableName имя создаваемой таблицы.
     */
    public void createTable(String tableName) {
        String sql = String.format("CREATE TABLE %s(%s);", tableName, "id SERIAL PRIMARY KEY");
        executeStatement(sql);
    }

    /**
     * Удаляет таблицу с указанным именем из базы данных.
     *
     * @param tableName имя удаляемой таблицы.
     */
    public void dropTable(String tableName) {
        String sql = String.format("DROP TABLE %s;", tableName);
        executeStatement(sql);
    }

    /**
     * Добавляет новый столбец в указанную таблицу.
     *
     * @param tableName  имя таблицы, в которую добавляется столбец.
     * @param columnName имя нового столбца.
     * @param type       тип данных нового столбца.
     */
    public void addColumn(String tableName, String columnName, String type) {
        String sql = String.format("ALTER TABLE %s ADD COLUMN %s %s;", tableName, columnName, type);
        executeStatement(sql);
    }

    /**
     * Удаляет столбец из указанной таблицы.
     *
     * @param tableName  имя таблицы, из которой удаляется столбец.
     * @param columnName имя удаляемого столбца.
     */
    public void dropColumn(String tableName, String columnName) {
        String sql = String.format("ALTER TABLE %s DROP COLUMN %s;", tableName, columnName);
        executeStatement(sql);
    }

    /**
     * Переименовывает столбец в указанной таблице.
     *
     * @param tableName     имя таблицы, в которой находится столбец.
     * @param columnName    текущее имя столбца.
     * @param newColumnName новое имя столбца.
     */
    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = String.format("ALTER TABLE %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName);
        executeStatement(sql);
    }

    /**
     * Возвращает схему (структуру) указанной таблицы в виде строки.
     *
     * @param tableName имя таблицы, схему которой нужно получить.
     * @return строковое представление схемы таблицы.
     * @throws Exception если произошла ошибка при получении схемы таблицы.
     */
    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    /**
     * Закрывает текущее соединение с базой данных.
     *
     * @throws Exception если произошла ошибка при закрытии соединения.
     */
    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * Инициализирует соединение с базой данных.
     */
    private void initConnection() {
        try {
            connection = getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Выполняет SQL-запрос, переданный в качестве строки.
     *
     * @param sql SQL-запрос для выполнения.
     */
    private void executeStatement(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Устанавливает соединение с базой данных на основе заданных свойств.
     *
     * @return объект Connection для взаимодействия с базой данных.
     * @throws Exception если произошла ошибка при установлении соединения.
     */
    private Connection getConnection() throws Exception {
        Class.forName(properties.getProperty("driver"));
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        return DriverManager.getConnection(url, login, password);
    }

    /**
     * Выводит в консоль схему таблицы с указанным именем.
     *
     * @param tableName имя таблицы, схему которой нужно вывести.
     */
    public void printTableScheme(String tableName) {
        try {
            System.out.println(getTableScheme(tableName));
        } catch (Exception e) {
            System.out.printf("Table %s doesn't exist!\n", tableName);
        }
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream input = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (var tableEditor = new TableEditor(properties)) {
            var tableName = "students_s";
            tableEditor.createTable(tableName);
            tableEditor.printTableScheme(tableName);
            tableEditor.addColumn(tableName, "name", "VARCHAR(100)");
            tableEditor.addColumn(tableName, "surname", "VARCHAR(100)");
            tableEditor.addColumn(tableName, "course", "VARCHAR(100)");
            tableEditor.printTableScheme(tableName);
            tableEditor.renameColumn(tableName, "course", "subject");
            tableEditor.printTableScheme(tableName);
            tableEditor.dropColumn(tableName, "subject");
            tableEditor.printTableScheme(tableName);
            tableEditor.dropTable(tableName);
            tableEditor.printTableScheme(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
