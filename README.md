📘 Overview ---------->

The Hospital Management System is a Spring Boot application designed to simplify hospital operations such as managing patients, doctors, appointments, and billing.
It provides RESTful APIs for CRUD operations and uses MySQL as the database.

🚀 Features ---------->

👨‍⚕️ Doctor Management — Add, update, view, and delete doctors

🧑‍🤝‍🧑 Patient Management — Manage patient information easily

📅 Appointment Scheduling — Create and view appointments between patients and doctors

💳 Billing System — Generate and manage bills for patients

🗃️ MySQL Integration — Store all records in a relational database.


🧩 Project Structure ----------->

HospitalManagementSystem/
│
├── src/main/java/com/hospitalmanagement/
│   ├── HospitalManagementSystemApplication.java      # Main Spring Boot entry point
│   │
│   ├── controller/                                   # REST Controllers
│   │   ├── DoctorController.java
│   │   ├── PatientController.java
│   │   ├── AppointmentController.java
│   │   └── BillController.java
│   │
│   ├── model/                                        # Entity Classes
│   │   ├── Doctor.java
│   │   ├── Patient.java
│   │   ├── Appointment.java
│   │   └── Bill.java
│   │
│   ├── repository/                                   # JPA Repositories
│   │   ├── DoctorRepository.java
│   │   ├── PatientRepository.java
│   │   ├── AppointmentRepository.java
│   │   └── BillRepository.java
│   │
│   └── service/                                      # Service Layer
│       ├── DoctorService.java
│       ├── PatientService.java
│       ├── AppointmentService.java
│       └── BillService.java
│
├── build.gradle                                      # Gradle build configuration
└── settings.gradle                                   # Project settings

⚙️ Technologies Used ------------>

Java 

Spring Boot 

Spring Data JPA

MySQL Database

Gradle

RESTful APIs

APIs

🧠 How It Works ------------>

Doctors and Patients are managed via RESTful endpoints.

Appointments link doctors with patients.

Bills are generated for patients after appointments.

All data is persisted in MySQL and managed using Spring Data JPA.


🧰 Example API Endpoints ----------->

👨‍⚕️ Doctor
Method	    Endpoint	         Description
POST	      /doctors	         Add a new doctor
GET	        /doctors	         Get all doctors
GET	        /doctors/{id}	     Get doctor by ID
PUT       	/doctors/{id}	     Update doctor details
DELETE    	/doctors/{id}	     Delete doctor


🧑‍🤝‍🧑 Patient
Method	     Endpoint	         Description
POST	       /patients	       Add a new patient
GET	         /patients	       Get all patients
GET        	 /patients/{id}	   Get patient by ID
PUT          /patients/{id}	   Update patient details
DELETE	     /patients/{id}	   Delete patient
