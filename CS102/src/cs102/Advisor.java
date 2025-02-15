package cs102;

import java.util.Objects;

public class Advisor {

    private String name;
    private String AdvisorId;
    private String passWord;

    public Advisor(String name, String AdvisorId, String passWord) {
        this.name = name;
        this.AdvisorId = AdvisorId;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdvisorId() {
        return AdvisorId;
    }

    public void setAdvisorId(String AdvisorId) {
        this.AdvisorId = AdvisorId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return name + "::" + AdvisorId + "::" + passWord;
    }

    public String toStringWithformate() {
        return " \n-------------\n Name: " + name + "\n Advisor ID: " + AdvisorId + "\n Password: " + passWord + "";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.AdvisorId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Advisor other = (Advisor) obj;
        if (!Objects.equals(this.AdvisorId, other.AdvisorId)) {
            return false;
        }
        return true;
    }

}
