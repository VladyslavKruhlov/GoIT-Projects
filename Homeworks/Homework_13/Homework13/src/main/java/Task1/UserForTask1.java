package Task1;

class UserForTask1{
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

     public UserForTask1(int id, String name, String username, String email, Address address, String phone, String website, Company company) {
         this.id = id;
         this.name = name;
         this.username = username;
         this.email = email;
         this.address = address;
         this.phone = phone;
         this.website = website;
         this.company = company;
     }

     @Override
     public String toString() {
         return "Task1.Task1.UserForTask1{" +
                 "id=" + id +
                 ", name='" + name + '\'' +
                 ", username='" + username + '\'' +
                 ", email='" + email + '\'' +
                 ", address=" + address +
                 ", phone='" + phone + '\'' +
                 ", website='" + website + '\'' +
                 ", company=" + company +
                 '}';
     }
 }
