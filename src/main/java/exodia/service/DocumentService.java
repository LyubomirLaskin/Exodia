package exodia.service;

import exodia.domain.entities.Document;
import exodia.domain.models.service.DocumentServiceModel;

import java.util.List;

public interface DocumentService {

    Document scheduleDocument(DocumentServiceModel documentServiceModel);

    DocumentServiceModel getDocumentById(String id);

    DocumentServiceModel getDocumentByTitle(String title);

    List<DocumentServiceModel> getAllDocuments();

}
