package org.example.mobilelele.repository;

import org.example.mobilelele.model.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
}
