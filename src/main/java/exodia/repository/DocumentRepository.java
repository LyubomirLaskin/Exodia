package exodia.repository;

import exodia.domain.entities.Document;


public interface DocumentRepository extends GenericRepository<Document, String> {

    Document findByTitle(String title);

}
