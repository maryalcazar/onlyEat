package org.learning.repository;

import org.learning.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	@Query(" select c from Client c where c.email = :email and c.password= :psw ")
	public Client findUser(@Param("email") String correo, @Param("psw") String password);
	
	@Query(" select c.id from Client c where c.email = :email ")
	public Integer getIdByEmail(@Param("email") String correo);
	
	@Query(nativeQuery = true, value = " select C.id from CLIENTE C where C.email = ? ")
	public Integer getIdByEmailNative(String correo);
}
