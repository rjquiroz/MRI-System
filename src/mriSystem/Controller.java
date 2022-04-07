package mriSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Tab MonitorTab;

    @FXML
    private Tab ProvidersTab;

    @FXML
    private Tab RecipientsTab;

    @FXML
    private Tab ReportsTab;

    @FXML
    private TabPane TabPane;

    @FXML
    private TextField address;

    @FXML
    private DatePicker birthDate;

    @FXML
    private TextField city;

    @FXML
    private ChoiceBox<?> countryChoice1;

    @FXML
    private ChoiceBox<?> countryChoice2;

    @FXML
    private TextField eCity;

    @FXML
    private TextField eContactName;

    @FXML
    private TextField eEmail;

    @FXML
    private TextField eFax;

    @FXML
    private TextField eLastName;

    @FXML
    private TextField ePhone;

    @FXML
    private TextField eZipCode;

    @FXML
    private TextField employer;

    @FXML
    private Button enterButton;

    @FXML
    private TextField fAddress;

    @FXML
    private TextField fCity;

    @FXML
    private TextField fHome;

    @FXML
    private TextField fName;

    @FXML
    private ChoiceBox<?> genderChoice;

    @FXML
    private TextField hPhone;

    @FXML
    private Button importButton;

    @FXML
    private TextField lName;

    @FXML
    private Button lifeButton;

    @FXML
    private TextField mName;

    @FXML
    private TextField maidenName;

    @FXML
    private TextField placeBirth;

    @FXML
    private TextField ssNumber;

    @FXML
    private ChoiceBox<?> stateChoice1;

    @FXML
    private ChoiceBox<?> stateChoice2;

    @FXML
    private ChoiceBox<?> stateChoice3;

    @FXML
    private ChoiceBox<?> stateChoice4;

    @FXML
    private TextField zipCode1;

    @FXML
    private TextField zipCode2;

    @FXML
    void enterButtonHandle(ActionEvent event) {
        System.out.println("enterbutton pressed");
    }

    @FXML
    void importButtonHandle(ActionEvent event) {
        System.out.println("import button pressed");
    }

    @FXML
    void lifeButtonHandle(ActionEvent event) {
        System.out.println("lifebutton presssed");
    }

}
