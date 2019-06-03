package exodia.service;

import exodia.domain.entities.Document;
import exodia.domain.models.service.DocumentServiceModel;
import exodia.repository.DocumentRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentServiceImpl implements DocumentService {

    private final ModelMapper modelMapper;
    private final DocumentRepository documentRepository;

    @Inject
    public DocumentServiceImpl(ModelMapper modelMapper, DocumentRepository documentRepository) {
        this.modelMapper = modelMapper;
        this.documentRepository = documentRepository;
    }

    @Override
    public Document scheduleDocument(DocumentServiceModel documentServiceModel) {

       Document document = this.documentRepository.save(this.modelMapper.map(documentServiceModel, Document.class));

       if (document == null){
           return null;
       }else{
           return document;
       }
    }

    @Override
    public DocumentServiceModel getDocumentById(String id) {

        DocumentServiceModel documentServiceModel =
                this.modelMapper.map(this.documentRepository.findById(id), DocumentServiceModel.class);

        if (documentServiceModel == null){
            return null;
        }

        return documentServiceModel;
    }

    @Override
    public DocumentServiceModel getDocumentByTitle(String title) {
        DocumentServiceModel documentServiceModel =
                this.modelMapper.map(this.documentRepository.findByTitle(title), DocumentServiceModel.class);

        if (documentServiceModel == null){
            return null;
        }

        return documentServiceModel;
    }

    @Override
    public List<DocumentServiceModel> getAllDocuments() {

        return  this.documentRepository
                .findAll()
                .stream()
                .map(d -> this.modelMapper.map(d, DocumentServiceModel.class))
                .collect(Collectors.toList());
    }
}
