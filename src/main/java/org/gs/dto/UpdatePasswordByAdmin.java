package org.gs.dto;

public class UpdatePasswordByAdmin {

    private String username;

    private String newPassword;
    public UpdatePasswordByAdmin(String name, String newPassword) {
        this.username = name;

        this.newPassword = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
