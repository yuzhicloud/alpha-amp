package com.yzcloud.alpha.amp.diagnose.repository;


import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnoseJobRepository extends JpaRepository<DiagnoseJob,Long> {
}