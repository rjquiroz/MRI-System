package mriSystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.sql.*;

public class Controller {

    Connection conn = null;
    private Statement stmt = null;

    private ObservableList<Recipient> recipients;

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
    private Text beneficiaryLastAnswer;

    @FXML
    private Text beneficiaryNameAnswer;

    @FXML
    private Text cityTableAnswer;

    @FXML
    private Text companyAnswer;

    @FXML
    private Text dueOnAnswer;

    @FXML
    private Text faceValueAnswer;

    @FXML
    private Text mqyAnswer;

    @FXML
    private Text policyNumberAnswer;

    @FXML
    private Text policyTypeAnswer;

    @FXML
    private Text relationshipAnswer;

    @FXML
    private Text stateTableAnswer;

    @FXML
    private Text statusAnswer;

    @FXML
    private Text zipCodeTableAnswer;

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
    private Button SearchButton;

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

    @FXML
    private TableView<InforcePolicy> TableView;

    @FXML
    private TableView<Report> TableView4;

    @FXML
    private TableColumn<?, ?> BenefitsColumn;

    @FXML
    private TableColumn<?, ?> annuitiesColumn;

    @FXML
    private TableColumn<?, ?> balanceColumn;

    @FXML
    private TableColumn<?, ?> clientID;

    @FXML
    private TableColumn<?, ?> fNameColumn;

    @FXML
    private TableColumn<?, ?> faceAmountColumn;

    @FXML
    private TableColumn<?, ?> lNameColumn;

    @FXML
    private TableColumn<?, ?> lifeCompanyColumn;

    @FXML
    private TableColumn<?, ?> policyNumberColumn4;

    @FXML
    private TableColumn<?, ?> policyTypeColumn4;

    @FXML
    private TableColumn<?, ?> ssnColumn;

    @FXML
    private TableColumn<?, ?> stateColumn;

    @FXML
    private TableColumn<?, ?> totalFaceAmountColumn;

    @FXML
    private TableColumn<?, ?> faceValueColumn;

    @FXML
    private TableColumn<?, ?> isTherePremiumColumn;

    @FXML
    private TableColumn<?, ?> policyDesignationColumn;

    @FXML
    private TableColumn<?, ?> policyNumberColumn;

    @FXML
    private TableColumn<?, ?> policyTypeColumn;

    @FXML
    private TableColumn<?, ?> premiumAmountColumn;

    @FXML
    private TableColumn<?, ?> providerColumn;

    ObservableList<InsuranceCompany> insuranceCompanies;
    ObservableList<String> companiesName;

    ObservableList<InforcePolicy> inforcePolicies;

    ObservableList<Report> reports;

    /**
     * Did this commit and push?
     */


    /**
     * Methods to initialize and close database connection.
     */
    public void initializeDataBase() {

        // Connection to the database
        // JDBC driver name and database URL
        final String Jdbc_Driver = "org.h2.Driver";
        final String Db_Url = "jdbc:h2:./res/MRI_Data";


        try {
            Class.forName(Jdbc_Driver);

            conn = DriverManager.getConnection(Db_Url);
            stmt = conn.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Unable to find class");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error in SQL please try again");
        }
    }

    public void closeDb() {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * INITIALIZE TABLE FIELD OPTIONS
     * Adds options to the various selection boxes in the program
     * i.e. Gender, marital status, and etc.
     */
    public void initialize(){
        insuranceCompanies = FXCollections.observableArrayList();
        companiesName = FXCollections.observableArrayList();
        inforcePolicies = FXCollections.observableArrayList();
        reports = FXCollections.observableArrayList();
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

        //set the column values of the tableView.
        policyNumberColumn.setCellValueFactory(new PropertyValueFactory("policyNumber"));
        faceValueColumn.setCellValueFactory(new PropertyValueFactory("faceValue"));
        providerColumn.setCellValueFactory(new PropertyValueFactory("Provider"));
        policyTypeColumn.setCellValueFactory(new PropertyValueFactory("policyType"));
        policyDesignationColumn.setCellValueFactory(new PropertyValueFactory("policyDesignation"));
        isTherePremiumColumn.setCellValueFactory(new PropertyValueFactory("isTherePremium"));
        premiumAmountColumn.setCellValueFactory(new PropertyValueFactory("premiumAmount"));

        //set the column values of the tableView in tab 4.
        stateColumn.setCellValueFactory(new PropertyValueFactory("state"));
        fNameColumn.setCellValueFactory(new PropertyValueFactory("fName"));
        lNameColumn.setCellValueFactory(new PropertyValueFactory("lName"));
        clientID.setCellValueFactory(new PropertyValueFactory("id"));
        ssnColumn.setCellValueFactory(new PropertyValueFactory("ssn"));
        lifeCompanyColumn.setCellValueFactory(new PropertyValueFactory("lifeCompany"));
        policyNumberColumn4.setCellValueFactory(new PropertyValueFactory("policyNumber"));
        policyTypeColumn4.setCellValueFactory(new PropertyValueFactory("policyType"));
        faceAmountColumn.setCellValueFactory(new PropertyValueFactory("faceAmount"));
        annuitiesColumn.setCellValueFactory(new PropertyValueFactory("annuityCompany"));
        totalFaceAmountColumn.setCellValueFactory(new PropertyValueFactory("totalFaceAmount"));
        BenefitsColumn.setCellValueFactory(new PropertyValueFactory("benefitPayouts"));
        balanceColumn.setCellValueFactory(new PropertyValueFactory("balance"));


        //loads the products from the database.
        try {
            loadCompaniesList();
            loadInforcedPolicies();
            loadReports();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //populates the listView in tab2
        listView.setItems(insuranceCompanies);

        //populates tableView in tab3
        TableView.setItems(inforcePolicies);

        //loads the database into tableView of reports in tab4
        TableView4.setItems(reports);

    }

    /**
     * ADD RECIPIENT BUTTON
     * takes the information from the related texts fields to
     * create a new entry in MRI's Database
     */
    @FXML
    void addRecipient(ActionEvent event){
        initializeDataBase();

        try {

            String newFirstName = fName.getText();
            String newLastName = lName.getText();
            String newMiddleName = mName.getText();
            String newGender = genderChoice.getValue();
            String newBirthday = String.valueOf(birthDate.getValue());
            String newBirthPlace = placeBirth.getText();
            String newMaritalStatus = maritalChoice.getValue();
            String newMaidenName = maidenName.getText();
            String newSSN = ssNumber.getText();
            String newPhone = hPhone.getText();
            String newState = stateChoice1.getValue();
            String newAddress = address.getText();
            String newFuneral = fHome.getText();
            String newEmployer = employer.getText();

            String preparedStm = "INSERT INTO RECIPIENT(FIRST_NAME, LAST_NAME, MIDDLE_NAME, GENDER, BIRTHDAY, BIRTHPLACE, MARITAL_STATUS, MAIDEN_NAME, SSN, PHONE, STATE, ADDRESS,FUNERAL_HOME, EMPLOYER) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = conn.prepareStatement(preparedStm);
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setString(2, newLastName);
            preparedStatement.setString(3, newMiddleName);
            preparedStatement.setString(4, newGender);
            preparedStatement.setString(5, String.valueOf(newBirthday));
            preparedStatement.setString(6, newBirthPlace);
            preparedStatement.setString(7, newMaritalStatus);
            preparedStatement.setString(8, newMaidenName);
            preparedStatement.setString(9, newSSN);
            preparedStatement.setString(10, newPhone);
            preparedStatement.setString(11, newState );
            preparedStatement.setString(12, newAddress);
            preparedStatement.setString(13, newFuneral);
            preparedStatement.setString(14, newEmployer);
            preparedStatement.execute();

        }
        catch (SQLException e) {
            e.printStackTrace();

        }
        /*
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


         */
    }

    /**
     * IMPORT FROM CMS BUTTON
     * As of writing, we don't have access to CMS to import data on
     * Medicaid recipients. This button doesn't have any functional
     * and only serves to illustrate future improvements that we would
     * like to make.
     */
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

    @FXML
    /**
     * tableView in tab3 when clicking in an object it will display the details underneath
     */
    void onClickTableViewHandle(javafx.scene.input.MouseEvent event) {
        policyNumberAnswer.setText(TableView.getSelectionModel().getSelectedItem().getPolicyNumber());
        statusAnswer.setText(TableView.getSelectionModel().getSelectedItem().getStatus());
        policyTypeAnswer.setText(TableView.getSelectionModel().getSelectedItem().getPolicyType());
        companyAnswer.setText(TableView.getSelectionModel().getSelectedItem().getProvider().getName());
        faceValueAnswer.setText(String.valueOf(TableView.getSelectionModel().getSelectedItem().getFaceValue() + "$"));
        mqyAnswer.setText(TableView.getSelectionModel().getSelectedItem().getMqy());
        cityTableAnswer.setText(TableView.getSelectionModel().getSelectedItem().getProvider().getAddress().getCity());
        stateTableAnswer.setText(TableView.getSelectionModel().getSelectedItem().getProvider().getAddress().getState());
        beneficiaryNameAnswer.setText(TableView.getSelectionModel().getSelectedItem().getBeneficiary().getfName());
        beneficiaryLastAnswer.setText(TableView.getSelectionModel().getSelectedItem().getBeneficiary().getlName());
        relationshipAnswer.setText(TableView.getSelectionModel().getSelectedItem().getBeneficiary().getRelationship());
        dueOnAnswer.setText(String.valueOf(TableView.getSelectionModel().getSelectedItem().getDueOn()));
        zipCodeTableAnswer.setText(TableView.getSelectionModel().getSelectedItem().getBeneficiary().getZipcode());
    }

    /**
         * method that loads the database into the listView on tab2
         * connects to the database, select the insurance companies from it and then load it into
         * a observable list that is going to the listView.
         */
    public void loadCompaniesList() throws SQLException {

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
                companiesName.add(insuranceCompanyFromDB.getName());

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

    /**
     * method that loads the inforced policies database into the tableView on tab3
     * connects to the database, select the policies from it and then load it into
     * a observable list that is going to the tableView.
     */
    public void loadInforcedPolicies() throws SQLException {

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

            String sql = "SELECT * FROM INFORCEPOLICIES";


            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                // these lines correspond to the database table columns

                String policyNumber = rs.getString(1);
                double faceValue = rs.getDouble(2);
                String FaceValueDue = rs.getString(3);
                String provider = rs.getString(4);
                String providerCity = rs.getString(5);
                String providerState = rs.getString(6);
                String policyType = rs.getString(7);
                String designation = rs.getString(8);
                boolean isTherePremium = rs.getBoolean(9);
                double premiumAmount = rs.getDouble(10);
                String status = rs.getString(11);
                Date dueOn = rs.getDate(12);
                String beneficiary = rs.getString(13);
                String beneficiaryLast = rs.getString(14);
                String relationship = rs.getString(15);
                String zipcode = rs.getString(16);
                String mqy = rs.getString(17);

                //create new object
                Beneficiary beneficiary1 = new Beneficiary(beneficiary, beneficiaryLast, relationship, zipcode);
                InforcePolicy policy = null;
                for (InsuranceCompany company : insuranceCompanies) {
                    if (company.getName().equals(provider)) {
                        policy = new InforcePolicy(null, policyNumber, faceValue, company, policyType, designation, isTherePremium, premiumAmount, status, dueOn, beneficiary1, mqy) {
                        };
                    }
                }

                // save to observable list
                inforcePolicies.add(policy);

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

    /**
     * method that loads the database into the tableView on tab4
     * connects to the database, select the report from it and then load it into
     * a observable list that is going to the tableView.
     */
    public void loadReports() throws SQLException {

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

            String sql = "SELECT * FROM REPORTS";


            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                // these lines correspond to the database table columns

                String state = rs.getString(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                int id = rs.getInt(4);
                String ssn = rs.getString(5);
                String lifeCompany = rs.getString(6);
                String policyNumber = rs.getString(7);
                String policyType = rs.getString(8);
                double faceAmount = rs.getDouble(9);
                String annuityCompany = rs.getString(10);
                double totalFaceAmount = rs.getDouble(11);
                double benefitsPayouts = rs.getDouble(12);
                double balance = rs.getDouble(13);

                // create object
                Report report = new Report(fName,lName,ssn,state,id,lifeCompany,policyNumber,policyType,faceAmount,benefitsPayouts,totalFaceAmount,annuityCompany) {
                };
                report.calculateBalance(totalFaceAmount,benefitsPayouts);
                // save to observable list
                reports.add(report);

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
