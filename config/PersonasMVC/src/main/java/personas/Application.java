package personas;

import personas.presentation.personas.Model;
import personas.presentation.personas.View;
import personas.presentation.personas.Controller;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); } catch (Exception ignore) {}

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(view, model);

        JFrame window = new JFrame("Personas");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setContentPane(view.getPanel());
        window.setSize(700, 400);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
