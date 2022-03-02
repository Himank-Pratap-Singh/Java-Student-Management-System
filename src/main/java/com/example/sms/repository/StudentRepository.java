package com.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.Student;


// We don't have to write @repository annotation because this JpaRepository interface have a default 
// implementation class that is simpleJpaRepository and this class already has @repository annotation
// Jpa repository has two parameter first one is type of jpaEntity and 2 one is type of primary key

// JPArepository interface by default provide a transactional annotation for all its method
public interface StudentRepository extends JpaRepository<Student, Long> {

	  
	
}
  