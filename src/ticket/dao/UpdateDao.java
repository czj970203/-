package ticket.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import ticket.config.Message;
import ticket.model.Update;

@Repository
public class UpdateDao {

	@Resource
	BaseDao baseDao;

	public Message addUpdate(Update up) {
		return baseDao.save(up);
	}

	public Message deleteUpdate(Update up) {
		return baseDao.delete(up);
	}

	public Message findUpdateById(int hallNo) {
		return baseDao.findById(Update.class, hallNo);
	}

	public Message getAllUpdate() {
		return baseDao.getAll(Update.class);
	}
	
	public Message update(Update up) {
		return baseDao.update(up);
	}
	
}
