package Thrillio.Dao;

import Thrillio.DataStore;
import Thrillio.Entities.Bookmark;
import Thrillio.Entities.UserBookmark;

public class BookmarkDao {
    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }

    public void saveBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
}
