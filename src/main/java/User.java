public class User {
    /**
     * @param name      The name of the user
     * @param utorid    The utorid of the user
     * @param email     The uoft email of the user
     * @param location  The location of the user
     */

    final private String name;
    final private String utorid;
    final private String email;
    final private String location;

    public User(String name, String utorid, String email, String location){
        this.name = name;
        this.utorid = utorid;
        this.email = email;
        this.location = location;
    }

}
