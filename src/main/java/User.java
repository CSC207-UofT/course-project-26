public class User {
    /**
     * @param name      The name of the user
     * @param utorid    The utorid of the user
     * @param email     The uoft email of the user
     * @param password  The password of the user
     * @param location  The location of the user
     */

    private String name;
    private final String utorid;
    private final String email;
    private String password;
    private String location;

    public User(String name, String utorid, String email, String password, String location){
        this.name = name;
        this.utorid = utorid;
        this.email = email;
        this.password = password;
        this.location = location;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getUtorid() {
        return this.utorid;
    }

    public String getPassword() {
        return this.password;
    }

    public void setNewPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getEmail() {
        return this.email;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String newLocation) {
        this.location = newLocation;
    }

    @Override
    public String toString() {
        return "User: " + this.name;
    }
}
