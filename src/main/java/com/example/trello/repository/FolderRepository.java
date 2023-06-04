package com.example.trello.repository;

import com.example.trello.entities.Folders;
import groovyjarjarantlr4.v4.codegen.model.LabeledOp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folders, Long> {

    Folders findAllById(Long id);
}
