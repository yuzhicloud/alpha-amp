package com.yzcloud.alpha.amp.nm.repository;

import com.yzcloud.alpha.amp.nm.domain.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NodeRepository extends JpaRepository<Node,Long> {
}

