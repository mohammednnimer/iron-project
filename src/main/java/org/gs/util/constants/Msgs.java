package org.gs.util.constants;

public interface Msgs {
    // Auth
    String INVALID_CREDENTIALS = "Invalid username or password";
    String INVALID_TOKEN = "Invalid or expired token";
    String TOKEN_GENERATION_FAILED = "Failed to generate token";
    String USER_INACTIVE = "User account is inactive";
    String SUCCESS = "Login successful";
    String USERNAME_EXIST = "User with same username already exists";
    String USER_SUCC = "User created successfully";
    String USER_DELETED = "User deleted";
    String USER_NOT_FOUND = "User not found";

    // Iron Types
    String CREATED_SUCCESS = "Created succeeded";
    String OBJECT_EXIST = "Sorry the object is already exist";
    String OK = "ok";
    String NOT_FOUND = "Not found";
    String CUSTOMER_NOT_FOUND = "Customer not found";

    // Iron Shapes / Depth
    String REFERENCE_EXISTS = "txtReference already exists";
    String UPDATED_SUCCESS = "Updated successfully";
    String REFERENCE_NOT_FOUND = "No record found with the given txtReference";
    String DELETED_SUCCESS = "Deleted successfully";

    // Customers
    String CUSTOMER_CREATED_SUCCESS = "Customer created successfully";
    String CUSTOMER_REFERENCE_EXISTS = "Customer with this References already exists";
    String CUSTOMER_UPDATED_SUCCESS = "Customer updated successfully";
}
