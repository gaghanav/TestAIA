package com.valen.aiatest2.repositories;

import com.valen.aiatest2.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {
}
