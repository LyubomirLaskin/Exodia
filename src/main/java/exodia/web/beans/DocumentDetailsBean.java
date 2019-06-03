package exodia.web.beans;

import exodia.domain.models.service.DocumentServiceModel;
import exodia.domain.models.view.DocumentDetailsViewModel;
import exodia.service.DocumentService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class DocumentDetailsBean {

    private DocumentDetailsViewModel model;

    private ModelMapper modelMapper;
    private DocumentService documentService;

    public DocumentDetailsBean() {
    }

    @Inject
    public DocumentDetailsBean(ModelMapper modelMapper, DocumentService documentService) {
        this.modelMapper = modelMapper;
        this.documentService = documentService;
        this.initModel();
    }

    private void initModel() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        String id = request.getParameter("id");

        DocumentServiceModel documentServiceModel = this.documentService.getDocumentById(id);

        if (documentServiceModel == null){
            throw new IllegalArgumentException("Could not find that document!");
        }

        this.model = this.modelMapper.map(documentServiceModel, DocumentDetailsViewModel.class);
    }

    public DocumentDetailsViewModel getModel() {
        return model;
    }

    public void setModel(DocumentDetailsViewModel model) {
        this.model = model;
    }
}
