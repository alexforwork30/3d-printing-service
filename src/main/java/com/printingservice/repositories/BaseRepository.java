package com.printingservice.repositories;

import com.printingservice.models.Base;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends Base, ID extends Serializable>
    extends JpaRepository<T, ID> {}
