package mriSystem;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
    private ChoiceBox<String> countryChoice1;

    @FXML
    private ChoiceBox<String> countryChoice2;

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
    private ChoiceBox<String> genderChoice;

    @FXML
    private ChoiceBox<String> maritalChoice;

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
    private ChoiceBox<String> stateChoice1;

    @FXML
    private ChoiceBox<String> stateChoice2;

    @FXML
    private ChoiceBox<String> stateChoice3;

    @FXML
    private ChoiceBox<String> stateChoice4;

    @FXML
    private TextField zipCode1;

    @FXML
    private TextField zipCode2;

    ArrayList<Recipient> recipients = new ArrayList<>();
    

    public void initialize(){
    //populates the genderChoice
    genderChoice.getItems().add("Male");
    genderChoice.getItems().add("Female");
    genderChoice.getItems().add("non-binary");

    //populates the maritalChoice
    maritalChoice.getItems().add("married--spouse present");
    maritalChoice.getItems().add("married--spouse absent");
    maritalChoice.getItems().add("widowed");
    maritalChoice.getItems().add("divorced");
    maritalChoice.getItems().add("separated");
    maritalChoice.getItems().add("never married");

    //populates the 4 stateChoices with the states
    for (States st : States.values()) {
        stateChoice1.getItems().add(st + " (" + st.code + ")");
        stateChoice2.getItems().add(st + " (" + st.code+ ")");
        stateChoice3.getItems().add(st + " (" + st.code+ ")");
        stateChoice4.getItems().add(st + " (" + st.code+ ")");
      }
    
    //populates the country choices with only the US for now
    countryChoice1.getItems().add("United States");
    countryChoice2.getItems().add("United States");

    }

    @FXML
    void enterButtonHandle(ActionEvent event) {
        Address currentAddress1 = new Address(address.getText(), city.getText(), stateChoice2.getValue(), countryChoice1.getValue(), zipCode1.getText());
        Address funeralAddress1 = new Address(fAddress.getText(), fCity.getText(), stateChoice3.getValue(), countryChoice2.getValue(), zipCode2.getText());
        Address employerAddress = new Address(null, eCity.getText(), stateChoice4.getValue(), countryChoice2.getValue(), eZipCode.getText());
        FuneralHome funHome1 = new FuneralHome(fHome.getText(), funeralAddress1);
        Employment employment1 = new Employment(employer.getText(), employerAddress, eContactName.getText(), eLastName.getText(), eEmail.getText(), ePhone.getText(), eFax.getText());
        Recipient recipient1 = new Recipient(fName.getText(), ssNumber.getText(), hPhone.getText(), genderChoice.getValue(), mName.getText(), birthDate.getValue(), maritalChoice.getValue(), lName.getText(), maidenName.getText(), placeBirth.getText(), stateChoice1.getValue(),currentAddress1,funHome1, employment1);
        recipients.add(recipient1);
        //System.out.println(recipient1.toString());
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Enter button");
        alert.setHeaderText("The Recipient's information has been addded.");
        alert.setContentText(recipient1.toString());
        alert.showAndWait().ifPresent(rs -> {
        if (rs == ButtonType.OK) {
            System.out.println("Pressed OK.");
        }
        });
    }

    @FXML
    void importButtonHandle(ActionEvent event) {
        System.out.println("import button pressed");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Import button");
        alert.setHeaderText("The Import Button was pressed");
        alert.setContentText("I have a great message for you!");
        alert.showAndWait().ifPresent(rs -> {
        if (rs == ButtonType.OK) {
            System.out.println("Pressed OK.");
        }
        });
    }

    @FXML
    void lifeButtonHandle(ActionEvent event) {
        System.out.println("lifebutton presssed");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Life Button");
        alert.setHeaderText("The Life Import button was pressed");
        alert.setContentText("I have a great message for you!");
        alert.showAndWait().ifPresent(rs -> {
        if (rs == ButtonType.OK) {
            System.out.println("Pressed OK.");
        }
        });
    }

    
}
