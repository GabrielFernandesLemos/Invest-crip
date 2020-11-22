package investcrip.com.invest_crip.features.register.model;

public class Customer {
    public Long id;
    public String name;
    public String email;
    public String cpf;
    public String birthday;
    public String phoneNumber;
    public String balance;

    public Customer(Long id, String name, String email, String cpf, String birthday, String phoneNumber, String balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
