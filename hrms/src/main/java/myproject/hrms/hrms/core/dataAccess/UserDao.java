package myproject.hrms.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.hrms.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
