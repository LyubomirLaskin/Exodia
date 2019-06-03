package exodia.web.beans;

import exodia.domain.models.view.UserHomeViewModel;
import exodia.repository.DocumentRepository;
import exodia.service.DocumentService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class UserHomeBean {

    private List<UserHomeViewModel> viewModels;

    private ModelMapper modelMapper;
    private DocumentService documentService;

    public UserHomeBean() {
    }

    @Inject
    public UserHomeBean(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
        this.initModel();
    }

    private void initModel() {

        this.viewModels = this.documentService.getAllDocuments()
                            .stream()
                            .map(d -> this.modelMapper.map(d, UserHomeViewModel.class))
                            .collect(Collectors.toList());

    }

    public List<UserHomeViewModel> getViewModels() {
        return viewModels;
    }

    public void setViewModels(List<UserHomeViewModel> viewModels) {
        this.viewModels = viewModels;
    }
}
