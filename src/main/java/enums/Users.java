package enums;

public enum Users {

    PITER_CHAILOVSKII ("PITER CHAILOVSKII", "epam", "1234");
    public String username;
    public String login;
    public String password;

    Users(String username, String login, String password){
        this.username = username;
        this.login = login;
        this.password = password;
    }

    public static Users getUser(String name){
        for( Users user : Users.values()){
            if (user.username.equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    @Override
    public String toString() {return username; }
}
