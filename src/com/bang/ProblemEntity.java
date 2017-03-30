package com.bang;

import javax.persistence.*;

/**
 * Created by tom on 2017/3/30.
 */
@Entity
@Table(name = "problem", schema = "bangbang", catalog = "")
@IdClass(ProblemEntityPK.class)
public class ProblemEntity {
    private int problemid;
    private int userid;
    private String problemtitle;
    private String problemdetail;

    @Id
    @Column(name = "problemid")
    public int getProblemid() {
        return problemid;
    }

    public void setProblemid(int problemid) {
        this.problemid = problemid;
    }

    @Id
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "problemtitle")
    public String getProblemtitle() {
        return problemtitle;
    }

    public void setProblemtitle(String problemtitle) {
        this.problemtitle = problemtitle;
    }

    @Basic
    @Column(name = "problemdetail")
    public String getProblemdetail() {
        return problemdetail;
    }

    public void setProblemdetail(String problemdetail) {
        this.problemdetail = problemdetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProblemEntity that = (ProblemEntity) o;

        if (problemid != that.problemid) return false;
        if (userid != that.userid) return false;
        if (problemtitle != null ? !problemtitle.equals(that.problemtitle) : that.problemtitle != null) return false;
        if (problemdetail != null ? !problemdetail.equals(that.problemdetail) : that.problemdetail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = problemid;
        result = 31 * result + userid;
        result = 31 * result + (problemtitle != null ? problemtitle.hashCode() : 0);
        result = 31 * result + (problemdetail != null ? problemdetail.hashCode() : 0);
        return result;
    }
}
