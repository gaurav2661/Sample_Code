package Thrillio;

import Thrillio.Entities.Bookmark;
import Thrillio.Entities.User;

public class View {
    public static void browse(User user, Bookmark[][] bookmarks){
        System.out.println("\n"+user.getEmail()+"is browsing items....");
        int bookmarkCount = 0;
        for(Bookmark[] bookmarklist : bookmarks){
            for(Bookmark bookmark:bookmarklist){
                //bookmarking
                if(bookmarkCount<DataStore.USER_BOOKMARK_LIMIT){
                   boolean isBookmarked =  getBookmarkDesicion(bookmark);
                }
            }
        }
    }

    private static boolean getBookmarkDesicion(Bookmark bookmark) {
        return Math.random()<0.5? true : false;
    }
   /* public static void bookmark(User user, Bookmark[][] bookmarks){
        System.out.println("\n"+user.getEmail()+"   is bookmarking");
        for(int u=0;u<DataStore.USER_BOOKMARK_LIMIT;u++){
            int typeffset= (int) Math.random()*DataStore.BOOKMARK_TYPES_COUNT;
                    int bookmarkoffset=(int) Math.random()*DataStore.BOOKMARK_COUNT_PER_;

                    Bookmark bookmark = bookmarks[typeffset][bookmarkoffset];


            BookmarkController.getInstance().saveUserBookmark(user,bookmark);

            System.out.println(bookmark);

        }*/
    }

