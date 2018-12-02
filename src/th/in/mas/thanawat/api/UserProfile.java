package th.in.mas.thanawat.api;

import io.reactivex.Observable;

public class UserProfile implements Api {
    private String id;
    private String name;
    private int level;
    private long userExp;
    private long expToNextLevel;
    private String currentCategory;

    public static Observable<Api> mockApi() {
        return Observable.just(getUserFromSession("mocking"));
    }

    private static final UserProfile getUserFromSession(String session) {
        //MockData for demonstration instead of query from database
        UserProfile userProfile =  new UserProfile();
        userProfile.setId("37403243922343");
        userProfile.setName("MockUser");
        userProfile.setLevel(54);
        userProfile.setUserExp(200L);
        userProfile.setExpToNextLevel(1000L);
        userProfile.setCurrentCategory("Shoe");
        return userProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getUserExp() {
        return userExp;
    }

    public void setUserExp(long userExp) {
        this.userExp = userExp;
    }

    public long getExpToNextLevel() {
        return expToNextLevel;
    }

    public void setExpToNextLevel(long expToNextLevel) {
        this.expToNextLevel = expToNextLevel;
    }

    public String getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(String currentCategory) {
        this.currentCategory = currentCategory;
    }

    @Override
    public String getApiName() {
        return getClass().getSimpleName();
    }
}
