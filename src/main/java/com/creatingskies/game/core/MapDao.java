package com.creatingskies.game.core;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.creatingskies.game.model.GenericDAO;

public class MapDao extends GenericDAO{

	private static final long serialVersionUID = 1561399064207986263L;

	@SuppressWarnings("unchecked")
	public List<Map> findAllMaps(){
		Session session = openSession();
		try{
			List<Map> maps = session.createCriteria(Map.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.list();
			
			return maps;
		}finally{
			session.close();
		}
	}
	
	public Map findMapWithDetails(Integer idNo){
		Session session = openSession();
		try{
			Map map = (Map) session.createCriteria(Map.class)
					.add(Restrictions.eq("idNo", idNo))
					.setFetchMode("tiles", FetchMode.JOIN)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.uniqueResult();
			
			return map;
		}finally{
			session.close();
		}
	}
	
	public TileImage findTileImageByOwner(String owner){
		Session session = openSession();
		try{
			TileImage tileImage = (TileImage) session.createCriteria(TileImage.class)
					.add(Restrictions.eq("owner", owner))
					.uniqueResult();
			return tileImage;
		}finally{
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TileImage> findAllTileImages(){
		return (List<TileImage>) findAll(TileImage.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<TileImage> findAllTileImages(Boolean systemDefined,boolean archived){
		Session session = openSession();
		try {
			Criteria c = session.createCriteria(TileImage.class);
			c.add(Restrictions.eq("systemDefined", systemDefined));
			
			if(!archived){
				c.add(Restrictions.disjunction(Restrictions.eq("archived", false),Restrictions.isNull("archived")));
			}
			
			return c.list();
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TileImage> findAllArchivedTileImages(){
		Session session = openSession();
		try {
			Criteria c = session.createCriteria(TileImage.class);
			c.add(Restrictions.eq("systemDefined", false));
			c.add(Restrictions.eq("archived", true));
			
			return c.list();
		} finally {
			session.close();
		}
	}
}
