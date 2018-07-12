package com.zm.dao.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;









import com.zm.dao.IUserDao;
import com.zm.model.ClassRoom;
import com.zm.model.User;

@Component("userdao")
public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public User getByName(String name) {
		String hql = "FROM User as u WHERE u.name='" + name + "'";
		Query q = getSession().createQuery(hql);
		if (q.list().size() != 0) {
			return (User) q.list().get(0);
		} else {
			return null;
		}
	}

	@Override
	public void connect_ineer() {
		// 鍦ㄤ娇鐢╤ql璇彞鐨勬椂鍊欙紝瑕佸澶勬兂鐫�鎴戜滑浣跨敤鐨勬槸绫伙紝鑰屼笉鏄〃锛侊紒
				String hql = "from ClassRoom c,Student s where c.id=s.room.id and c.id='1'";
				
				@SuppressWarnings("unchecked")
				List<Object> classes = getSession().createQuery(hql).list();
				HashSet<Object> cla=new HashSet<>(classes);
				Iterator<Object> it = cla.iterator();
				while(it.hasNext()) {
					 Object[] o=(Object[]) it.next();
					ClassRoom c=(ClassRoom)o [0];
					System.out.println(c.toString());
				}
				
				
					
	}

}
