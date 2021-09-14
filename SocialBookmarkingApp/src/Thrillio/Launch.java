package Thrillio;

import Thrillio.Entities.Bookmark;
import Thrillio.Entities.User;
import Thrillio.Entities.UserBookmark;
import Thrillio.Managers.BookmarkManager;
import Thrillio.Managers.UserManager;

public class Launch {
    private static  User[] users;
    private static Bookmark[][] bookmarks;

    public static void main(String[] args){
        loadData();
        startBookmarking();
    }

    private static void startBookmarking() {
        System.out.println("\n2.....bookmarking...");
        for(User uer:users){
            View.bookmark(uer,bookmarks);
        }
    }

    private static void loadData() {
        System.out.println("\n 1... loading data....");
        DataStore.loadData();
        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

        System.out.println("....printing data...");
        printUserData();
        printBookmarkData();

    }

    private static void printBookmarkData() {
        for(Bookmark[] bookmarklist:bookmarks){
            for(Bookmark bookmark:bookmarklist){
                System.out.println(bookmark);
            }
        }
    }

    private static void printUserData() {
        for (User user:users){
            System.out.println(user);
        }
    }
}
