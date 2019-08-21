package com.edujavaonline.gerenciadorgastos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edujavaonline.gerenciadorgastos.api.model.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

}
