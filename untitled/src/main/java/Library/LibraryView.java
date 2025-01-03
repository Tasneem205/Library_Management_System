package Library;
import java.sql.SQLException;
import java.util.Scanner;

public interface LibraryView {
    void showMenu();
    void handleSelection(Scanner sc, int choice) throws SQLException;
    void performSearch(Scanner sc) throws SQLException;
    void borrowBook() throws SQLException;
    void returnBook() throws SQLException;
    public void viewAllContents();
}

