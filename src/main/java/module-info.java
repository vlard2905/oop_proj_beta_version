module app.oop_proj {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens app.oop_proj to javafx.fxml;
    exports app.oop_proj;
    exports app.oop_proj.museums;
    opens app.oop_proj.museums to javafx.fxml;
    exports app.oop_proj.controllers;
    opens app.oop_proj.controllers to javafx.fxml;
    exports app.oop_proj.custom_exceptions;
    opens app.oop_proj.custom_exceptions to javafx.fxml;
    exports app.oop_proj.general_logic;
    opens app.oop_proj.general_logic to javafx.fxml;
}