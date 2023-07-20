package com.brayan.app.rest.Repository;

import com.brayan.app.rest.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

// 3 Tercer paso crear la interfas de repository
public interface TodoRepository extends JpaRepository <Task, Long> {
}
