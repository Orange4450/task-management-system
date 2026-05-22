package com.Boltabay_Zhaniya.taskmanagement.repository;
import com.Boltabay_Zhaniya.taskmanagement.entity.Boltabay_Zhaniya_Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Boltabay_Zhaniya_TaskRepository extends JpaRepository<Boltabay_Zhaniya_Task, Long> {
    Page<Boltabay_Zhaniya_Task> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);
}