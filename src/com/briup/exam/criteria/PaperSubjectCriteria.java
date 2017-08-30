package com.briup.exam.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.briup.exam.bean.Paper;
import com.briup.exam.bean.PaperSubject;
import com.briup.exam.common.util.Criteriable;

public class PaperSubjectCriteria implements Criteriable{
	private Paper paper;
	
	
	public Paper getPaper() {
		return paper;
	}


	public void setPaper(Paper paper) {
		this.paper = paper;
	}


	@Override
	public Criteria getExampleCriteria(Session session) {
		// TODO Auto-generated method stub
		Criteria criteria = session.createCriteria(PaperSubject.class);
		if(paper.getId()!=null) criteria.add(Restrictions.eq("paper_id", paper.getId()));
		return criteria;
	}

}
