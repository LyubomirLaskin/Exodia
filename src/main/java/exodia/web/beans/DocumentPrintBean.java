package exodia.web.beans;

import exodia.domain.models.view.DocumentPrintViewModel;
import exodia.repository.DocumentRepository;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class DocumentPrintBean {

    private DocumentPrintViewModel viewModel;

    private DocumentRepository documentRepository;
    private ModelMapper modelMapper;

    public DocumentPrintBean() {
    }

    public DocumentPrintBean(DocumentRepository documentRepository, ModelMapper modelMapper) {
        this.documentRepository = documentRepository;
        this.modelMapper = modelMapper;
        this.initModel();
    }

    private void initModel() {

    }
}
