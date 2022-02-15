# Task Management API

A Craftsoft Technical Test

## Main Concept
The project is mainly a backend for a Task Management System that exposes API for relevant requests. I followed the MVC pattern because it is easier to comprehend alongside being efficient as well. My project has several blocks such as Model Classes, Controllers, Services, and Repositories. 

In the repository layer, I've used the JpaRespository because I worked with Spring Data JPA.
In the service layers, I am working with the respective repository to fetch/update data and then processing that data according to the incoming request.
In the controller (which is our REST API layer), I am calling the relevant service layer to provide me with the desired responses.



## Steps to run it locally
To run this project locally, you need to have the environment ready which includes:
> OpenJDK 11, Spring Boot, Maven, IntelliJ IDEA

After setting up the environment, you only need to import the project into IntelliJ IDEA and wait for it to be ready. Once ready, you need to run the main method. If you want to run the project on a separate port other than the default 8080, you need to change it in the **application.properties** file.


## Future Improvements

- **Task and SubTask**: If I knew more details about SubTask, I could have approached it another way. But, for now, the SubTask is also a Task. It could have been a separate class based on the nature of the SubTask in general.
- **Delete**: The deletion of a task is sensitive. Right now, I have deleted a task permanently from the Database, but as it is part of our data, we can keep the data intact but privately so that it is no more accessible to the end-users. It will depend on the requirements.
- **TaskGroup**: A TaskGroup can be a separate model if I want to keep some more information about that category. Right now, I have kept it as an ENUM.
- **Agent (Assignee)**: It is a separate model but has only two attributes right now. A **userName** String and an **email** String. Currently, **userName** is considered unique. But we can go for a unique ID depending on how we want to handle it.
- **Unit Tests**: I didn't write tests for all of the available services, but covered the basic CRUD. The rest of the tests should also be similar.



