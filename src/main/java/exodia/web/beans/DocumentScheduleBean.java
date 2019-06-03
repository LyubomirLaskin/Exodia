package exodia.web.beans;

import exodia.domain.models.binding.DocumentScheduleBindingModel;
import exodia.domain.models.service.DocumentServiceModel;
import exodia.service.DocumentService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class DocumentScheduleBean {

    private DocumentScheduleBindingModel model;

    private ModelMapper modelMapper;
    private DocumentService documentService;

    public DocumentScheduleBean() {
    }

    @Inject
    public DocumentScheduleBean(ModelMapper modelMapper, DocumentService documentService) {
        this.modelMapper = modelMapper;
        this.documentService = documentService;
        this.initModel();
    }

    private void initModel() {
        this.model = new DocumentScheduleBindingModel();
    }

    public DocumentScheduleBindingModel getModel() {
        return model;
    }

    public void setModel(DocumentScheduleBindingModel model) {
        this.model = model;
    }

    public void schedule() throws IOException {

        DocumentServiceModel documentServiceModel = this.modelMapper.map(this.model, DocumentServiceModel.class);

        if (this.documentService.scheduleDocument(documentServiceModel) == null){
            throw new IllegalArgumentException("Something went wrong!");
        }

        String docId = this.documentService.getDocumentByTitle(documentServiceModel.getTitle()).getId();

        FacesContext.getCurrentInstance().getExternalContext().redirect("/details?id=" + docId);
    }
}
