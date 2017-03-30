package com.bang;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by tom on 2017/3/30.
 */
public class ProblemEntityPK implements Serializable {
    private int problemid;
    private int userid;

    @Column(name = "problemid")
    @Id
    public int getProblemid() {
        return problemid;
    }

    public void setProblemid(int problemid) {
        this.problemid = problemid;
    }

    @Column(name = "userid")
    @Id
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProblemEntityPK that = (ProblemEntityPK) o;

        if (problemid != that.problemid) return false;
        if (userid != that.userid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = problemid;
        result = 31 * result + userid;
        return result;
    }
}
