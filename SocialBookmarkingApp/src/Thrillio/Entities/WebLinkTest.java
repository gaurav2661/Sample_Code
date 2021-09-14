package Thrillio.Entities;

import Thrillio.Managers.BookmarkManager;

import static org.junit.jupiter.api.Assertions.*;

class WebLinkTest extends Object {

    @org.junit.jupiter.api.Test
    void isKidFriendlyEligible() {
        //test1 : porn in url --false
        //test2 : porn in title--false
        //test3 : adult in host -- false
        //test4 : adult in url but not in host -- true
        //test5 : adult in title only --true

     WebLink webLink =    BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger 0", "http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html.12340", "http://www.javaworld.com.12340", "NONE0");
    boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
    assertFalse(isKidFriendlyEligible, "for porn in url - isKidFriendlyEligible () must return false");
    }
}