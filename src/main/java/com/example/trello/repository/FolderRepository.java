package com.example.trello.repository;

import com.example.trello.entities.Folders;
import groovyjarjarantlr4.v4.codegen.model.LabeledOp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FolderRepository extends JpaRepository<Folders, Long> {
    Folders findAllById(Long id);
}
