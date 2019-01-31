package indi.model.daoModel;

/**
 *
 * @author JOJO
 */
public class Loginer {
    
    private String userName;
    private String passWord;
    private int userId;
    private String lastLoginDate;
    
    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
    
    public int getUserId() {
        return userId;
    }
    public String getLastLoginDate() {
        return lastLoginDate;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
