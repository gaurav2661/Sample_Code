package Thrillio.Entities;

import Thrillio.Constants.KidFriendlyStatus;

public abstract class Bookmark {
    private long Id;
    private String Title;
    private String profileUrl;
    private String kidFriendlyStatus= KidFriendlyStatus.UNKNOWN;

    @Override
    public String toString() {
        return "Bookmark{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                '}';
    }
// creating getters and setter for these private fields


    public void setId(long ID){
        this.Id=ID;
    }
    public void setTitle(String TITLE){
        this.Title=TITLE;
    }
    public void setProfileUrl(String PROFILEURL){
        this.profileUrl=PROFILEURL;
    }
    public long getId(){
        return Id;
    }
    public String getTitle(){
        return Title;
    }
    public String getProfileUrl(){
        return profileUrl;
    }
    public abstract boolean isKidFriendlyEligible();
}
