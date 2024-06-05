module aplicacao {
   
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens aplicacao.responsavel to javafx.fxml;
    opens aplicacao.animal to javafx.fxml;
    opens aplicacao.inicio to javafx.fxml;
    opens aplicacao.agendamento to javafx.fxml;
    opens aplicacao to javafx.fxml;
    opens entidades to javafx.base;
    exports aplicacao;
}
