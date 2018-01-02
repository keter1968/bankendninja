/**
 * Copyright 2017, Banco Colpatria Multibanca Colpatria S.A.
 * Digital Factory - Colpatria
 * http://www.colpatria.com
 *
 * All rights reserved
 * Date: 02/01/2018
 */
package com.udemy.repository;

import com.udemy.entity.User;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Comment
 *
 * @author <a href="mendezi@colpatria.com">Ivan Alejandro Mendez Suarez</a>
 * @version 3.0.0
 * @since 02/01/2018
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {

  public abstract User findByUsername(String username);

}
