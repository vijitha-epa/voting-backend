package info.slnews.app.entity;

import info.slnews.app.enums.UserStatus;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "member_info")
public class MemberInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 15, nullable = false)
    private String title;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "address", length = 300)
    private String address;

    @Column(name = "dateOfBirth")
    private Instant dateOfBirth;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "phoneNo", length = 12)
    private String phoneNo;

    @Column(name = "image", length = 250)
    private String image;

    @Column(name = "createdOn")
    private Instant createdOn;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "updatedOn")
    private Instant updatedOn;

    public MemberInfo() {
    }

    public MemberInfo(Long id, String title, String name, String address, Instant dateOfBirth, String email,
                      String phoneNo,
                      String image,
                      Instant createdOn, UserStatus status, Instant updatedOn) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNo = phoneNo;
        this.image = image;
        this.createdOn = createdOn;
        this.status = status;
        this.updatedOn = updatedOn;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getImage() {
        return image;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public UserStatus getStatus() {
        return status;
    }

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        updatedOn = Instant.now();
        if(createdOn == null) {
            createdOn = Instant.now();
        }
    }
}
