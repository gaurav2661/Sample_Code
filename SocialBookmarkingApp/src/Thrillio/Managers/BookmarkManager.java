package Thrillio.Managers;

import Thrillio.Dao.BookmarkDao;
import Thrillio.Entities.*;

public class BookmarkManager {

    /**
     * making private constructor static because to access it from static method
     */

    private static BookmarkManager instance = new BookmarkManager();
    private static BookmarkDao bookmarkDao= new BookmarkDao();
    private BookmarkManager() {
    }

    /**
     * only way to access the created instance of user manager class
     * as its constructor is private only one instance is created
     * this is called singleton pattern
     */

    public static BookmarkManager getInstance() {
        return instance;
    }

    public Movie createMovie(long Id,
                             String Title,
                             String profileUrl, int release_Year,
                             String[] cast,
                             String[] directors,
                             String genre,
                             double imdb_Ratings) {
        Movie movie = new Movie();

        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImdb_Ratings(imdb_Ratings);
        movie.setId(Id);
        movie.setProfileUrl(profileUrl);
        movie.setTitle(Title);
        movie.setReleaseYear(release_Year);

        return movie;
    }

    public Book createBook(long Id,
                           String Title,
                           String profileUrl, int publication_Year,
                           String publisher,
                           String[] authors,
                           String genre,
                           double amazon_Ratings) {
        Book book = new Book();
        book.setId(Id);
        book.setGenre(genre);
        book.setTitle(Title);
        book.setProfileUrl(profileUrl);
        book.setAuthors(authors);
        book.setPublisher(publisher);
        book.setProfileUrl(profileUrl);
        book.setPublication_Year(publication_Year);
        book.setAmazon_Ratings(amazon_Ratings);


        return book;
    }

    public WebLink createWebLink(long Id,
                                 String Title,
                                 String profileUrl, String Url,
                                 String host) {
        WebLink webLink = new WebLink();
        webLink.setHost(host);
        webLink.setId(Id);
        webLink.setProfileUrl(profileUrl);
        webLink.setTitle(Title);
        webLink.setUrl(Url);


        return webLink;
    }
    public Bookmark[][] getBookmarks(){
        return bookmarkDao.getBookmarks();
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        UserBookmark userBookmark = new UserBookmark();
        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);

        bookmarkDao.saveBookmark(userBookmark);
    }
}
