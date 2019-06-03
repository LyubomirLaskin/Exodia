package exodia.domain.models.binding;

public class DocumentScheduleBindingModel {

    private String Title;
    private String content;

    public DocumentScheduleBindingModel() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
