package mriSystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

public class Controller {

    @FXML
    private Text CompanyNameAnswer;

    @FXML
    private Text AddressAnswer;

    @FXML
    private Text AltPhoneAnswer;

    @FXML
    private Text CityAnswer;

    @FXML
    private Text ContactEmailAnswer;

    @FXML
    private Text ContactFaxAnswer;

    @FXML
    private Text ContactPhoneAnswer;

    @FXML
    private Text CountryAnswer;

    @FXML
    private Text FaxAnswer;

    @FXML
    private Text FnameAnswer;

    @FXML
    private Text LnameAnswer;

    @FXML
    private Text MnameAnswer;


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
    private Text PhoneAnswer;

    @FXML
    private Text StateAnswer;

    @FXML
    private Text ZipAnswer;

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
    private Button recipientButton;

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

    @FXML
    private ListView<InsuranceCompany> listView;

    ArrayList<Recipient> recipients = new ArrayList<>();

    ObservableList<InsuranceCompany> insuranceCompanies;
    /**
     * Did this commit and push?
     */

    public void initialize(){
        insuranceCompanies = FXCollections.observableArrayList();
        //populates genderChoicesBox
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

        //loads the products from the database.
        try {
            loadProductList();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //populates the listView in tab2
        listView.setItems(insuranceCompanies);

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
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Enter button");
        alert.setHeaderText("The Recipient's information has been added.");
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
        System.out.println("lifebutton pressed");
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

    /**Shows the detailed information about the life insurance company when a company is selected.*/
    @FXML
    public void onClickHandle(javafx.scene.input.MouseEvent mouseEvent) {
        CompanyNameAnswer.setText(listView.getSelectionModel().getSelectedItem().getName());
        AddressAnswer.setText(listView.getSelectionModel().getSelectedItem().getAddress().getStreet());
        CityAnswer.setText(listView.getSelectionModel().getSelectedItem().getAddress().getCity());
        StateAnswer.setText(listView.getSelectionModel().getSelectedItem().getAddress().getState());
        CountryAnswer.setText(listView.getSelectionModel().getSelectedItem().getAddress().getCountry());
        PhoneAnswer.setText(listView.getSelectionModel().getSelectedItem().getPhone());
        FaxAnswer.setText(listView.getSelectionModel().getSelectedItem().getFax());
        ZipAnswer.setText(listView.getSelectionModel().getSelectedItem().getAddress().getZipcode());
        FnameAnswer.setText(listView.getSelectionModel().getSelectedItem().getContactName());
        MnameAnswer.setText(listView.getSelectionModel().getSelectedItem().getContactMidName());
        LnameAnswer.setText(listView.getSelectionModel().getSelectedItem().getContactLastName());
        ContactPhoneAnswer.setText(listView.getSelectionModel().getSelectedItem().getContactPhone());
        ContactFaxAnswer.setText(listView.getSelectionModel().getSelectedItem().getContactFax());
        ContactEmailAnswer.setText(listView.getSelectionModel().getSelectedItem().getContactEmail());
        AltPhoneAnswer.setText(listView.getSelectionModel().getSelectedItem().getAltPhone());

    }

    /**
     * method that loads the database into the listView on tab2
     * connects to the database, select the insurance companies from it and then load it into
     * a observable list that is going to the listView.
     */
    public void loadProductList() throws SQLException {

        final String jdbc_Driver = "org.h2.Driver";
        final String db_Url = "jdbc:h2:./res/MRI_Data";

        //  Database credentials
        final String user = "";
        final String pass = "";
        Connection conn = null;
        Statement stmt = null;

        try {
            // STEP 1: Register JDBC driver
            Class.forName(jdbc_Driver);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(db_Url, user, pass);

            //STEP 3: Execute a query
            stmt = conn.createStatement();

            String sql = "SELECT * FROM INSURANCECOMPANIES";


            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                // these lines correspond to the database table columns

                String companyName = rs.getString(1);
                String phone = rs.getString(7);
                String fax = rs.getString(8);
                String contactFName = rs.getString(9);
                String contactMName = rs.getString(10);
                String contactLName = rs.getString(11);
                String contactPhone = rs.getString(12);
                String contactFax = rs.getString(13);
                String contactEmail = rs.getString(14);
                String contactAltPhone = rs.getString(15);

                // create object
                Address companyAddress = new Address(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                InsuranceCompany insuranceCompanyFromDB = new InsuranceCompany(companyName,phone,fax,companyAddress,contactFName,contactMName,contactLName,contactPhone,contactFax,contactAltPhone,contactEmail) {
                };

                // save to observable list
                insuranceCompanies.add(insuranceCompanyFromDB);

            }
            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
