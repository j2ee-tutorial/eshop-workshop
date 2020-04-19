package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.Role;
import com.tasnim.trade.eshop.to.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
