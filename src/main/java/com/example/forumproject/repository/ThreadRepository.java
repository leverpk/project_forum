package com.example.forumproject.repository;

import com.example.forumproject.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ThreadRepository extends JpaRepository<Thread, Long> {

    List<Thread> findThreadsByUser(String user);

    // TODO: zaimplementować repozytorium

}
