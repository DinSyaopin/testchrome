package parsefile;

public class Scenary {
    private String action;
    private String params;
    private String description;

    public Scenary() {
    }

    public Scenary(String action, String params) {
        this.action = action;
        this.params = params;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Scenary{" +
                "action='" + action + '\'' +
                ", params='" + params + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
