package judgels.jophiel.hibernate;

import java.util.Optional;
import javax.inject.Inject;
import judgels.jophiel.persistence.UserRoleDao;
import judgels.jophiel.persistence.UserRoleModel;
import judgels.jophiel.persistence.UserRoleModel_;
import judgels.persistence.hibernate.HibernateDao;
import judgels.persistence.hibernate.HibernateDaoData;

public class UserRoleHibernateDao extends HibernateDao<UserRoleModel> implements UserRoleDao {
    @Inject
    public UserRoleHibernateDao(HibernateDaoData data) {
        super(data);
    }

    @Override
    public Optional<UserRoleModel> selectByUserJid(String userJid) {
        return select().where(columnEq(UserRoleModel_.userJid, userJid)).unique();
    }
}
