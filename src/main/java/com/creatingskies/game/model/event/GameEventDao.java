package com.creatingskies.game.model.event;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.creatingskies.game.core.Game;
import com.creatingskies.game.model.GenericDAO;
import com.creatingskies.game.model.company.Company;

public class GameEventDao extends GenericDAO{

	private static final long serialVersionUID = -8391448429161795996L;

	@SuppressWarnings("unchecked")
	public List<GameEvent> findAll(Criterion...criterions){
		Session session = openSession();
		try{
			Criteria criteria = session.createCriteria(GameEvent.class);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			if(criterions != null && criterions.length > 0){
				for(Criterion criterion : criterions){
					if(criterion != null){
						criteria.add(criterion);
					}
				}
			}
			return criteria.list();
		}finally{
			session.close();
		}
	}
	
	public GameEvent findEventByDate(Date date){
		return (GameEvent) find(GameEvent.class, Restrictions.eq("eventDate", date));
	}
	
	@SuppressWarnings("unchecked")
	public List<GameEvent> findAllGameEventByGame(Game game){
		Session session = openSession();
		try{
			Criteria criteria = session.createCriteria(GameEvent.class);
			criteria.add(Restrictions.eq("game", game));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			return criteria.list();
		}finally{
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<GameEvent> findAllGameEventByCompany(Company company){
		Session session = openSession();
		try{
			Criteria criteria = session.createCriteria(GameEvent.class);
			criteria.add(Restrictions.eq("company", company));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			return criteria.list();
		}finally{
			session.close();
		}
	}
}
