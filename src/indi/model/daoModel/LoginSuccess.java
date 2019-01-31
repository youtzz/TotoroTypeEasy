package indi.model.daoModel;

/**
 *
 * @author JOJO
 * 此模型适用于主界面的各项功能
 */
public class LoginSuccess extends indi.model.daoModel.Loginer {
    
    private int bestResult;
    private int averageResult;
    
    public int getBestResult() {
        return bestResult;
    }

    public int getAverageResult() {
        return averageResult;
    }

    public void setBestResult(int bestResult) {
        this.bestResult = bestResult;
    }

    public void setAverageResult(int averageResult) {
        this.averageResult = averageResult;
    }

    public LoginSuccess(Loginer loginer) {
        this.setUserName(loginer.getUserName());
        this.setPassWord(loginer.getPassWord());
        this.setUserId(loginer.getUserId());
        this.setLastLoginDate(loginer.getLastLoginDate());
    }
    
}
