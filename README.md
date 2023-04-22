# TODO List Application
<hr>

This API provides access to a list of tasks that can be manipulated through various endpoints.

## Features

 - Add a new task
 - Get a list of all tasks
 - Get a specific task by ID
 - Update a specific task by ID
 - Delete a specific task by ID

## API Endpoints

Add a New Task
 -  **Request Method**: POST
 -  **Path**: /api/v1/tasks
 -  **Description**: Creates a new task with the provided data.

Get All Tasks
 -  **Request Method**: GET
 -  **Path**: /api/v1/tasks 
 -  **Description**: Returns a list of all tasks.

Get a Specific Task by ID 
 - **Request Method**: GET
 - **Path**: /api/v1/tasks/{id}
 - **Description**: Returns a task with the provided ID.

 - **Path Parameters**
   -    id (required): The ID of the task to retrieve.

Update a Specific Task by ID
 - **Request Method**: PUT
 - **Path**: /api/v1/tasks/{id}
 - **Description**: Updates a task with the provided ID.
 - **Path Parameters**
   - id (required): The ID of the task to update.

Delete a Specific Task by ID
 - **Request Method**: DELETE
 - **Path**: /api/v1/tasks/{id}
 - **Description**: Deletes a task with the provided ID.
 - **Path Parameters**
   - id (required): The ID of the task to delete.

## Technologies
The following technologies are used in this project:

 - Java 17
 - Micronaut
 - Maven
 - MariaDB

## How to Run
### Prerequisites

Before running the application, you'll need to make sure you have the following software installed:

 - Java Development Kit (JDK) 11 or higher
 - Apache Maven
 - MariaDB database server
 - Installing MariaDB

If you don't have MariaDB installed on your system, you can follow these steps to install it:

Go to the MariaDB download page

Select your operating system and download the appropriate installer

Run the installer and follow the prompts to complete the installation

Make sure the MariaDB server is running before starting the TODO List application

### Configuration
Before running the application, you'll need to configure the database connection settings. Open the application.yml file located in the src/main/resources directory and modify the following properties as necessary:

datasources:<br>
    default: <br>
        url: jdbc:mariadb://localhost:3306/todo <br>
        username: root <br>
        password: root 

 - url: The JDBC URL of your MariaDB server. In this example, the URL assumes that MariaDB is running on the same machine as the TODO List application and listening on port 3306.
 - username: The username used to connect to the MariaDB server.
 - password: The password used to connect to the MariaDB server.

### Building and Running the Application

Once you've installed the necessary software and configured the database connection settings, you can build and run the TODO List application using the following steps:

Open a terminal or command prompt and navigate to the root directory of the TODO List application

Build the application by running the following command: mvn clean install

Once the build completes, start the application by running the following command: mvn mn:run

The application should now be running and accessible at http://localhost:8080.