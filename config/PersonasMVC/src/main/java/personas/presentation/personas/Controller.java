package personas.presentation.personas;

import personas.logic.Persona;
import personas.logic.Service;

import java.io.IOException;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void read(String id) throws Exception {
        Persona e = new Persona();
        e.setId(id);
        model.setCurrent(Service.instance().read(e));
    }

}

