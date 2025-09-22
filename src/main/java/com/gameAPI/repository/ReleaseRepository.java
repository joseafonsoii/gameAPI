package com.gameAPI.repository;

import com.gameAPI.model.Release;
import com.gameAPI.model.ReleaseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReleaseRepository extends JpaRepository<Release, ReleaseId> , JpaSpecificationExecutor<Release> {

}
