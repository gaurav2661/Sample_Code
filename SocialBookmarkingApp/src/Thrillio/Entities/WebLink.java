package Thrillio.Entities;

public class WebLink extends Bookmark{
    @Override
    public String toString() {
        return "WebLink{" +
                "Url='" + Url + '\'' +
                ", host='" + host + '\'' +
                '}';
    }

    @Override
    public boolean isKidFriendlyEligible() {
       if(Url.contains("porn")||getTitle().contains("porn")){
           return false;
       }
       return true;
    }

    private String Url;
    private String host;

    // creating getters and setter for these private fields

    public void setHost(String host){
        this.host=host;
    }
    public void setUrl(String url){
        this.Url=url;
    }
    public String getUrl(){
        return Url;
    }
    public String getHost(){
        return host;
    }
}
