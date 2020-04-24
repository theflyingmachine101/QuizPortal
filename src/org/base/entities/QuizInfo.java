package org.base.entities;

public class QuizInfo {
	int qid,aid;
	String qname;
	public QuizInfo(int qid, int aid, String qname) {
		super();
		this.qid = qid;
		this.aid = aid;
		this.qname = qname;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	
	
}
