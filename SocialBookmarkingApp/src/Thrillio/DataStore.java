package Thrillio;

import Thrillio.Constants.BookGenre;
import Thrillio.Constants.Gender;
import Thrillio.Constants.MovieGenre;
import Thrillio.Constants.UserType;
import Thrillio.Entities.Bookmark;
import Thrillio.Entities.User;
import Thrillio.Entities.UserBookmark;
import Thrillio.Managers.BookmarkManager;
import Thrillio.Managers.UserManager;

public class DataStore {
    public static final int TOTAL_USER_COUNT = 5;
    private static User[] users = new User[TOTAL_USER_COUNT];
    public static final int BOOKMARK_TYPES_COUNT = 3;
    public static final int BOOKMARK_COUNT_PER_ = 5;
    private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_];
    public static final int USER_BOOKMARK_LIMIT = 5;
    private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];


    public static User[] getUsers() {
        return users;
    }

    public static Bookmark[][] getBookmarks() {
        return bookmarks;
    }
        private static int bookmarkIndex=0;
    public static void loadData() {
        loadUsers();
        loadWebLinks();
        loadBooks();
        loadMovies();
    }

    private static void loadMovies() {
        bookmarks[2][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "https://www.geeksforgeeks.org/private-constructors-and-singleton-classes-in-java/", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles", "garry"}, MovieGenre.ACTION_AND_ADVENTURE, 8.7);
        bookmarks[2][1] = BookmarkManager.getInstance().createMovie(3001, "Citizen Kane", "https://www.geeksforgeeks.org/private-constructors-and-singleton-classes-in-java/", 1944, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles", "garry"}, MovieGenre.SCI_FI_AND_FANTASY, 8.1);
        bookmarks[2][2] = BookmarkManager.getInstance().createMovie(3002, "Citizen Kane", "https://www.geeksforgeeks.org/private-constructors-and-singleton-classes-in-java/", 1945, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles", "garry"}, MovieGenre.FAITH_AND_SPIRITUALITY, 8.4);
        bookmarks[2][3] = BookmarkManager.getInstance().createMovie(3003, "Citizen Kane", "https://www.geeksforgeeks.org/private-constructors-and-singleton-classes-in-java/", 1946, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles", "garry"}, MovieGenre.HORROR, 8.2);
        bookmarks[2][4] = BookmarkManager.getInstance().createMovie(3004, "Citizen Kane", "https://www.geeksforgeeks.org/private-constructors-and-singleton-classes-in-java/", 1947, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles", "garry"}, MovieGenre.FOREIGN_MOVIES, 8.9);


    }

    private static void loadBooks() {
        bookmarks[1][0] = BookmarkManager.getInstance().createBook(4000, "Walden0000", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html.12340", 1854, "Wilder Publications", new String[]{"Henry", "David", "Thoreau"}, BookGenre.PHILOSOPHY, 4.9);
        bookmarks[1][1] = BookmarkManager.getInstance().createBook(4001, "Walden0001", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html.12341", 1855, "Wilder Publications", new String[]{"Henry", "David", "Thoreau"}, BookGenre.HISTORY, 4.2);
        bookmarks[1][2] = BookmarkManager.getInstance().createBook(4002, "Walden0002", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html.12342", 1856, "Wilder Publications", new String[]{"Henry", "David", "Thoreau"}, BookGenre.FICTION, 4.3);
        bookmarks[1][3] = BookmarkManager.getInstance().createBook(4003, "Walden0003", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html.12343", 1857, "Wilder Publications", new String[]{"Henry", "David", "Thoreau"}, BookGenre.SELF_HELP, 3.9);
        bookmarks[1][4] = BookmarkManager.getInstance().createBook(4004, "Walden0004", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html.12344", 1858, "Wilder Publications", new String[]{"Henry", "David", "Thoreau"}, BookGenre.RELIGION, 4.7);
    }

    private static void loadWebLinks() {
        bookmarks[0][0] = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger 0", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html.12340", "http://www.javaworld.com.12340", "NONE0");
        bookmarks[0][1] = BookmarkManager.getInstance().createWebLink(2001, "Taming Tiger 1", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html.12341", "http://www.javaworld.com.12341", "NONE1");
        bookmarks[0][2] = BookmarkManager.getInstance().createWebLink(2002, "Taming Tiger 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html.12342", "http://www.javaworld.com.12342", "NONE2");
        bookmarks[0][3] = BookmarkManager.getInstance().createWebLink(2003, "Taming Tiger 3", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html.12343", "http://www.javaworld.com.12343", "NONE3");
        bookmarks[0][4] = BookmarkManager.getInstance().createWebLink(2004, "Taming Tiger 4", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html.12344", "http://www.javaworld.com.12344", "NONE4");


    }

    private static void loadUsers() {
        users[0] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "password1", "name 1", "last name 1", Gender.MALE, UserType.USER);
        users[1] = UserManager.getInstance().createUser(1001, "user1@semanticsquare.com", "password2", "name 2", "last name 2", Gender.MALE, UserType.USER);
        users[2] = UserManager.getInstance().createUser(1002, "user2@semanticsquare.com", "password3", "name 3", "last name 3", Gender.FEMALE, UserType.CHIEF_EDITOR);
        users[3] = UserManager.getInstance().createUser(1003, "user3@semanticsquare.com", "password4", "name 4", "last name 4", Gender.MALE, UserType.USER);
        users[4] = UserManager.getInstance().createUser(1004, "user4@semanticsquare.com", "password5", "name 5", "last name 5", Gender.FEMALE, UserType.EDITOR);


    }


    public static void add(UserBookmark userBookmark) {
        userBookmarks[bookmarkIndex]=userBookmark;
        bookmarkIndex++;
    }
}
